package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFilesRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private final PersonFilesRepository repo = new PersonFilesRepository();

    public List<String> loadDataForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            if (line == null || line.isBlank()) continue;
            String[] parts = line.split(",");
            if (parts.length < 3) continue;
            String name = parts[0].trim();
            String email = parts[1].trim();
            String edadStr = parts[2].trim();
            if (!edadStr.matches("\\d+")) {
                System.out.println("Edad inválida en línea: " + line);
                continue;
            }
            int edad = Integer.parseInt(edadStr);
            result.add("Nombre: " + name + " - " + email + " - " + edad);
        }

        return result;
    }

    public void addPerson(String name, String email, int edad) throws IOException {
        validate(name, email, edad);
        repo.appendNewLine(name + "," + email + "," + edad);
    }

    private void validate(String name, String email, int edad) {
        if (name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre es incorrecto");
        }

        String en = (email == null) ? "" : email.trim();
        if (en.isBlank() || !en.contains("@") || !en.contains(".")) {
            throw new IllegalArgumentException("El email es incorrecto");
        }

        if (edad < 18 || edad > 120) {
            throw new IllegalArgumentException("La edad no cumple con el rango permitido (18-120)");
        }
    }
}