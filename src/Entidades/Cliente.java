
package Entidades;


public class Cliente {
            
    private int idCliente, dni;
    private String nombre, apellido, direccion, nombreAlternativo, usuarioLog;
    private int telefono, telefonoAlternativo;
    private boolean activo;

    public Cliente() {
    }

    public Cliente(int dni, String nombre, String apellido, String direccion, String usuarioLog, int telefono, boolean activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.usuarioLog = usuarioLog;
        this.telefono = telefono;
        this.activo = activo;
    }

    public Cliente(int dni, String nombre, String apellido, String direccion, String nombreAlternativo, int telefono, int telefonoAlternativo, String usuarioLog, boolean activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.nombreAlternativo = nombreAlternativo;
        this.telefono = telefono;
        this.telefonoAlternativo = telefonoAlternativo;
        this.activo = activo;
        this.usuarioLog=usuarioLog;
    }

    public Cliente(int idCliente, int dni, String nombre, String apellido, String direccion, String nombreAlternativo, int telefono, int telefonoAlternativo, String usuarioLog, boolean activo) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.nombreAlternativo = nombreAlternativo;
        this.telefono = telefono;
        this.telefonoAlternativo = telefonoAlternativo;
        this.activo = activo;
        this.usuarioLog=usuarioLog;
    }

    public String getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(String usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreAlternativo() {
        return nombreAlternativo;
    }

    public void setNombreAlternativo(String nombreAlternativo) {
        this.nombreAlternativo = nombreAlternativo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTelefonoAlternativo() {
        return telefonoAlternativo;
    }

    public void setTelefonoAlternativo(int telefonoAlternativo) {
        this.telefonoAlternativo = telefonoAlternativo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return ""+apellido+", "+nombre+" / "+dni;
    }
    
    
    
    
}
