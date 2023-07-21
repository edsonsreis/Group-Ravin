package com.example.projeto_final.controller;

import com.example.projeto_final.controller.interfaces.audit;
import com.example.projeto_final.model.*;
import com.example.projeto_final.model.ennumeration.CommandStatus;
import com.example.projeto_final.repository.CommandRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CommandController implements audit {

    private CommandRepository repository;

    private static final CommandController instance;

    private CommandController(){
        this.repository = new CommandRepository();
    }

    static {
        try {
            instance = new CommandController();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static CommandController getInstance() {
        return instance;
    }

    public void save(Command c) throws Exception {
        repository.save(c);
        audit();
    }

    public float close(Command c){
        if(canClose(c)) {
            if (c.getClient().getBirth().getMonth() == LocalDateTime.now().getMonth()) {
                c.updateTotal(0.1);
                c.setCommandStatus(CommandStatus.CLOSED);
                audit();
            }
            return c.getTotal();
        } else{
            return 0f;
        }
    }

    private boolean canClose(Command c){
        boolean result = false;
        if(c.getCommandStatus() == CommandStatus.OPEN){
            System.out.println("Unable to close the command: " + c.getId());
        } else{
            result = true;
        }
        return result;
    }

    public ArrayList<Command> listAll(){
        return repository.listAll();
    }

    public void addProductToCommand(Command c, Product p, int quantity){
        c.addProduct(p,quantity);
    }


    // Aduit methods and properties

    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;

    public void closeCommand(Command command){

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
