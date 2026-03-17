package com.example.demolistview2.controllers;


import com.example.demolistview2.services.PersonService;
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

    private PersonService service = new PersonService();

    @FXML
    public void initialize(){
        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) ->{
                    loadDataToForm(newValue);
                }// se llaman funciones lamda
        );
        listView.setItems(data);
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onAdd(){
        String name = txtName.getText();
        String email = txtEmail.getText();
        String edad = txtEdad.getText();
        try {
            service.addPerson(name,email, edad);
            lblMsg.setStyle("-fx-text-fill: green");
            lblMsg.setText("Persona creada con exito.");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
        }catch (IOException IOException){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error con el archivo.");
        }catch (IllegalArgumentException argumentException){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error con los datos.");
        }

    }
    @FXML
    public void onUpdate(){
        String name = txtName.getText();
        String email = txtEmail.getText();
        String edad = txtEdad.getText();
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            service.updatePerson(index ,name,email, edad);
            loadFromFile();
            lblMsg.setText("Persona actualizada con exito.");
            lblMsg.setStyle("-fx-text-fill: green");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
        }catch (IOException IOException){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error con el archivo al actualizar.");
        }catch (IllegalArgumentException argumentException){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error con los datos al actualizar.");
        }
    }

    @FXML
    public void onDelete(){
        String name = txtName.getText();
        String email = txtEmail.getText();
        String edad = txtEdad.getText();
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            service.deletePerson(index ,name,email, edad);
            loadFromFile();
            lblMsg.setText("Persona borrada con exito.");
            lblMsg.setStyle("-fx-text-fill: green");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
        }catch (IOException IOException){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error con el archivo al borrar.");
        }catch (IllegalArgumentException argumentException){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error con los datos al borrar.");
        }
    }
    private void loadFromFile(){
        try{
            List<String> items = service.loadDataForListView();
            data.setAll(items);
            lblMsg.setStyle("-fx-text-fill: green");
            lblMsg.setText("Datos cargados con exito");
        }catch (IOException e){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error al cargar los archivos.");
        }
    }

    private void loadDataToForm(String data){
        String[] parts = data.split(" - " );
        txtName.setText(parts[0]);
        txtEdad.setText(parts[1]);
        txtEmail.setText(parts[2]);
    }
}
