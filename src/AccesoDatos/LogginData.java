/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;



public class LogginData {
    private Connection con = null;

    public LogginData() {
        
        con = Conexion.getConexion();
    }
    
    
      
      
}
