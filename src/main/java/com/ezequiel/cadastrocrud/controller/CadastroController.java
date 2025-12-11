package com.ezequiel.cadastrocrud.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    void salvarDados(javafx.event.ActionEvent actionEvent) {
        String nome = tf_nome.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salvar");
        alert.setHeaderText("Arquivo salvo");
        alert.setContentText(nome);
        alert.show();
    }

    public void editarDados(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Editar");
        alert.setHeaderText("Arquivo editado");
        alert.show();
    }

    public void deletarDados(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deletar");
        alert.setHeaderText("Arquivo deletado");
        alert.show();
    }
}
