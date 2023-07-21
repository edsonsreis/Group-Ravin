package com.example.projeto_final.controller;

import com.example.projeto_final.controller.interfaces.audit;
import com.example.projeto_final.model.Client;
import com.example.projeto_final.model.Command;
import com.example.projeto_final.model.Table;
import com.example.projeto_final.model.ennumeration.CommandStatus;
import com.example.projeto_final.model.ennumeration.TableStatus;
import com.example.projeto_final.repository.CommandRepository;
import com.example.projeto_final.repository.TableRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TableController implements audit {

    private TableRepository repository;

    private static final TableController instance;

    private TableController(){
        this.repository = new TableRepository();
    }

    static {
        try {
            instance = new TableController();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static TableController getInstance() {
        return instance;
    }

    public void save(Table c) throws Exception {
        repository.save(c);
        audit();
    }

    public boolean changeTableStatus(Table t, TableStatus tableStatus) throws Exception {
        switch (tableStatus) {
            case RESERVED -> {
                if (t.getCommand().getCommandStatus() == CommandStatus.CLOSED || t.getCommand().getCommandStatus() == null) {
                    t.setTableStatus(TableStatus.RESERVED);
                    audit();
                    return true;
                } else {
                    return false;
                }
            }
            case FREE -> {
                if (t.getCommand().getCommandStatus() == CommandStatus.OPEN) {
                    return false;
                } else {
                    t.setTableStatus(TableStatus.FREE);
                    audit();
                    return true;
                }
            }

            case OCCUPIED -> {
                t.setTableStatus(TableStatus.OCCUPIED);
                audit();
                return true;
            }
        }
        return false;
    }

    public boolean addClientToTable(Table t, Client c){
        if(c.isActive()){
            t.addClients(c);
            audit();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Client> getClients(Table t){
        return t.getClients();
    }

    // Aduit methods and properties

    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;

    public void closeTable(){

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
