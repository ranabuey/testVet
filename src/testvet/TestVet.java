/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testvet;

import AccesoDatos.ClienteData;
import AccesoDatos.Conexion;
import AccesoDatos.MascotaData;
import AccesoDatos.TratamientoData;
import AccesoDatos.VisitaData;
import Entidades.Cliente;
import Entidades.Mascota;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author titun
 */
public class TestVet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClienteData cd = new ClienteData();
        MascotaData md = new MascotaData();
        VisitaData vd = new VisitaData();
        TratamientoData td = new TratamientoData();

        Cliente c1 = new Cliente(20123456, "JAcinto", "Smith", "piporete 32", "titi", 111111111, 22222222, "titus", true);
        Mascota m1 = new Mascota("coco", "m", "canino", "golden", "rubio", LocalDate.of(2010, Month.MARCH, 23), 3, 3.5, true, LocalDate.of(2023, Month.OCTOBER, 1), c1, "esteban");

        cd.guardarCliente(c1);
        md.guardarMascota(m1);

    }

}
