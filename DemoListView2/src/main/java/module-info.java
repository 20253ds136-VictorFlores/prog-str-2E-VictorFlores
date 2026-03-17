module com.example.demolistview2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demolistview2 to javafx.fxml;
    opens com.example.demolistview2.controllers to javafx.fxml;
    opens com.example.demolistview2.services to javafx.fxml;
    opens com.example.demolistview2.repositories to javafx.fxml;
    exports com.example.demolistview2;
    exports com.example.demolistview2.controllers;
    exports com.example.demolistview2.services;
    exports com.example.demolistview2.repositories;




}