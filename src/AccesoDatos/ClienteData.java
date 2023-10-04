
package AccesoDatos;

import java.sql.Connection;

public class ClienteData {
    
    private Connection con = null;

    public ClienteData() {
        
        con = Conexion.getConexion();
    }
    
    
}
