package com.example.projeto_final.model;

import com.example.projeto_final.controller.interfaces.audit;
import com.example.projeto_final.model.ennumeration.CommandStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Command implements audit {
    private Table table;
    private Client client;
    private ArrayList<CommandProduct> products;
    private ArrayList<Integer> quantity;
    private CommandStatus commandStatus;
    private int Id;
    private float total;

    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;

    public Command(Table table, Client client, CommandStatus commandStatus, int Id) {
        this.table = table;
        this.client = client;
        this.products = new ArrayList<>();
        this.commandStatus = commandStatus;
        this.Id = Id;
        this.total = 0;
        createdBy();
        createdIn();
    }

    public void updateTotal(double discount){
        this.total *= 1 - discount;
    }
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
        audit();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        audit();
    }

    public CommandStatus getCommandStatus() {
        return commandStatus;
    }

    public void setCommandStatus(CommandStatus commandStatus) {
        this.commandStatus = commandStatus;
        audit();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
        audit();
    }

    public float getTotal() {
        return total;
    }

    public float updateTotal() {
        float totalCommand = 0;

        for(CommandProduct p : products){
            totalCommand += p.getProduct().getPrice() * p.getQuantity();
        }
        this.total = totalCommand;
        audit();
        return this.total;
    }

    public void addProduct(Product product, int quantity) {
        CommandProduct p = new CommandProduct(product, quantity);
        this.products.add(p);
        updateTotal();
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
