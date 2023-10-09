package AccesoDatos;

import Entidades.Cliente;
import Entidades.Mascota;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteData {

    private Connection con = null;

    public ClienteData() {

        con = Conexion.getConexion();
    }

    public void guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, apellido, dni, telefono, direccion, telefonoAlternativo, nombreAlternativo, usuarioLog, activo) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());
            ps.setInt(4, cliente.getTelefono());
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getTelefonoAlternativo());
            ps.setString(7, cliente.getNombreAlternativo());
            ps.setString(8, cliente.getUsuarioLog());
            ps.setBoolean(9, cliente.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cliente añadido con exito");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }
    }

    public Cliente buscarClienteId(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE idCliente=? AND activo=1";            //ver el * en sql
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {                                            //ver el orden de las columnas?
                cliente = new Cliente();
                cliente.setIdCliente(id);
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefonoAlternativo(rs.getInt("telefonoAlternativo"));
                cliente.setNombreAlternativo(rs.getString("nombreAlternativo"));
                cliente.setUsuarioLog(rs.getString("usuarioLOg"));
                cliente.setActivo(rs.getBoolean("activo"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe el Cliente");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla Cliente " + ex.getMessage());
        }

        return cliente;
    }

    public Cliente buscsrClienteDni(int dni) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE dni=? AND activo=1";            //ver el * en sql
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {                                            //ver el orden de las columnas?
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefonoAlternativo(rs.getInt("telefonoAlternativo"));
                cliente.setNombreAlternativo(rs.getString("nombreAlternativo"));
                cliente.setUsuarioLog(rs.getString("usuarioLOg"));
                cliente.setActivo(rs.getBoolean("activo"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe el Cliente");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla Cliente " + ex.getMessage());
        }

        return cliente;

    }

    public List<Cliente> listarClientes() {

        List<Cliente> clientesList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente WHERE activo=1";                                   //chk sentencia
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefonoAlternativo(rs.getInt("telefonoAlternativo"));
                cliente.setNombreAlternativo(rs.getString("nombreAlternativo"));
                cliente.setUsuarioLog(rs.getString("usuarioLOg"));
                cliente.setActivo(rs.getBoolean("activo"));
                clientesList.add(cliente);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla Cliente " + ex.getMessage());
        }

        return clientesList;
    }

    public void modificarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre=?, apellido=?, dni=?, telefono=?, direccion=?, telefonoAlternativo=?, nombreAlternativo=?, usuarioLog=?, activo=? WHERE idCliente=? ";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getDni());
            ps.setInt(4, cliente.getTelefono());
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getTelefonoAlternativo());
            ps.setString(7, cliente.getNombreAlternativo());
            ps.setString(8, cliente.getUsuarioLog());
            ps.setBoolean(9, cliente.isActivo());
            ps.setInt(10, cliente.getIdCliente());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "El Cliente no se Modifico");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla Cliente " + ex.getMessage());

        }

    }

    public void eliminarCliente(int id) {
        try {
            String sql = "UPDATE cliente SET activo=0 WHERE idCliente=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino el Cliente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla Cliente ");
        }
    }

    public List<Cliente> listarClientesEliminados() {

        List<Cliente> clientesList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente WHERE activo=0";                                   //chk sentencia
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefonoAlternativo(rs.getInt("telefonoAlternativo"));
                cliente.setNombreAlternativo(rs.getString("nombreAlternativo"));
                cliente.setUsuarioLog(rs.getString("usuarioLOg"));
                cliente.setActivo(rs.getBoolean("activo"));
                clientesList.add(cliente);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla Cliente " + ex.getMessage());
        }

        return clientesList;
    }

    public Cliente buscsrClienteDniEliminado(int dni) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE dni=? AND activo=0";            //ver el * en sql
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {                                            //ver el orden de las columnas?
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefonoAlternativo(rs.getInt("telefonoAlternativo"));
                cliente.setNombreAlternativo(rs.getString("nombreAlternativo"));
                cliente.setUsuarioLog(rs.getString("usuarioLOg"));
                cliente.setActivo(rs.getBoolean("activo"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe el Cliente");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla Cliente " + ex.getMessage());
        }

        return cliente;

    }

    public ArrayList<Mascota> listarMascotasXcliente(int id) {                            
        ArrayList<Mascota> mascoList = new ArrayList<>();                                 //este por ahi va en MascotaData

        Cliente cliente = null;
        String sql = "SELECT m.idMascota, alias, especie, raza, sexo, fechaNAc FROM mascota m WHERE m.idCliente=? AND m.activo=1";            

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                                            
                Mascota mascAux = new Mascota();
                mascAux.setIdMascota(rs.getInt("idMascota"));
                mascAux.setAlias(rs.getString("alias"));
                mascAux.setEspecie(rs.getString("especie"));
                mascAux.setRaza(rs.getString("raza"));
                mascAux.setSexo(rs.getString("sexo"));
                mascAux.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                System.out.println("" + mascAux.getAlias());
                mascoList.add(mascAux);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla Cliente " + ex.getMessage());
        }

        return mascoList;
    }

}
