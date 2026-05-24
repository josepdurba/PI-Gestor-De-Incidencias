package com.gestorincidencias.model;

import java.time.LocalDate;

public class Incidencia {

    private int id;
    private String descripcion;
    private String observaciones;
    
    private int fkUsuario;
    private int fkEstado;

    // opcional (solo lectura en listados)
    private LocalDate fecha;

    public Incidencia() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkEstado() {
        return fkEstado;
    }

    public void setFkEstado(int fkEstado) {
        this.fkEstado = fkEstado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}