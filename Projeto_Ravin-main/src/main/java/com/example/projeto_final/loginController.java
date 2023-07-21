package com.example.projeto_final;

import com.example.projeto_final.Application;
import com.example.projeto_final.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class loginController {


    public TextField loginField;
    public PasswordField passwordField;

    @FXML
    protected void login(ActionEvent actionEvent) throws IOException {
        if(loginField.getText().equals("abc") & passwordField.getText().equals("1234")){
            System.out.println("okay");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("mainPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Ravin Management");
            stage.setScene(scene);
            stage.show();
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        } else {
            System.out.println("Not okay");
        }

    }

}