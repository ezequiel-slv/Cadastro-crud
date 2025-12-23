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

import java.net.URL;
import java.util.List;
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
    private TableColumn tc_id;

    @FXML
    private TableColumn tc_idade;

    @FXML
    private TableColumn tc_nome;

    @FXML
    private TableColumn tc_sexo;

    @FXML
    private TextField tf_idade;

    @FXML
    private TextField tf_nome;

    @FXML
    private TableView tv_campo_bd;

    User user = new User();
    UserService userService = new UserService();

    private List<User> todosUsuarios;
    private ObservableList<User> userObservableList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prepararTabela();
        ocultarBotoes();
    }

    @FXML
    public void salvarDados(ActionEvent event){

        if (validar()) {
            user.setNome(tf_nome.getText().toString());
            user.setIdade(Integer.valueOf(tf_idade.getText().toString()));

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
    public void editarDados(ActionEvent event){

    }

    @FXML
    public void deletarDados(ActionEvent event){

    }

    public boolean validar(){

        StringBuffer mensagem = new StringBuffer();

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

        todosUsuarios = userService.buscarTodos();
        userObservableList = FXCollections.observableList(todosUsuarios);
        tv_campo_bd.setItems(userObservableList);
    }

    void limpar(){
        tf_nome.setText("");
        tf_idade.setText("");
    }

    void ocultarBotoes(){
        bt_editar.setVisible(false);
        bt_deletar.setVisible(false);
    }
}
