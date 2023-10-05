/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Loggin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LogginData {

    private Connection con = null;

    public LogginData() {

        con = Conexion.getConexion();
    }
//
//    public boolean validacionLoggin(Loggin loggin) {
//        String sql = "SELECT avatar  FROM loggin WHERE usuario=? AND pw=?";
//        PreparedStatement ps = null;
//        String avatar = "";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, loggin.getUsuraio());
//            ps.setString(2, loggin.getPw());
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                avatar = rs.getString(avatar);
//                JOptionPane.showMessageDialog(null, "El usuario " + loggin.getUsuraio() + " esta Loggeado OK...");
//                return true;
//            } else {
//                JOptionPane.showMessageDialog(null, "No existe ese Usuario / Contraseña");
//
//            }
//            ps.close();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla LoggIn " + ex.getMessage());
//        }
//        return false;
//    }

    public Loggin validacionLoggin(String usuario, String pw) {
        Loggin valido = null;
        String sql = "SELECT avatar  FROM loggin WHERE usuario=? AND pw=?";
        PreparedStatement ps = null;
        //String avatar = "";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pw);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // avatar = rs.getString(avatar);
                valido = new Loggin();
                valido.setUsuraio(usuario);
                valido.setPw(pw);
                valido.setAvatar(rs.getString("avatar"));

                JOptionPane.showMessageDialog(null, "El usuario " + usuario + " esta Loggeado OK...");

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Usuario / Contraseña");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BaseDatos: tabla LoggIn " + ex.getMessage());
        }
        return valido;
    }
}
