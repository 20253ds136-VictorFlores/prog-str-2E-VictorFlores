package com.example.demolistview2.services;

import com.example.demolistview2.repositories.PersonFilesRepository;


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
            String edad = parts[2];

            result.add(name + " - " + edad + " - " + email);
        }

        return result;
    }

    private List<String> getCleanLines() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();

        for(String line : lines){
            if(line != null && !line.isBlank()){
                cleanLines.add(line);
            }
        }
        return cleanLines;
    }

    public void updatePerson(int index, String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        if(index < 0){
            throw new IllegalArgumentException("El indie es invalido");
        }
        List<String> data = getCleanLines(); //lo que extragimos del archivo
        data.set(index, name+","+email+","+edad);
        repo.saveFile(data);
    }

    public void addPerson(String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        repo.appendNewLine(name+","+email+","+edad);
    }

    public void deletePerson(int index, String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        List<String> data = getCleanLines();
        data.remove(index);
        repo.saveFile(data);

    }
    private void validate(String name, String email, String edad){
        int edadNumerica;
        if (name == null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String emailConverted = (email==null) ? "" : email.trim();
        if (emailConverted.isBlank() || !emailConverted.contains("@") || !emailConverted.contains(".")){
            throw new IllegalArgumentException("El email es incorrecto");
        }
        if( edad == null || edad.isBlank()){
            throw new IllegalArgumentException("La edad es incorrecta");
        }
        try{
            edadNumerica = Integer.parseInt(edad.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser un numero valido");
        }
        if(edadNumerica < 0 || edadNumerica>100){
            throw new IllegalArgumentException("Edad fuera del rango");
        }else if(edadNumerica < 18){
            throw new IllegalArgumentException("Usuario es menor de edad");
        }
    }
}
