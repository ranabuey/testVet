
package Entidades;

public class Tratamiento {
    
    private int idTratamiento;
    private String descripcion, tipoTratamiento, medicamento, usuarioLog;
    private double importe;
    private boolean activo;

    public Tratamiento() {
    }

    public Tratamiento(String descripcion, String tipoTratamiento, String medicamento, double importe, String usuarioLog, boolean activo) {
        this.descripcion = descripcion;
        this.tipoTratamiento = tipoTratamiento;
        this.medicamento = medicamento;
        this.importe = importe;
        this.usuarioLog=usuarioLog;
        this.activo = activo;
    }

    public Tratamiento(int idTratamiento, String descripcion, String tipoTratamiento, String medicamento, double importe,String usuarioLog, boolean activo) {
        this.idTratamiento = idTratamiento;
        this.descripcion = descripcion;
        this.tipoTratamiento = tipoTratamiento;
        this.medicamento = medicamento;
        this.importe = importe;
        this.usuarioLog=usuarioLog;
        this.activo = activo;
    }


    @Override
    public String toString() {
        return "Tratamiento{" + "idTratamiento=" + idTratamiento + ", descripcion=" + descripcion + ", tipoTratamiento=" + tipoTratamiento + ", medicamento=" + medicamento + ", importe=" + importe + ", activo=" + activo + '}';
    }

    public String getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(String usuarioLog) {
        this.usuarioLog = usuarioLog;
    }


    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
    
}
