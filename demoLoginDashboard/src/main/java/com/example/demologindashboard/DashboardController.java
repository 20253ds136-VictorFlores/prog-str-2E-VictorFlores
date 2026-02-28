package com.example.demologindashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML private Label lblWelcome;

    public void setWelcomeMessage(String user) {
        lblWelcome.setText("Bienvenido, " + user);
    }
}