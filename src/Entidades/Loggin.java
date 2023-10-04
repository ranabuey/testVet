/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author titun
 */
public class Loggin {
    
    private int idLoggin;
    private String usuraio;
    private String pw;

    public Loggin(int idLoggin, String usuraio, String pw) {
        this.idLoggin = idLoggin;
        this.usuraio = usuraio;
        this.pw = pw;
    }

    public Loggin(String usuraio, String pw) {
        this.usuraio = usuraio;
        this.pw = pw;
    }

    public int getIdLoggin() {
        return idLoggin;
    }

    public String getUsuraio() {
        return usuraio;
    }

    public String getPw() {
        return pw;
    }

    @Override
    public String toString() {
        return "Loggin{" + "idLoggin=" + idLoggin + ", usuraio=" + usuraio + ", pw=" + pw + '}';
    }

    public void setIdLoggin(int idLoggin) {
        this.idLoggin = idLoggin;
    }

    public void setUsuraio(String usuraio) {
        this.usuraio = usuraio;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
    
    
}
