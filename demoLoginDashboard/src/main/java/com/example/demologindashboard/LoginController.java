package com.example.demologindashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField txtUser;
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblError;

    @FXML
    protected void onLoginClick() {
        String userError = InputValidator.validateUser(txtUser.getText());
        String emailError = InputValidator.validateEmail(txtEmail.getText());
        String passError = InputValidator.validatePassword(txtPassword.getText());

        if (userError != null) {
            lblError.setText(userError);
            lblError.setStyle("-fx-text-fill: red;");
            return;
        }
        if (emailError != null) {
            lblError.setText(emailError);
            lblError.setStyle("-fx-text-fill: red;");
            return;
        }
        if (passError != null) {
            lblError.setText(passError);
            lblError.setStyle("-fx-text-fill: red;");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
            Scene scene = new Scene(loader.load(), 400, 250);

            DashboardController controller = loader.getController();
            controller.setWelcomeMessage(txtUser.getText());

            Stage stage = (Stage) txtUser.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}