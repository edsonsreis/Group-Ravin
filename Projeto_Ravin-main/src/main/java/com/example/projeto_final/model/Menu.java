package com.example.projeto_final.model;

import com.example.projeto_final.controller.interfaces.audit;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu implements audit {
    private String name;
    private ArrayList<Product> products;

    private int Id;
    private boolean isActive;

    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;

    public Menu(String name, ArrayList<Product> products, int Id, boolean isActive) {
        this.name = name;
        this.products = products;
        this.Id = Id;
        this.isActive = isActive;
        createdBy();
        createdIn();
    }

    public Menu(String name, int Id, boolean isActive) {
        this.name = name;
        this.products = new ArrayList<>();
        this.Id = Id;
        this.isActive = isActive;
        createdBy();
        createdIn();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        audit();
    }

    public ArrayList<Product> listAllProducts() {
        return products;
    }


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
        audit();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
        audit();
    }

    public void addProduct(Product product){
        this.products.add(product);
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
