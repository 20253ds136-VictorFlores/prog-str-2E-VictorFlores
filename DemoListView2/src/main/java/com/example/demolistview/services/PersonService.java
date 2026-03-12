package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFilesRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFilesRepository repo = new PersonFilesRepository();

    public List<String> loadDataForListView() throws IOException {

        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for (String line: lines){
            if (line==null || line.isBlank()) continue;

            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];

            result.add("Nombre: "+name + " - " + email);
        }

        return result;
    }

    public void addPerson(String name, String email) throws IOException {
        validate(name,email);
        repo.appendNewLine(name+" , "+email);
    }

    private void validate(String name, String email){
        if (name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String en=(email==null) ? "" : email.trim();
        if (en.isBlank() || !en.contains("@") || !en.contains(".")){
            throw new IllegalArgumentException("El email es incorrecto");
        }
    }
}
