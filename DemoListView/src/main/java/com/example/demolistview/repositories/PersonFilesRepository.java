package com.example.demolistview.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PersonFilesRepository {

    private final Path filetPath = Paths.get("data","persons.csv");

    private void ensureFile() throws IOException {
        if(Files.notExists(filetPath)){
            Files.createFile(filetPath);
        }
    }

    public List<String> readAllLines() throws IOException {
        ensureFile();
        return Files.readAllLines(filetPath);
    }


}
