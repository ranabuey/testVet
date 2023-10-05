
package AccesoDatos;

import Entidades.Mascota;
import Entidades.Cliente;
import Entidades.Tratamiento;
import Entidades.Loggin;
import Entidades.Visita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class VisitaData {
    
    private Connection con = null;
    private MascotaData md;
    
    private TratamientoData td;
   

    public VisitaData() {
        
        con = Conexion.getConexion();
        
    }
    
public void guardarVisita (Visita vis){


        String sql = "INSERT INTO visita(idMascota, fechaVisita, detalle, pesoActual, idTratamiento, activo, internado, fechaAlta, usuarioLog) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, vis.getMascota().getIdMascota());
            ps.setDate(2, Date.valueOf(vis.getFechaVisita()));
            ps.setString(3, vis.getDetalle());
            ps.setDouble(4, vis.getPesoActual());
            ps.setInt(5, vis.getTratamiento().getIdTratamiento());
            ps.setBoolean(6, vis.isActivo());
            ps.setBoolean(4, vis.isActivo());
            ps.setDate(8, Date.valueOf(vis.getFechaAlta()));
            ps.setString(9, vis.getUsuarioLog());

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                vis.setIdVisita(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Visita añadida con exito");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Visita " + ex.getMessage());
        }catch(NullPointerException np){
        }

    }

public void modificarVisita (Visita vis){

    String sql = "UPDATE VISITA SET fechaVisita=?, detalle=?, pesoActual=?, activo=?, internado=?, fechaAlta=?  WHERE idVisita=? ";
    PreparedStatement ps = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setDate(1, Date.valueOf(vis.getFechaVisita()));
        ps.setString(2, vis.getDetalle());
        ps.setDouble(3, vis.getPesoActual());
        ps.setBoolean(4, vis.isActivo());
        ps.setBoolean(5, vis.isActivo());
        ps.setDate(6, Date.valueOf(vis.getFechaAlta()));
        int exito = ps.executeUpdate();

        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Modificado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "La visita no existe");
        }
        ps.close();                                                               //no se encuentra en la teoria. va?
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());

    }

} 

public void eliminarVisita (int id){
   
    try{
            String sql = "UPDATE visita SET activo=0 WHERE idVisita=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino la visita");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Visita");
        }
    }
}

