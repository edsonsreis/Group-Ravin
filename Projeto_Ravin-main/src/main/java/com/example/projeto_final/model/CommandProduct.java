package com.example.projeto_final.model;

import com.example.projeto_final.controller.interfaces.audit;

import java.time.LocalDateTime;

public class CommandProduct implements audit {
    private Product product;
    private int quantity;
    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;

    public CommandProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        createdBy();
        createdIn();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        audit();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
