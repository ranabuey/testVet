
package Entidades;

import java.time.LocalDate;

public class Visita {
    
    private int idVisita;
    private LocalDate fechaVisita;
    private String detalle;
    private double pesoActual;
    private boolean activo;
    private boolean internado;
    private LocalDate fechaAlta;
    private Cliente cliente;
    private Mascota mascota;
    private Tratamiento tratamiento;
   

    public Visita() {
    }

    public Visita(int idVisita, LocalDate fechaVisita, String detalle, double pesoActual, boolean activo, boolean internado, LocalDate fechaAlta, Cliente cliente, Mascota mascota, Tratamiento tratamiento) {
        this.idVisita = idVisita;
        this.fechaVisita = fechaVisita;
        this.detalle = detalle;
        this.pesoActual = pesoActual;
        this.activo = activo;
        this.internado = internado;
        this.fechaAlta = fechaAlta;
        this.cliente = cliente;
        this.mascota = mascota;
        this.tratamiento = tratamiento;
    }

    public Visita(LocalDate fechaVisita, String detalle, double pesoActual, boolean activo, boolean internado, LocalDate fechaAlta, Cliente cliente, Mascota mascota, Tratamiento tratamiento) {
        this.fechaVisita = fechaVisita;
        this.detalle = detalle;
        this.pesoActual = pesoActual;
        this.activo = activo;
        this.internado = internado;
        this.fechaAlta = fechaAlta;
        this.cliente = cliente;
        this.mascota = mascota;
        this.tratamiento = tratamiento;
    }

   
     public Visita(Cliente cliente, Mascota mascota, Tratamiento tratamiento) {
        this.cliente = cliente;
        this.mascota = mascota;
        this.tratamiento = tratamiento;

    }

    @Override
    public String toString() {
        return "Visita{" + "idVisita=" + idVisita + ", fechaVisita=" + fechaVisita + ", detalle=" + detalle + ", pesoActual=" + pesoActual + ", activo=" + activo + ", internado=" + internado + ", fechaAlta=" + fechaAlta + '}';
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isInternado() {
        return internado;
    }

    public void setInternado(boolean internado) {
        this.internado = internado;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    
}
