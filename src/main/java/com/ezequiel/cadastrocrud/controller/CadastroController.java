package com.ezequiel.cadastrocrud.controller;

import com.ezequiel.cadastrocrud.domain.User;
import com.ezequiel.cadastrocrud.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML
    private Button bt_deletar;

    @FXML
    private Button bt_editar;

    @FXML
    private Button bt_salvar;

    @FXML
    private RadioButton rb_feminino;

    @FXML
    private RadioButton rb_masculino;

    @FXML
    private ToggleGroup sexo;

    @FXML
    private TableColumn<User, Long> tc_id;

    @FXML
    private TableColumn<User, Integer> tc_idade;

    @FXML
    private TableColumn<User, String> tc_nome;

    @FXML
    private TableColumn<User, String> tc_sexo;

    @FXML
    private TextField tf_idade;

    @FXML
    private TextField tf_nome;

    @FXML
    private TableView tv_campo_bd;

    User user = new User();
    UserService userService = new UserService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prepararTabela();
        ocultarBotoes();
    }

    @FXML
    public void salvarDados(ActionEvent event){

        if (validar()) {
            user.setNome(tf_nome.getText());
            user.setIdade(Integer.parseInt(tf_idade.getText()));

            if (rb_masculino.isSelected()) {
                user.setSexo("Masculino");
            }

            if (rb_feminino.isSelected()) {
                user.setSexo("Feminino");
            }

            userService.inserir(user);
            prepararTabela();
            limpar();

            System.out.println("Usuário salvo");
        }
    }

    @FXML
    void preencherCampos(MouseEvent event){
        user  =  (User) tv_campo_bd.getSelectionModel().getSelectedItem();

        if (user != null){

            bt_salvar.setVisible(false);
            bt_editar.setVisible(true);
            bt_deletar.setVisible(true);

            tf_nome.setText(user.getNome());
            tf_idade.setText(String.valueOf(user.getIdade()));

            if (user.getSexo().equals("Masculino")){
                rb_masculino.setSelected(true);
            } else if (user.getSexo().equals("Feminino")) {
                rb_feminino.setSelected(true);
            }
        }
    }

    @FXML
    void editarDados(ActionEvent event){
        if (validar()){
            user.setNome(tf_nome.getText());
            user.setIdade(Integer.parseInt(tf_idade.getText()));

            if (rb_masculino.isSelected()) {
                user.setSexo("Masculino");
            }

            if (rb_feminino.isSelected()) {
                user.setSexo("Feminino");
            }

            userService.editar(user, user.getId() );
            prepararTabela();
            limpar();

            bt_salvar.setVisible(true);
            bt_editar.setVisible(false);
        }
    }

    @FXML
    void deletarDados(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Excluir");
        alert.setHeaderText("Deseja excluir esses dados?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){
            userService.deletar(user.getId());
            prepararTabela();
            limpar();

            bt_salvar.setVisible(true);
        }
    }

    public boolean validar(){

        StringBuilder mensagem = new StringBuilder();

        if (tf_nome.getText().isEmpty()){
            mensagem.append("O campo nome é obrigatório!\n");
        }

        if (tf_idade.getText().isEmpty()){
            mensagem.append("O campo idade é obrigatório!\n");
        }

        if (!mensagem.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("ERRO");
            alert.setContentText(mensagem.toString());
            alert.show();

            return false;
        }else {
            return true;
        }

    }

    void prepararTabela(){

        tc_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tc_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tc_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tc_idade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        List<User> todosUsuarios = userService.buscarTodos();
        ObservableList<User> userObservableList = FXCollections.observableList(todosUsuarios);
        tv_campo_bd.setItems(userObservableList);
    }

    void limpar(){
        tf_nome.setText("");
        tf_idade.setText("");
    }

    void ocultarBotoes(){
        this.bt_editar.setVisible(false);
        this.bt_deletar.setVisible(false);
    }
}
