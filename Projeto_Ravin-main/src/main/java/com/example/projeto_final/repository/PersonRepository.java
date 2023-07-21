package com.example.projeto_final.repository;

import com.example.projeto_final.model.Command;
import com.example.projeto_final.model.Person;

import java.util.ArrayList;

public class PersonRepository {

    private ArrayList<Person> people;

    public PersonRepository(){
        this.people = new ArrayList<>();
    }

    public void save(Person person){
        Person p = searchByCPF(person.getCPF());

        if(p == null) {
            people.add(person);
        } else {
            p = person;
        }
    }

    public void delete(Person person){
        people.remove(person);
    }

    public ArrayList<Person> listAll() {
        return people;
    }

    public Person searchByCPF(String CPF){
        Person searchResult = null;
        for (Person p : people) {
            if (p.getCPF().equals(CPF))
                searchResult = p;
        }

        return searchResult;
    }

    public int count() {
        return this.people.size();
    }
}
