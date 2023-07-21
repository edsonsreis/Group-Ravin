package com.example.projeto_final.model;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    private String name;
    private String phone;
    private LocalDateTime birth;
    private String CPF;
    private String address;

    private int age;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, String phone, LocalDateTime birth, String CPF, String address, boolean isActive) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.CPF = CPF;
        this.address = address;
        this.isActive = isActive;
        this.age = (int) ChronoUnit.YEARS.between(this.birth, LocalDateTime.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
