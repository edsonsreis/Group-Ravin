package com.example.projeto_final.model;

import com.example.projeto_final.controller.interfaces.audit;
import com.example.projeto_final.model.ennumeration.DeliveryStatus;

import java.time.Duration;
import java.time.LocalDateTime;

public class Product implements audit {
    private String name;
    private String description;
    private int Id;
    private float cost;
    private float price;
    private DeliveryStatus deliveryStatus;
    private Duration estimatedTime;
    private boolean isActive;
    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;

    public Product(String name, String description, int Id, float cost, float price, DeliveryStatus deliveryStatus, Duration estimatedTime, boolean isActive) {
        this.name = name;
        this.description = description;
        this.Id = Id;
        this.cost = cost;
        this.price = price;
        this.deliveryStatus = deliveryStatus;
        this.estimatedTime = estimatedTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        audit();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
        audit();
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
        audit();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        audit();
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        audit();
    }

    public Duration getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Duration estimatedTime) {
        this.estimatedTime = estimatedTime;
        audit();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
