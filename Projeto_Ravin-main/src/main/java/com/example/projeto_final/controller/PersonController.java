package com.example.projeto_final.controller;

import com.example.projeto_final.controller.interfaces.audit;
import com.example.projeto_final.model.Employee;
import com.example.projeto_final.model.Person;
import com.example.projeto_final.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PersonController implements audit {
    private final PersonRepository repository;

    private static final PersonController instance;

    public Person savedLast;

    private PersonController(){
        this.repository = new PersonRepository();
    }

    static {
        try {
            instance = new PersonController();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static PersonController getInstance() {
        return instance;
    }

    public boolean save(Person p) throws Exception {
        if(p.getClass().equals(Employee.class)) {
            if (canSaveEmployee((Employee) p)) {
                repository.save(p);
                this.savedLast = p;
                audit();
                return true;
            }else{
                return false;
            }
        }
        repository.save(p);
        this.savedLast = p;
        audit();
        return true;
    }

    public Person getLast() throws Exception {
        return this.savedLast;
    }

    public void delete(Person p){
        repository.delete(p);
    }

    public ArrayList<Person> getAll() throws Exception {
        return repository.listAll();
    }

    public Person searchByCPF(String CPF){
        return repository.searchByCPF(CPF);
    }

    private boolean canSaveEmployee(Employee e){
        return e.getAge() >= 18;
    }

    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;

    public void closeCommand(){

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
