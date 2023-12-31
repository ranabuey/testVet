/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Entidades.Tratamiento;
import Entidades.EnumTipoTratamiento;
import Entidades.Mascota;
import AccesoDatos.ClienteData;
import AccesoDatos.MascotaData;
import AccesoDatos.VisitaData;
import AccesoDatos.TratamientoData;
import Entidades.Cliente;
import Entidades.EnumTipoTratamiento;
import Entidades.Mascota;
import Entidades.Visita;
import com.toedter.calendar.JDateChooser;
import java.awt.PopupMenu;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class BusquedaVisita extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    MascotaData md = new MascotaData();
    VisitaData vd = new VisitaData();

    /**
     * Creates new form BusquedaVisita
     */
    public BusquedaVisita() {
        initComponents();
        armarCabecera();
        cargarCombo();
        cargarComboCliente();
        limpiarTabla();

        if (!MenuPrincipal.jtfMemoMascotaId.getText().isEmpty()) {
            int IdMasc = Integer.parseInt(MenuPrincipal.jtfMemoMascotaId.getText());
            Mascota m = md.buscarMascotaId(IdMasc);

            List<Visita> listaVisitas = vd.obtenerVisitaxIdMascota(IdMasc);

            for (Visita listaVisita : listaVisitas) {
                modelo.addRow(new Object[]{
                    listaVisita.getMascota().getCliente().getIdCliente(),
                    listaVisita.getMascota().getAlias(),
                    listaVisita.getMascota().getEspecie(),
                    listaVisita.getFechaVisita(),
                    listaVisita.getTratamiento().getTipoTratamiento(),
                    listaVisita.getTratamiento().getImporte(),
                    listaVisita.getIdVisita()});
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVisita = new javax.swing.JTable();
        jcbTipoTratamiento = new JComboBox<>(EnumTipoTratamiento.values());
        jcbTipoTratamiento.setSelectedItem(null);
        ;
        jcbCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbInternado = new javax.swing.JButton();
        jbSeleccionar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jbFiltrar = new javax.swing.JButton();
        jcbMascotas = new javax.swing.JComboBox<>();

        setClosable(true);

        jLabel1.setText("BUSQUEDA VISITAS");

        jtVisita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtVisita);

        jcbTipoTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoTratamientoActionPerformed(evt);
            }
        });

        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("MASCOTAS:");

        jLabel3.setText("TIPO TRATAMIENTO:");

        jLabel4.setText("CLIENTE:");

        jbInternado.setText("INTERNADOS");
        jbInternado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInternadoActionPerformed(evt);
            }
        });

        jbSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/usar.png"))); // NOI18N
        jbSeleccionar.setText("Seleccionar");
        jbSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeleccionarActionPerformed(evt);
            }
        });

        jLabel5.setText("FECHAS");

        jLabel6.setText("Y");

        jLabel7.setText("ENTRE");

        jbFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok.png"))); // NOI18N
        jbFiltrar.setText("FILTRAR");
        jbFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(22, 22, 22)
                        .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbFiltrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jdcFechaInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jdcFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel7)))
                    .addComponent(jbFiltrar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jcbMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMascotasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jbSeleccionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcbMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jcbTipoTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbInternado))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jbInternado)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSeleccionar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoTratamientoActionPerformed
        // TODO add your handling code here:
        TratamientoData trataData = new TratamientoData();
        limpiarTabla();
        EnumTipoTratamiento tipoTratamientoSeleccionado = (EnumTipoTratamiento) jcbTipoTratamiento.getSelectedItem();

        if (tipoTratamientoSeleccionado != null) {
            List<Mascota> listaMascotas = trataData.obtenerMascotasMismoTratamiento(tipoTratamientoSeleccionado);

            for (Mascota mascota : listaMascotas) {
                modelo.addRow(new Object[]{
                    mascota.getCliente().getIdCliente(),
                    mascota.getAlias(),
                    mascota.getEspecie(),});
            }


    }//GEN-LAST:event_jcbTipoTratamientoActionPerformed
    }
    private void jbInternadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInternadoActionPerformed
        // TODO add your handling code here:
        limpiarTabla();

        VisitaData vd = new VisitaData();
        MascotaData md = new MascotaData();
//        

//
        List<Visita> listaVisitas = vd.obtenerMascotasInternadas();
//        System.out.println("id:"+mascSele.getIdMascota());
//        System.out.println(""+listaVisitas);
//        System.out.println("mb");

        for (Visita listaVisita : listaVisitas) {
            modelo.addRow(new Object[]{
                listaVisita.getMascota().getCliente().getIdCliente(),
                listaVisita.getMascota().getAlias(),
                listaVisita.getMascota().getEspecie(),
                listaVisita.getFechaVisita(),
                listaVisita.getTratamiento().getTipoTratamiento(),
                listaVisita.getTratamiento().getImporte(),
                listaVisita.getIdVisita()});

        }
    }//GEN-LAST:event_jbInternadoActionPerformed

    @SuppressWarnings("empty-statement")
    private void jcbMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMascotasActionPerformed
        // TODO add your handling code here:
        limpiarTabla();

        VisitaData vd = new VisitaData();
        MascotaData md = new MascotaData();
//        TratamientoData td= new TratamientoData();
        Mascota mascSele = (Mascota) jcbMascotas.getSelectedItem();
//
        List<Visita> listaVisitas = vd.obtenerVisitaxIdMascota(mascSele.getIdMascota());
       

        for (Visita listaVisita : listaVisitas) {
            modelo.addRow(new Object[]{
                listaVisita.getMascota().getCliente().getIdCliente(),
                listaVisita.getMascota().getAlias(),
                listaVisita.getMascota().getEspecie(),
                listaVisita.getFechaVisita(),
                listaVisita.getTratamiento().getTipoTratamiento(),
                listaVisita.getTratamiento().getImporte(),
                listaVisita.getIdVisita()});

        }
    }//GEN-LAST:event_jcbMascotasActionPerformed

    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed
        // TODO add your handling code here:
        limpiarTabla();

        VisitaData vd = new VisitaData();
        ClienteData cd = new ClienteData();
//      TratamientoData td= new TratamientoData();
        Cliente clientSele = (Cliente) jcbCliente.getSelectedItem();
//
        List<Visita> listaVisitas = vd.obtenerVisitasXCliente(clientSele.getIdCliente());

        for (Visita listaVisita : listaVisitas) {
            modelo.addRow(new Object[]{
                listaVisita.getMascota().getCliente().getIdCliente(),
                listaVisita.getMascota().getAlias(),
                listaVisita.getMascota().getEspecie(),
                listaVisita.getFechaVisita(),
                listaVisita.getTratamiento().getTipoTratamiento(),
                listaVisita.getTratamiento().getImporte(),
                listaVisita.getIdVisita()});

        }

    }//GEN-LAST:event_jcbClienteActionPerformed

    private void jbFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltrarActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        try {
            LocalDate fechaI = jdcFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaF = jdcFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (fechaI == null || fechaF == null) {
                JOptionPane.showMessageDialog(this, "Debe ingresar dos fechas validas");
            } else if (fechaI.isAfter(fechaF)) {
                JOptionPane.showMessageDialog(rootPane, "Debe ingresar las fechas correctamente");
            } else {
                VisitaData vd = new VisitaData();
                ClienteData cd = new ClienteData();
//      TratamientoData td= new TratamientoData();

                List<Visita> listaVisitas = vd.obtenerVisitasEntreFechas(fechaI, fechaF);

                for (Visita listaVisita : listaVisitas) {
                    modelo.addRow(new Object[]{
                        listaVisita.getMascota().getCliente().getIdCliente(),
                        listaVisita.getMascota().getAlias(),
                        listaVisita.getMascota().getEspecie(),
                        listaVisita.getFechaVisita(),
                        listaVisita.getTratamiento().getTipoTratamiento(),
                        listaVisita.getTratamiento().getImporte(),
                        listaVisita.getIdVisita()});
                }
            }
        } catch (NullPointerException n) {
        }

    }//GEN-LAST:event_jbFiltrarActionPerformed

    private void jbSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeleccionarActionPerformed
        int filaSel = jtVisita.getSelectedRow();
        MenuPrincipal.jtfMemoVisitaID.setText("" + modelo.getValueAt(filaSel, 6));

        CargarVisita cv = new CargarVisita();
        MenuPrincipal.jDesktopPane1.add(cv);

        cv.toFront();
        cv.setVisible(true);

    }//GEN-LAST:event_jbSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbFiltrar;
    private javax.swing.JButton jbInternado;
    private javax.swing.JButton jbSeleccionar;
    private javax.swing.JComboBox<Cliente> jcbCliente;
    private javax.swing.JComboBox<Mascota> jcbMascotas;
    private javax.swing.JComboBox<EnumTipoTratamiento> jcbTipoTratamiento;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JTable jtVisita;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {

        modelo.addColumn("CLIENTE");
        modelo.addColumn("ALIAS");
        modelo.addColumn("ESPECIE");
        modelo.addColumn("FECHA DE VISITA");
        modelo.addColumn("TIPO DE TRATAMIENTO");
        modelo.addColumn("IMPORTE");
        modelo.addColumn("id");
        jtVisita.setModel(modelo);
    }

    private void limpiarTabla() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void cargarCombo() {
        MascotaData md = new MascotaData();
        List<Mascota> listaMascotas = new ArrayList<>();
        listaMascotas = md.listarMascotas();

        for (Mascota mascota : listaMascotas) {
            jcbMascotas.addItem(mascota);

        }

    }

    private void cargarComboCliente() {
        ClienteData cd = new ClienteData();
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes = cd.listarClientes();

        for (Cliente cliente : listaClientes) {
            jcbCliente.addItem(cliente);

        }
    }
}
