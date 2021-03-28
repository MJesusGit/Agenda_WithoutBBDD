package com.example.agenda;

public class Contacto {
    private String nombre;
    private String telefono;
    private int tipo;
    private String email;
    private String direccion;

    public Contacto(String nombre, String telefono, int tipo, String email, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipo = tipo;
        this.email = email;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
