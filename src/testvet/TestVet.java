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
import Entidades.Tratamiento;
import Entidades.Visita;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author titun
 */
public class TestVet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        ClienteData cd = new ClienteData();
     MascotaData md = new MascotaData();
          VisitaData vd = new VisitaData();
        TratamientoData td = new TratamientoData();
//
////        Cliente c1 = new Cliente(12,"Ernesto", "Smith", "piporete 34", "titi", 585622, 22222222, "titus", true);
//       Cliente c1 = new Cliente(20123456, "Telmo", "Romeo", "piporete 34", "titi", 585622, 22222222, "titus", true);
//       Mascota m1 = new Mascota("coco", "m", "canino", "golden", "rubio", LocalDate.of(2010, Month.MARCH, 23), 3, 3.5, true, LocalDate.of(2023, Month.OCTOBER, 1), c1, "esteban");
//       Tratamiento t1 = new Tratamiento("normal", "vacuna", "forte500mg", 3000, true);
//        Visita v1 = new Visita(m1, LocalDate.of(2023, Month.APRIL, 05), "vacunado", 14, t1, true, false, LocalDate.of(2021, Month.MARCH, 3), "titus");
////
//     cd.modificarCliente(c1);
//     md.guardarMascota(m1);
//      td.guardarTratmiento(t1);
//      vd.guardarVisita(v1);
//        List<Mascota> masList = td.obtenerMascotasMismoTratamiento("pulgas");
//        ArrayList<Mascota> masList = cd.listarMascotasXcliente(4);
//        for (Mascota mascota : masList) {
//            System.out.println("alias: " + mascota.getAlias());
//            System.out.println(".................");

      md.obtenerPesoPromedio();
      
        }
    
    }


