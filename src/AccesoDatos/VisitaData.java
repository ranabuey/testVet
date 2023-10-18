
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
import java.time.LocalDate;
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
  public List<Visita> obtenerVisitasXCliente(int id) {
        VisitaData visdata = new VisitaData();
        List<Visita> visList = new ArrayList<>();
        visList.addAll(visdata.obtenerVisita());

        List<Visita> visListMascota = new ArrayList<>();
        visListMascota.clear();

        for (Visita visita : visList) {
            if (visita.getMascota().getCliente().getIdCliente()== id) {
                visListMascota.add(visita);
            }
        }
        if (visList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encuentra Mascota con ese ID");
        }
        return visListMascota;
    }
   public List<Tratamiento> obtenerTratamientoNoAlta(LocalDate fechaAlta) {
        TratamientoData traData = new TratamientoData();
        List<Tratamiento> traList = new ArrayList<>();
        traList.addAll(trataData.listarTratamiento());

        List<Tratamiento> trataList = new ArrayList<>();
        trataList.clear();

        for (Tratamiento tratamiento : traList) {
            if (tratamiento.getVisita().getFechaAlta()==null) {
                trataList.add(tratamiento);
            }
        }
        if (traList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encuentra Tratamiento");
        }
        return traList;
    }
   
    public boolean chkVisitaMismoDia(Visita visita) {                   //hay q testear // faltaban los metodos de buscar tratamiento x id (q devuelva un tratamiento) y buscar visita por id

        List<Visita> visChkList = new ArrayList<>();
        visChkList.clear();
        try {
            String sql = "SELECT * FROM visita WHERE idMascota=? AND fechaVisita=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, visita.getMascota().getIdMascota());
            ps.setDate(2, Date.valueOf(visita.getFechaVisita()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla VISITA / " + ex.getMessage());
        }
        return false;
    }

    public Visita buscarVisitaXid(int id) {                             //hay q testear // faltaban los metodos de buscar tratamiento x id (q devuelva un tratamiento) y buscar visita por id
        Visita visita = new Visita();
        visita = null;
        PreparedStatement ps = null;
        
        Mascota mascota = null;
        
        Tratamiento tratamiento = null;
        
        String sql = "SELECT * FROM visita WHERE idVisita=? AND activo=1";            //ver el * en sql
        

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {                                            //ver el orden de las columnas?
                System.out.println(""+rs.getInt("idMascota"));
                mascota = masData.buscarMascotaId(rs.getInt("idMascota"));
                System.out.println(""+rs.getInt("idTratamiento"));
                tratamiento=trataData.buscarTratamientoXId(rs.getInt("idTratamiento"));   
                visita.setIdVisita(rs.getInt("idVisita"));
                visita.setFechaVisita(rs.getDate("fechaVisita").toLocalDate());
                visita.setDetalle(rs.getString("detalle"));
                visita.setPesoActual(rs.getDouble("pesoActual"));
                visita.setMascota(mascota);
                visita.setTratamiento(tratamiento);
                visita.setActivo(rs.getBoolean("activo"));
                visita.setInternado(rs.getBoolean("internado"));
                visita.setFechaAlta(rs.getDate("fechaAlta").toLocalDate());
                visita.setUsuarioLog(rs.getString("usuarioLog"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe la Visita");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla VISITA / " + ex.getMessage());
        }

        return visita;
    }

}



