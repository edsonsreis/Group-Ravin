package com.example.projeto_final.repository;

import com.example.projeto_final.model.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandRepository {
    private ArrayList<Command> commands;

    public CommandRepository() {
        this.commands = new ArrayList<>();
    }

    public void save(Command c) {
        Command command = searchById(c.getId());

        if(command == null) {
            commands.add(c);
        } else {
            command = c;
        }
    }

    public ArrayList<Command> listAll() {
        return commands;
    }

    public void delete(Command c) {
        commands.remove(c);
    }

    public Command searchById(int id) {
        Command searchResult = null;
        for (Command command : commands) {
            if (command.getId() == id)
                searchResult = command;
        }

        return searchResult;
    }

    public void deleteById(Command c) {
        commands.remove(c);
    }

    public int count() {
        return this.commands.size();
    }

}
