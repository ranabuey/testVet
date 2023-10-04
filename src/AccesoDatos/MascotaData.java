
package AccesoDatos;

import java.sql.Connection;

public class MascotaData {
    
    private Connection con = null;

    public MascotaData() {
        
        con = Conexion.getConexion();
    }
    
    
}
