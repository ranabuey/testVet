package AccesoDatos;

import java.sql.Connection;
import Entidades.Cliente;
import Entidades.Mascota;
import Entidades.Visita;
import Entidades.Tratamiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TratamientoData {

    private Connection con = null;

    public TratamientoData() {

        con = Conexion.getConexion();

    }

    public void guardarTratmiento(Tratamiento trat) {

        String sql = "INSERT INTO tratamiento ( descripcion, medicamento, importe, tipoTratamiento, activo) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, trat.getDescripcion());
            ps.setString(2, trat.getMedicamento());
            ps.setString(3, trat.getTipoTratamiento());
            ps.setDouble(4, trat.getImporte());
            ps.setBoolean(5, trat.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                trat.setIdTratamiento(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tratamiento añadida con exito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Materia " + ex.getMessage());
        }
    }

    public void modificarTratamiento(Tratamiento trat) {
        String sql = "UPDATE tratamiento SET descripcion=?,medicamento=?, TipoTratamiento=?, importe=?, activo=? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, trat.getDescripcion());
            ps.setString(2, trat.getMedicamento());
            ps.setString(3, trat.getTipoTratamiento());
            ps.setDouble(4, trat.getImporte());
            ps.setBoolean(5, trat.isActivo());
            int exito = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "el tratamiento no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento" + ex.getMessage());

        }
    }

    public void eliminarTratamiento(int id) {
        try {
            String sql = "UPDATE tratamiento SET activo=0 WHERE idTrtamiento=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino el tratamiento");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tratamiento" + ex.getMessage());

        }

    }

    public List<Tratamiento> listarTratamiento() {
        List<Tratamiento> tratamiento = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tratamiento WHERE activo =1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tratamiento tr = new Tratamiento();
                tr.setIdTratamiento(rs.getInt("idTratamiento"));
                tr.setDescripcion(rs.getString("Descripcion"));
                tr.setMedicamento(rs.getString("medicamento"));
                tr.setImporte(rs.getDouble("importe"));
                tr.setActivo(rs.getBoolean("activo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TratamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tratamiento;
    }

    public List<Mascota> obtenerMascotasMismoTratamiento(String tratamiento) {                              // chekear metodo
        List<Mascota> mascotasList = new ArrayList<>();
        String sql = "SELECT m.idMascota, alias, especie, raza FROM visita v, mascota m, tratamiento t WHERE v.idMascota=m.idMascota AND v.idTratamiento=t.idTratamiento AND t.tipoTratamiento=? AND m.activo=1";
        
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, tratamiento);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                Mascota masc = new Mascota();
                masc.setIdMascota(rs.getInt("idMascota"));
                masc.setAlias(rs.getString("alias"));
                masc.setEspecie(rs.getString("especie"));
                masc.setRaza(rs.getString("raza"));
                
                mascotasList.add(masc);
            }
            ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo la tabla MASCOTA : " + ex.getMessage());
        }
        return mascotasList;

        }

    }
