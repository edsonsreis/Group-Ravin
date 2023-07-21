package com.example.projeto_final;

import com.example.projeto_final.controller.PersonController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import com.example.projeto_final.model.*;


public class mainPageController {
    public TextField CPF;
    public TextField RG;
    public TableView<Object> tableFuncionarios;
    public TableColumn<Object, Object> tableNomeFun;
    public TableColumn<Object, Object> tableCPDFun;
    public TextField carteiraTrabalho;
    public TextField nome;
    public TextField telefone;
    public TextField nascimento;
    public TextField endereco;
    public CheckBox ativo;


    @FXML
    protected void initialize() throws Exception {

        tableNomeFun.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        tableCPDFun.setCellValueFactory(
                new PropertyValueFactory<>("CPF"));
        tableFuncionarios.setItems(FXCollections.observableArrayList(PersonController.getInstance().getAll()));
    }

    public void search(KeyEvent event){
        if(event.getCode().equals(KeyCode.ENTER)){
            Employee p = (Employee) PersonController.getInstance().searchByCPF(CPF.getText());
            if(p != null){
                CPF.setText(p.getCPF());
                ativo.setSelected(p.isActive());
                endereco.setText(p.getAddress());
                nascimento.setText(p.getBirth().toString());
                telefone.setText(p.getPhone());
                nome.setText(p.getName());
                carteiraTrabalho.setText(p.getWorkCardNumber());
                RG.setText(p.getRG());
            } else {
                nome.setText("CPF não encontrado");
                telefone.setText("CPF não encontrado");
                nascimento.setText("CPF não encontrado");
                endereco.setText("CPF não encontrado");
                carteiraTrabalho.setText("CPF não encontrado");
                RG.setText("CPF não encontrado");
            }
        }

    }

    public void selectItem() {
        Employee p = (Employee) tableFuncionarios.getSelectionModel().getSelectedItem();
        if(p == null) {
            return;
        }
        CPF.setText(p.getCPF());
        ativo.setSelected(p.isActive());
        endereco.setText(p.getAddress());
        nascimento.setText(p.getBirth().toString());
        telefone.setText(p.getPhone());
        nome.setText(p.getName());
        carteiraTrabalho.setText(p.getWorkCardNumber());
        RG.setText(p.getRG());
  }

    public void addNewEmployee(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addNewUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("New user");
        stage.setScene(scene);
        int before = PersonController.getInstance().getAll().size();
        stage.showAndWait();
        if(before < PersonController.getInstance().getAll().size()) {
            tableFuncionarios.getItems().add(PersonController.getInstance().getLast());
        }
    }

}
