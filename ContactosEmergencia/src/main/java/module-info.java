module com.example.contactosemergencia2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.contactosemergencia2 to javafx.fxml;
    exports com.example.contactosemergencia2;
}