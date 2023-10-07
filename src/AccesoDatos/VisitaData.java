
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VisitaData {
    
    private Connection con = null;
    private MascotaData masData;
    private TratamientoData trataData;
   

    public VisitaData() {
        
        con = Conexion.getConexion();
        masData=new MascotaData();
        trataData=new TratamientoData();
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
            ps.setBoolean(7, vis.isActivo());
            ps.setDate(8, Date.valueOf(vis.getFechaAlta()));
            ps.setString(9, vis.getUsuarioLog());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                vis.setIdVisita(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Visita añadida con exito");
            }
            //ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Visita " + ex.getMessage());
       } catch (NullPointerException np) {
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

 public List<Visita> obtenerVisita() {
        List<Visita> visList = new ArrayList<>();
        visList.clear();
        try {
            String sql = "SELECT * FROM visita";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Visita visita = new Visita();
                visita.setIdVisita(rs.getInt("idVisita"));
                visita.setFechaVisita(rs.getDate("fechaVisita").toLocalDate());
                visita.setDetalle(rs.getString("detalle"));
                visita.setPesoActual(rs.getDouble("pesoActual"));
                //visita.setTratamiento(trataData.);
                visita.setActivo(rs.getBoolean("activo"));
                visita.setInternado(rs.getBoolean("internado"));
                visita.setFechaAlta(rs.getDate("fechaAlta").toLocalDate());
                visita.setUsuarioLog(rs.getString("usuarioLog"));
                visList.add(visita);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return visList;
}
  public List<Visita> obtenerVisitasXMascota(int id) {
        VisitaData visdata = new VisitaData();
        List<Visita> visList = new ArrayList<>();
        visList.addAll(visdata.obtenerVisita());

        List<Visita> visListMascota = new ArrayList<>();
        visListMascota.clear();

        for (Visita visita : visList) {
            if (visita.getMascota().getIdMascota()== id) {
                visListMascota.add(visita);
            }
        }
        if (visList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encuentra Mascota con ese ID");
        }
        return visListMascota;
    }
}

