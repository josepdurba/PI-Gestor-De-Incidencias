public class Incidencia {
    
    private String dni;
    private String fecha;
    private String descripcion;
    private String observaciones;
    private String estado;
    private int fkUsuario;
    private int fkEstado;

    public Incidencia() {}

    public Incidencia(String dni, String fecha, String descripcion, String observaciones, int fkUsuario, int fkEstado) {
        this.dni = dni;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.fkUsuario = fkUsuario;
        this.fkEstado = fkEstado;
    }

    public Incidencia(String dni, String fecha, String estado) {
    this.dni = dni;
    this.fecha = fecha;
    this.estado = estado;
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

     public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public int getFkUsuario() { return fkUsuario; }
    public void setFkUsuario(int fkUsuario) { this.fkUsuario = fkUsuario; }

    public int getFkEstado() { return fkEstado; }
    public void setFkEstado(int fkEstado) { this.fkEstado = fkEstado; }
}