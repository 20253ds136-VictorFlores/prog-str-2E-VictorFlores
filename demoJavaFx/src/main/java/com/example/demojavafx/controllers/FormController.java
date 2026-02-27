package com.example.demojavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class FormController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtEdad;
    @FXML
    private Label lblValidacion;

    public void onValidate(ActionEvent event){
        String nombre = txtNombre.getText() == null ? "" : txtNombre.getText();
        String correo = txtCorreo.getText() == null ? "" : txtCorreo.getText();
        String edad = txtEdad.getText() == null ? "" : txtEdad.getText();

        List<String> errores = new ArrayList<>();

        if(nombre.trim().isEmpty() || nombre.length()<3){
            errores.add("Nombre incorrecto");
        }
        if (correo.trim().isEmpty() || !correo.contains("@") || !correo.contains(".")){
            errores.add("Correo incorrecto");
        }
        int edadValida=0;
        try{
            edadValida=Integer.parseInt(edad);
            if(edadValida<0 || edadValida>=120){
                errores.add("Edad fuera de rango");
            }
        } catch (Exception e) {
            errores.add("El dato de edad no es numerico");
        }
        if(errores.isEmpty()){
            lblValidacion.setText("Los datos son correctos");
            lblValidacion.setStyle("-fx-text-fill: green");
        }else{
            String erroresLabel="";
            for(String string: errores){
                erroresLabel+=string;
            }
            lblValidacion.setText(erroresLabel);
            lblValidacion.setStyle("-fx-text-fill: red");

        }
    }
}