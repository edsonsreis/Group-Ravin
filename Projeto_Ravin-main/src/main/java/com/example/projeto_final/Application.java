package com.example.projeto_final;

import com.example.projeto_final.controller.CommandController;
import com.example.projeto_final.controller.PersonController;
import com.example.projeto_final.model.*;
import com.example.projeto_final.model.ennumeration.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

import static javafx.application.Application.launch;

public class Application extends javafx.application.Application { //extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("loginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch();


        /*Product productA = new Product("Carbonara","Pasta with bacon and egg", 1,10,65, DeliveryStatus.READY, Duration.ofMinutes(40),true);
        Product productB = new Product("Octopus","Octopus prepared with vegetables", 2,30,120, DeliveryStatus.READY, Duration.ofMinutes(50),true);

        Client clientA = new Client("Guilherme", "(11) 99999-9999", LocalDateTime.of(1995,7,5,0,0),"999.999.999-99", "Blumenau", true, "N/A");
        Client clientB = new Client("Cintia", "(11) 88888-8888", LocalDateTime.of(1995,8,5,0,0),"999.999.999-99", "Fortaleza", true, "N/A");

        Employee employeeA = new Employee("Thais", "(11) 77777-7777", LocalDateTime.of(1995,7,5,0,0), "555.555.555-88", "Recife", "55.485.488-9", MaritialStatus.MARRIED, EducationLevel.COLLEGE, Job.WAITER,5252352, new Date(2002,2,1), true,true);
        Employee employeeB = new Employee("William", "(11) 77777-7777", LocalDateTime.of(1995,10,5,0,0), "555.555.555-88", "Recife", "55.485.488-9", MaritialStatus.MARRIED, EducationLevel.COLLEGE, Job.MANAGER,5252352, new Date(2002,2,1), true,true);

        Table table = new Table(employeeA, "Mesa de canto", 1, 1, TableStatus.FREE, 10);

        Menu menu = new Menu("Main Menu", 1, true);

        menu.addProduct(productA);
        menu.addProduct(productB);

        Command command = new Command(table, clientA, CommandStatus.OPEN, 1);

        command.addProduct(productA,10);

        System.out.println(command.getTotal());

        CommandController commandController = new CommandController();

        System.out.println(commandController.close(command));

        command.setCommandStatus(CommandStatus.PAID);

        System.out.println(commandController.close(command));

        */


    }
}