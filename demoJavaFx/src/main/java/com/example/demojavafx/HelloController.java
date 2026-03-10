package com.example.demojavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloController {

    public void onGoToForm(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader( getClass().getResource("/com/example/demojavafx/form-view.fxml") );
            Scene formScene= new Scene(loader.load(), 500,380);
            Stage stage = (Stage) ( (javafx.scene.Node) event.getSource() ).getScene().getWindow();
            stage.setScene(formScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}