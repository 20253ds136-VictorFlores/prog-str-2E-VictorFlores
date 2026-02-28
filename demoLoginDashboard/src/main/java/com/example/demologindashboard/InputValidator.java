package com.example.demologindashboard;

public class InputValidator {

    public static String validateUser(String user) {
        if (user == null || user.trim().isEmpty()) {
            return "Usuario no puede estar vacío";
        }
        if (user.trim().length() < 4) {
            return "Usuario debe tener al menos 4 caracteres";
        }
        return null;
    }

    public static String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return "Correo no puede estar vacío";
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            return "Correo inválido";
        }
        return null;
    }

    public static String validatePassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            return "Contraseña no puede estar vacía";
        }
        if (password.trim().length() < 6) {
            return "Contraseña debe tener al menos 6 caracteres";
        }
        return null;
    }
}