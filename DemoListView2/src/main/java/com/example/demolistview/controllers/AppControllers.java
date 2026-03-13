package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppControllers {
    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;

    @FXML
    private ObservableList<String> data = FXCollections.observableArrayList();

    private final PersonService service = new PersonService();

    @FXML
    public void initialize() {
        loadFromFile();
        listView.setItems(data);
    }

    @FXML
    public void onReload() {
        loadFromFile();
    }

    @FXML
    public void onAdd() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();

            String textoEdad = txtEdad.getText();
            if (textoEdad == null || textoEdad.isBlank()) {
                throw new IllegalArgumentException("El campo edad está vacío");
            }
            if (!textoEdad.matches("\\d+")) {
                throw new IllegalArgumentException("La edad debe contener solo números");
            }
            int edad = Integer.parseInt(textoEdad);

            service.addPerson(name, email, edad);

            lblMsg.setText("Persona creada con éxito");
            lblMsg.setStyle("-fx-text-fill: green;");

            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();

            loadFromFile();
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red;");
        } catch (Exception e) {
            lblMsg.setText("Error en los datos: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red;");
        }
    }

    private void loadFromFile() {
        try {
            List<String> items = service.loadDataForListView();
            data.setAll(items);
            lblMsg.setStyle("-fx-text-fill: green;");
            lblMsg.setText("Datos cargados con éxito");
        } catch (IOException e) {
            lblMsg.setStyle("-fx-text-fill: red;");
            lblMsg.setText("Error al cargar los archivos.");
        }
    }
}