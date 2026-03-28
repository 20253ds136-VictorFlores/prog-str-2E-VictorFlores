package com.example.contactosemergencia2.serviceContacto;

import com.example.contactosemergencia2.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Service {

    private final ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();

    public ObservableList<Contacto> getAllContactos() {
        return listaContactos;
    }

    public void agregarContacto(String nombre, String telefono, String parentesco) {
        validar(nombre, telefono, parentesco);

        if (buscarContacto(nombre) != null) {
            throw new IllegalArgumentException("Este usuario ya existe");
        }

        listaContactos.add(new Contacto(nombre, telefono, parentesco));
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto contacto : listaContactos) {
            if (nombre.equalsIgnoreCase(contacto.getNombre())) {
                return contacto;
            }
        }
        return null;
    }

    public void actualizarContacto(String nombre, String nuevoTel, String nuevaRelacion) {
        validar(nombre, nuevoTel, nuevaRelacion);

        Contacto contacto = buscarContacto(nombre);
        if (contacto != null) {
            contacto.setTelefono(nuevoTel);
            contacto.setParentesco(nuevaRelacion);
            return;
        }
        throw new IllegalArgumentException("Error: el contacto a actualizar no existe");
    }

    public void borrarContacto(String nombre) {
        Contacto contacto = buscarContacto(nombre);
        if (contacto != null) {
            listaContactos.remove(contacto);
            return;
        }
        throw new IllegalArgumentException("El usuario no existe");
    }

    private void validar(String nombre, String telefono, String parentesco) {
        if (nombre == null || nombre.trim().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if (parentesco == null || parentesco.trim().isBlank()) {
            throw new IllegalArgumentException("El parentesco no puede estar vacío");
        }
        if (telefono.length() != 10) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos");
        }
    }
}