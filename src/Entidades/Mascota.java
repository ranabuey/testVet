
package Entidades;

import java.time.LocalDate;

public class Mascota {
    
    private int idMascota;
    private String alias, sexo, especie, raza, colorPelo;
    private LocalDate fechaNac;
    private double pesoUltimo, pesoPromedio;
    private boolean activo;
    private LocalDate fechaDefuncion;
    private Cliente cliente;
    private String usuarioLog;
    

    public Mascota() {
    }

    public Mascota(String alias, String sexo, String especie, String raza, String colorPelo, LocalDate fechaNac, boolean activo, Cliente cliente, String usuarioLog) {
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.colorPelo = colorPelo;
        this.fechaNac = fechaNac;
        this.activo = activo;
        this.cliente = cliente;
        this.usuarioLog = usuarioLog;
    }
    

    public Mascota(int idMascota, String alias, String sexo, String especie, String raza, String colorPelo, LocalDate fechaNac, double pesoUltimo, double pesoPromedio, boolean activo, LocalDate fechaDefuncion, Cliente cliente, String usuarioLog) {
        this.idMascota = idMascota;
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.colorPelo = colorPelo;
        this.fechaNac = fechaNac;
        this.pesoUltimo = pesoUltimo;
        this.pesoPromedio = pesoPromedio;
        this.activo = activo;
        this.fechaDefuncion = fechaDefuncion;
        this.cliente = cliente;
        this.usuarioLog = usuarioLog;
    }

    public Mascota(String alias, String sexo, String especie, String raza, String colorPelo, LocalDate fechaNac, double pesoUltimo, double pesoPromedio, boolean activo, LocalDate fechaDefuncion, Cliente cliente, String usuarioLog) {
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.colorPelo = colorPelo;
        this.fechaNac = fechaNac;
        this.pesoUltimo = pesoUltimo;
        this.pesoPromedio = pesoPromedio;
        this.activo = activo;
        this.fechaDefuncion = fechaDefuncion;
        this.cliente = cliente;
        this.usuarioLog = usuarioLog;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public double getPesoUltimo() {
        return pesoUltimo;
    }

    public void setPesoUltimo(double pesoUltimo) {
        this.pesoUltimo = pesoUltimo;
    }

    public double getPesoPromedio() {
        return pesoPromedio;
    }

    public void setPesoPromedio(double pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(LocalDate fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(String usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    @Override
    public String toString() {
        return " "+alias +  ", " + cliente.getApellido() +", "+ especie + ", " + raza + ", " ;}
    
    
    
    
}
