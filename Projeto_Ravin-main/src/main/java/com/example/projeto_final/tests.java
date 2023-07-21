package com.example.projeto_final;

import com.example.projeto_final.controller.CommandController;
import com.example.projeto_final.controller.PersonController;
import com.example.projeto_final.controller.TableController;
import com.example.projeto_final.model.*;
import com.example.projeto_final.model.ennumeration.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class tests {
    public static void main(String[] args) throws Exception {
        Product productA = new Product("Carbonara","Pasta with bacon and egg", 1,10,65, DeliveryStatus.READY, Duration.ofMinutes(40),true);
        Product productB = new Product("Octopus","Octopus prepared with vegetables", 2,30,120, DeliveryStatus.READY, Duration.ofMinutes(50),true);

        Client clientA = new Client("Guilherme", "(11) 99999-9999", LocalDateTime.of(1995,7,5,0,0),"999.999.999-99", "Blumenau", true, "N/A");
        Client clientB = new Client("Cintia", "(11) 88888-8888", LocalDateTime.of(1995,8,5,0,0),"999.999.999-99", "Fortaleza", true, "N/A");

        Employee employeeA = new Employee("Thais", "(11) 77777-7777", LocalDateTime.of(2015,7,5,0,0), "555.555.555-88", "Recife", "55.485.488-9", MaritialStatus.MARRIED, EducationLevel.COLLEGE, Job.WAITER,5252352, new Date(2002,2,1), true,true);
        Employee employeeB = new Employee("William", "(11) 77777-7777", LocalDateTime.of(1995,10,5,0,0), "555.555.555-88", "Recife", "55.485.488-9", MaritialStatus.MARRIED, EducationLevel.COLLEGE, Job.MANAGER,5252352, new Date(2002,2,1), true,true);

        Table table = new Table(employeeA, "Mesa de canto", 1, 1, TableStatus.FREE, 10);

        Menu menu = new Menu("Main Menu", 1, true);

        Command command = new Command(table, clientB, CommandStatus.OPEN, 1);

        CommandController controller = CommandController.getInstance();

        //controller.close(command);

        System.out.println(command.getTotal());

        command.addProduct(productB,1);

        System.out.println(command.getTotal());

        command.setCommandStatus(CommandStatus.CLOSED);

        //System.out.println(controller.close(command));

        TableController tableController = TableController.getInstance();

        table.setCommand(command);

        //command.setCommandStatus(CommandStatus.OPEN);

        //System.out.println( tableController.changeTableStatus(table,TableStatus.FREE));

        System.out.println(tableController.addClientToTable(table,clientA));
        System.out.println(tableController.addClientToTable(table,clientB));

        for(Client c : table.getClients()){
            System.out.println(c.getName());
        }

        PersonController personController = PersonController.getInstance();

        System.out.println(personController.save(employeeA));


    }
}
