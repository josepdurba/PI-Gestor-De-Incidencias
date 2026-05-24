package com.gestorincidencias.model;

public class Usuario {

    private int id;
    private int rol;

    // 🔐 credenciales / identificación
    private String nombre;

    private String password;

    public Usuario() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getRol() {
        return rol;
    }
    
    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}