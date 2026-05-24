package com.gestorincidencias.model;

public class IncidenciaView {

    // 🧾 lo que necesita la vista
    private int id;
    private String descripcion;
    private String fecha;
    private String estado;

    public IncidenciaView() {}

    public IncidenciaView(int id, String descripcion, String fecha, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }
    
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}