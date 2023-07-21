package com.example.projeto_final.model;

import com.example.projeto_final.controller.interfaces.audit;
import com.example.projeto_final.model.ennumeration.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Table implements audit {
    private Employee employee;
    private String name;
    private int Id;
    private int number;
    private TableStatus tableStatus;
    private int maxNumberPeople;
    private Command command;
    private ArrayList<Client> clients;

    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;


    public Table(Employee employee, String name, int Id, int number, TableStatus tableStatus, int maxNumberPeople) {
        this.employee = employee;
        this.name = name;
        this.Id = Id;
        this.number = number;
        this.tableStatus = tableStatus;
        this.maxNumberPeople = maxNumberPeople;
        this.command = null;
        this.clients = new ArrayList<>();
        createdBy();
        createdIn();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addClients(Client client) {
        this.clients.add(client);
        audit();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
        audit();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        audit();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        audit();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
        audit();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        audit();
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
        audit();
    }

    public int getMaxNumberPeople() {
        return maxNumberPeople;
    }

    public void setMaxNumberPeople(int maxNumberPeople) {
        this.maxNumberPeople = maxNumberPeople;
        audit();
    }
    @Override
    public void createdIn() {
        this.createdIn = LocalDateTime.now();
    }

    @Override
    public void createdBy() {
        this.createdBy = "Admin";
    }

    @Override
    public void updatedIn() {
        this.updatedIn = LocalDateTime.now();
    }

    @Override
    public void updatedBy() {
        this.updatedBy = "Admin";
    }

    private void audit(){
        updatedBy();
        updatedIn();
    }
}
