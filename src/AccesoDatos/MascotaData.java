
package AccesoDatos;

import Entidades.Mascota;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MascotaData {
    
    private Connection con = null;

    public MascotaData() {
        
        con = Conexion.getConexion();
    }
    
    public void guardarMascota(Mascota mascota) {

        String sql = "INSERT INTO mascota(alias, sexo, especie, raza, colorPelo, fechaNac, activo, pesoUltimo, pesoPromedio, fechaDefuncion, idCliente, UsuarioLog) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mascota.setIdMascota(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Mascota añadida con exito. ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mascota. " + ex.getMessage());
        }

    }
    
}
