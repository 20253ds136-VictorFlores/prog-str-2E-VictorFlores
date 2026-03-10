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
}
