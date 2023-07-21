package com.example.projeto_final.model;

import com.example.projeto_final.controller.interfaces.audit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Client extends Person implements audit {
    private String notes;
    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;

    public Client(String name, String phone, LocalDateTime birth, String CPF, String address, boolean isActive, String notes) {
        super(name, phone, birth, CPF, address, isActive);
        this.notes = notes;
        createdBy();
        createdIn();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
