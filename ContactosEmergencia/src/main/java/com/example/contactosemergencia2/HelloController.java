package com.example.contactosemergencia2;

import com.example.contactosemergencia2.serviceContacto.Service;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    private Service service = new Service();

    private String[] listaOpciones = {"Padre", "Madre", "Hermano", "Hermana", "Tio", "Tia", "Abuelo", "Abuela"};

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTel;

    @FXML
    private ComboBox<String> cbRelacion;

    @FXML
    private Label lblMensaje;

    @FXML
    private ListView<Contacto> contactoListView;

    @FXML
    public void initialize(){
        cbRelacion.getItems().addAll(listaOpciones);
        contactoListView.setItems(service.getAllContactos());
    }

    @FXML
    public void onAdd(){
        try {
            String nombre = txtNombre.getText();
            String telefono = txtTel.getText();
            String relacion = cbRelacion.getValue();

            service.agregarContacto(nombre, telefono, relacion);
            lblMensaje.setText("Contacto anadido correctamente.");
            limpiar();

        } catch (IllegalArgumentException e){
            lblMensaje.setText(e.getMessage());
        }
    }

    @FXML
    public void onBuscar(){
        try {
            String nombre = txtNombre.getText();
            Contacto contactoABuscar = service.buscarContacto(nombre);
            if (contactoABuscar != null) {
                txtNombre.setText(contactoABuscar.getNombre());
                txtTel.setText(contactoABuscar.getTelefono());
                cbRelacion.setValue(contactoABuscar.getParentesco());
            }
        } catch (IllegalArgumentException e){
            lblMensaje.setText(e.getMessage());
        }
    }

    @FXML
    public void onUpdate(){
        try {
            String nombre = txtNombre.getText();
            String telefono = txtTel.getText();
            String relacion = cbRelacion.getValue();

            service.actualizarContacto(nombre, telefono, relacion);
            contactoListView.refresh();
            limpiar();
            lblMensaje.setText("Contacto actualizado correctamente.");
        } catch (IllegalArgumentException e){
            lblMensaje.setText(e.getMessage());
        }
    }

    @FXML
    public void onDelete(){
        try {
            String nombre = txtNombre.getText();
            service.borrarContacto(nombre);
            limpiar();
            lblMensaje.setText("Contacto borrado correctamente.");
        } catch (IllegalArgumentException e){
            lblMensaje.setText(e.getMessage());
        }
    }

    @FXML
    public void onClear(){
        limpiar();
    }

    public void limpiar(){
        txtNombre.clear();
        txtTel.clear();
        cbRelacion.getSelectionModel().clearSelection();
    }
}
