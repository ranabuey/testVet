
package AccesoDatos;

import Entidades.Mascota;
import Entidades.Cliente;
import Entidades.Tratamiento;
import Entidades.Loggin;
import Entidades.Visita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class VisitaData {
    
    private Connection con = null;
    private MascotaData md;
    private ClienteData cd;
    private TratamientoData td;
   

    public VisitaData() {
        
        con = Conexion.getConexion();
        
    }
    
public void guardarVisita (Visita vis){


    String sql="INSERT INTO visita(idMascota, fechaVisita, detalle, pesoActual, idTratamiento, activo, internado, fechaAlta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try{
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1, vis.getMascota().getIdMascota());
        ps.setDate(2, Date.valueOf(vis.getFechaVisita()));
        ps.setString(3, vis.getDetalle());
        ps.setDouble(4, vis.getPesoActual());
        ps.setInt(5, vis.getTratamiento().getIdTratamiento());
        ps.setBoolean(6, vis.isActivo());
        ps.setBoolean(4, vis.isActivo());
        ps.setDate(8, Date.valueOf(vis.getFechaAlta()));
    }catch (SQLException ex){
    
    }
}
public void modificarVisita (Visita vis){

//    String sql=
//    try {
//        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//    } catch (SQLException ex) {
//
//}
//
} 

public void eliminarVisita (Visita vis){
//   String sql=
//    try {
//        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//    } catch (SQLException ex) {
//}
//    
//}
}
}
