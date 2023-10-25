package AccesoDatos;

import Entidades.Mascota;
import Entidades.Visita;
import AccesoDatos.VisitaData;
import Entidades.Cliente;
import com.sun.corba.se.impl.util.RepositoryId;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Optional;

public class MascotaData {

    private Connection con = null;
    private ClienteData clientData;

    public MascotaData() {

        con = Conexion.getConexion();
        clientData = new ClienteData();
    }

    public Mascota guardarMascota(Mascota mascota) {

        String sql = "INSERT INTO mascota(alias, sexo, especie, raza, colorPelo, fechaNac, activo, idCliente, UsuarioLog) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mascota.getAlias());
            ps.setString(2, mascota.getSexo());
            ps.setString(3, mascota.getEspecie());
            ps.setString(4, mascota.getRaza());
            ps.setString(5, mascota.getColorPelo());
            ps.setDate(6, Date.valueOf(mascota.getFechaNac()));
            ps.setBoolean(7, mascota.isActivo());
            //     ps.setDouble(8, mascota.getPesoUltimo());
            //   ps.setDouble(9, mascota.getPesoPromedio());
            //ps.setDate(10, Date.valueOf(mascota.getFechaDefuncion()));
            ps.setInt(8, mascota.getCliente().getIdCliente());
            ps.setString(9, mascota.getUsuarioLog());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                mascota.setIdMascota(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Mascota añadida con exito. ");
                return mascota;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR: No se agrego la Mascota... ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota" + ex.getMessage());
        }
        mascota = null;
        return mascota;
    }

//     public void guardarMascota(Mascota mascota) {
//
//        String sql = "INSERT INTO mascota(alias, sexo, especie, raza, colorPelo, fechaNac, activo, idCliente, UsuarioLog) VALUES (?,?,?,?,?,?,?,?,?)";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, mascota.getAlias());
//            ps.setString(2, mascota.getSexo());
//            ps.setString(3, mascota.getEspecie());
//            ps.setString(4, mascota.getRaza());
//            ps.setString(5, mascota.getColorPelo());
//            ps.setDate(6, Date.valueOf(mascota.getFechaNac()));
//            ps.setBoolean(7, mascota.isActivo());
//       //     ps.setDouble(8, mascota.getPesoUltimo());
//         //   ps.setDouble(9, mascota.getPesoPromedio());
//            //ps.setDate(10, Date.valueOf(mascota.getFechaDefuncion()));
//            ps.setInt(8, mascota.getCliente().getIdCliente());
//            ps.setString(9, mascota.getUsuarioLog());
//
//            ps.executeUpdate();
//            ResultSet rs = ps.getGeneratedKeys();
//
//            if (rs.next()) {
//                mascota.setIdMascota(rs.getInt(1));
//                JOptionPane.showMessageDialog(null, "Mascota añadida con exito. ");
//            }else{
//                JOptionPane.showMessageDialog(null, "ERROR: No se agrego la Mascota... ");
//            }
//            ps.close();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota" + ex.getMessage());
//        }
//
//    }
    public Mascota buscarMascotaId(int id) {
        Mascota mascota = null;
        String sql = "SELECT alias, sexo, especie, raza, colorPelo, fechaNac, activo, pesoUltimo, pesoPromedio, fechaDefuncion, idCliente, UsuarioLog FROM mascota WHERE idMascota = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mascota = new Mascota();
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColorPelo(rs.getString("colorPelo"));
                mascota.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                mascota.setActivo(rs.getBoolean("activo"));
                mascota.setPesoUltimo(rs.getDouble("pesoUltimo"));
                mascota.setPesoUltimo(rs.getDouble("pesoPromedio"));
                //mascota.setFechaNac(rs.getDate("fechaDefuncion").toLocalDate());
                mascota.setCliente(clientData.buscarClienteId(rs.getInt("idCliente")));
                mascota.setUsuarioLog(rs.getString("usuarioLOg"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe la mascota");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota" + ex.getMessage());

        }
        return mascota;
    }

    public void modificarMascota(Mascota mascota) {
        String sql = "UPDATE mascota SET alias=?, sexo=?, especie=?, raza=?, colorPelo=?, fechaNac=?, activo=?, pesoUltimo=?, pesoPromedio=?, fechaDefuncion=?, idCliente=?, usuarioLog=? WHERE idMascota = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mascota.getAlias());
            ps.setString(2, mascota.getSexo());
            ps.setString(3, mascota.getEspecie());
            ps.setString(4, mascota.getRaza());
            ps.setString(5, mascota.getColorPelo());
            ps.setDate(6, Date.valueOf(mascota.getFechaNac()));
            ps.setBoolean(7, mascota.isActivo());
            ps.setDouble(8, mascota.getPesoUltimo());
            ps.setDouble(9, mascota.getPesoPromedio());
            ps.setDate(10, Date.valueOf(mascota.getFechaDefuncion()));
            ps.setInt(11, mascota.getCliente().getIdCliente());
            ps.setString(12, mascota.getUsuarioLog());
            ps.setInt(13, mascota.getIdMascota());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "La mascota no se modifico");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota" + ex.getMessage());

        }

    }

    public List<Mascota> listarMascotas() {
        List<Mascota> mascotas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mascota WHERE activo=1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setIdMascota(rs.getInt("idMascota"));
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColorPelo(rs.getString("colorPelo"));
                mascota.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                mascota.setCliente(clientData.buscarClienteId(rs.getInt("idCliente")));
                mascota.setActivo(rs.getBoolean("activo"));
                mascota.setPesoUltimo(rs.getDouble("pesoUltimo"));
                mascota.setPesoUltimo(rs.getDouble("pesoPromedio"));
//                mascota.setFechaNac(rs.getDate("fechaDefuncion").toLocalDate());
                mascota.setUsuarioLog(rs.getString("usuarioLOg"));
                mascotas.add(mascota);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota" + ex.getMessage());
        }
        return mascotas;

    }

    public List<Mascota> listarMascotasEliminadas() {
        List<Mascota> mascotas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mascota WHERE activo=0";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setIdMascota(rs.getInt("idMascota"));
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColorPelo(rs.getString("colorPelo"));
                mascota.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                mascota.setCliente(clientData.buscarClienteId(rs.getInt("idCliente")));
                mascota.setActivo(rs.getBoolean("activo"));
                mascota.setPesoUltimo(rs.getDouble("pesoUltimo"));
                mascota.setPesoUltimo(rs.getDouble("pesoPromedio"));
//                mascota.setFechaNac(rs.getDate("fechaDefuncion").toLocalDate());
                mascota.setUsuarioLog(rs.getString("usuarioLOg"));
                mascotas.add(mascota);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota" + ex.getMessage());
        }
        return mascotas;

    }
    
    public List<Mascota> listarMascotasXCliente(Cliente cliente) {
        List<Mascota> mascotas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mascota WHERE idCliente=? AND activo=1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setIdMascota(rs.getInt("idMascota"));
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColorPelo(rs.getString("colorPelo"));
                mascota.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                mascota.setCliente(clientData.buscarClienteId(rs.getInt("idCliente")));
                mascota.setActivo(rs.getBoolean("activo"));
                mascota.setPesoUltimo(rs.getDouble("pesoUltimo"));
                mascota.setPesoUltimo(rs.getDouble("pesoPromedio"));

                if ((rs.getDate("fechaDefuncion")) == null) {

                } else {
                    mascota.setFechaNac(rs.getDate("fechaDefuncion").toLocalDate());
                }
                mascota.setUsuarioLog(rs.getString("usuarioLOg"));
                mascotas.add(mascota);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota" + ex.getMessage());
        } catch (NullPointerException n) {

        }
        return mascotas;

    }

    public List<Mascota> listarMascotasXIDCliente(int idCliente) {
        List<Mascota> mascotas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mascota WHERE idCliente=? AND activo=1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setIdMascota(rs.getInt("idMascota"));
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColorPelo(rs.getString("colorPelo"));
                mascota.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                mascota.setCliente(clientData.buscarClienteId(rs.getInt("idCliente")));
                mascota.setActivo(rs.getBoolean("activo"));
                mascota.setPesoUltimo(rs.getDouble("pesoUltimo"));
                mascota.setPesoUltimo(rs.getDouble("pesoPromedio"));

                if ((rs.getDate("fechaDefuncion")) == null) {

                } else {
                    mascota.setFechaNac(rs.getDate("fechaDefuncion").toLocalDate());
                }
                mascota.setUsuarioLog(rs.getString("usuarioLOg"));
                mascotas.add(mascota);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota" + ex.getMessage());
        } catch (NullPointerException n) {

        }
        return mascotas;

    }

    public List<Mascota> listarMascotasXDniCliente(int dni) {
        List<Mascota> mascotas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mascota INNER JOIN cliente ON mascota.idCliente = cliente.idCliente WHERE cliente.dni=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setIdMascota(rs.getInt("idMascota"));
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColorPelo(rs.getString("colorPelo"));
                mascota.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                mascota.setCliente(clientData.buscarClienteId(rs.getInt("idCliente")));
                mascota.setActivo(rs.getBoolean("activo"));
                mascota.setPesoUltimo(rs.getDouble("pesoUltimo"));
                mascota.setPesoUltimo(rs.getDouble("pesoPromedio"));
//
//                if ((rs.getDate("fechaDefuncion")) == null) {
//
//                } else {
//                    mascota.setFechaNac(rs.getDate("fechaDefuncion").toLocalDate());
//                }
                mascota.setUsuarioLog(rs.getString("usuarioLOg"));
                mascotas.add(mascota);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota" + ex.getMessage());
        } catch (NullPointerException n) {

        }
        return mascotas;

    }
    
    public void eliminarMascota(int id) {
        try {
            String sql = "UPDATE mascota SET activo=0 WHERE idMascota=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino la mascota");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota");
        }
    }

    public void reactivarMascota(int id) {
        try {
            String sql = "UPDATE mascota SET activo=1 WHERE idMascota=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se reactivo la mascota");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla mascota");
        }
    }

    public double obtenerPesoPromedio(int id) {
        VisitaData visData = new VisitaData();
        List<Visita> visList = new ArrayList<>();
        visList = visData.obtenerVisitasXMascota(id);
        Collections.reverse(visList);

        if (visList.isEmpty()) {
            return 0;
        }
        double promedio = 0;
        int i = 0;
        while (i < visList.size() && i < 10) {
            promedio += visList.get(i).getPesoActual();
            i++;
            System.out.println(i + " promedio" + promedio);
        }
        if (visList.size() == 10) {
            return promedio / 10;
        }

        return promedio / visList.size();
    }

    public int calcularEdad(LocalDate fnac) {
        LocalDate fechaHoy = LocalDate.now();
        int edad = fechaHoy.getYear() - fnac.getYear();
        return edad;
    }
}
