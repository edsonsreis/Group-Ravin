package com.example.projeto_final.repository;

import com.example.projeto_final.model.Table;

import java.util.ArrayList;
import java.util.List;

public class TableRepository {
    private ArrayList<Table> tables;

    public TableRepository() {
        this.tables = new ArrayList<>();
    }

    public void save(Table c) {
        Table table = searchById(c.getId());

        if(table == null) {
            tables.add(c);
        } else {
            table = c;
        }
    }

    public List<Table> listAll() {
        return tables;
    }

    public void delete(Table c) {
        tables.remove(c);
    }

    public Table searchById(int id) {
        Table searchResult = null;
        for (Table table : tables) {
            if (table.getId() == id)
                searchResult = table;
        }

        return searchResult;
    }

    public void deleteById(Table c) {
        tables.remove(c);
    }

    public int count() {
        return this.tables.size();
    }

}
