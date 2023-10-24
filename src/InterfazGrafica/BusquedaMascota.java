/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import AccesoDatos.MascotaData;
import Entidades.Cliente;
import Entidades.Mascota;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class BusquedaMascota extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    MascotaData md = new MascotaData();

    public BusquedaMascota() {
        initComponents();
        armarCabecera();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMascotas = new javax.swing.JTable();
        jcbTipoBusqueda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jtfbusqueda = new javax.swing.JTextField();
        jbBusqMascotas = new javax.swing.JButton();
        jbHacerVisita = new javax.swing.JButton();
        jbEditarMascota = new javax.swing.JButton();
        jbSelMascota = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbReActivar = new javax.swing.JButton();

        jLabel1.setText("BUSQUEDA MASCOTA");

        jtMascotas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtMascotas);

        jcbTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alias", "Raza", "Especie", "Eliminadas", "DNI Cliente", "TODAS", " " }));

        jLabel2.setText("Buscar por: ");

        jbBusqMascotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/buscarMascota.png"))); // NOI18N
        jbBusqMascotas.setText("Buscar");
        jbBusqMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBusqMascotasActionPerformed(evt);
            }
        });

        jbHacerVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/usar.png"))); // NOI18N
        jbHacerVisita.setText("Visita");
        jbHacerVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHacerVisitaActionPerformed(evt);
            }
        });

        jbEditarMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jbEditarMascota.setText("Editar");
        jbEditarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarMascotaActionPerformed(evt);
            }
        });

        jbSelMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/usar.png"))); // NOI18N
        jbSelMascota.setText("Seleccionar");
        jbSelMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelMascotaActionPerformed(evt);
            }
        });

        jbBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/borrarCarpeta.png"))); // NOI18N
        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jbReActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/nuevo cliente.png"))); // NOI18N
        jbReActivar.setText("ReActivar");
        jbReActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jbSelMascota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbReActivar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBorrar)
                        .addGap(46, 46, 46)
                        .addComponent(jbEditarMascota)
                        .addGap(26, 26, 26)
                        .addComponent(jbHacerVisita))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jtfbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jbBusqMascotas)))))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBusqMascotas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditarMascota)
                    .addComponent(jbHacerVisita)
                    .addComponent(jbSelMascota)
                    .addComponent(jbReActivar)
                    .addComponent(jbBorrar))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBusqMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBusqMascotasActionPerformed
        limpiarTablaMacotas();                                                              ///FALTA HACER TODO ACA

        try {
            String busq = jtfbusqueda.getText();
            
            if (jcbTipoBusqueda.getSelectedIndex() == 0) {                  //Alias
                jbReActivar.setVisible(false);
                jbBorrar.setVisible(true);

                List<Mascota> listamasc = md.listarMascotas();
                for (Mascota mascota : listamasc) {

                    if (mascota.getAlias().startsWith(busq)) {
                        modelo.addRow(new Object[]{
                            mascota.getIdMascota(),
                            mascota.getAlias(),
                            mascota.getCliente().getApellido(),
                            mascota.getEspecie(),
                            mascota.getRaza(),
                            mascota.getSexo(),
                            mascota.getColorPelo(),
                            mascota.getFechaNac(),
                            mascota.getPesoUltimo(),
                            mascota.getPesoPromedio()
                        });
                    }
                }
                if (jtMascotas.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "No se encontro MAscotas con ese criterio.");
                }

            } else {
                if (jcbTipoBusqueda.getSelectedIndex() == 1) {                //Raza

                    jbReActivar.setVisible(false);
                    jbBorrar.setVisible(true);
//                    Cliente cliente = cd.buscarClienteTel(Integer.parseInt(jtfBusquedas.getText()));
//                    
//                    modelo.addRow(new Object[]{
//                        cliente.getIdCliente(),
//                        cliente.getApellido(),
//                        cliente.getNombre(),
//                        cliente.getTelefono(),
//                        cliente.getDni(),});
//                    
//                } else if (jcbTipoBusqueda.getSelectedIndex() == 2) {         //Especie
//                    jbReActivar.setVisible(false);
//                    jbBorrar.setVisible(true);
//                    String busq = jtfBusquedas.getText();
//                    List<Cliente> listaCli = cd.listarClientes();
//                    for (Cliente cliente : listaCli) {
//                        if (cliente.getApellido().startsWith(busq)) {
//                            modelo.addRow(new Object[]{
//                                cliente.getIdCliente(),
//                                cliente.getApellido(),
//                                cliente.getNombre(),
//                                cliente.getTelefono(),
//                                cliente.getDni(),});
//                        }
//                    }
//                    if (jtClientes.getRowCount() == 0) {
//                        JOptionPane.showMessageDialog(this, "No se encontro clientes con ese criterio.");
//                    }
//                } else if (jcbTipoBusqueda.getSelectedIndex() == 3) {         //Eliminadas
//                    jbBorrar.setVisible(false);
//                    List<Cliente> listaCli = cd.listarClientesNoActivos();
//                    for (Cliente cliente : listaCli) {
//                        
//                        modelo.addRow(new Object[]{
//                            cliente.getIdCliente(),
//                            cliente.getApellido(),
//                            cliente.getNombre(),
//                            cliente.getTelefono(),
//                            cliente.getDni(),});
//                    }
//                    jbReActivar.setVisible(true);
//                }
//                
                } else if (jcbTipoBusqueda.getSelectedIndex() == 4) {            //DNI Cliente

                } else if (jcbTipoBusqueda.getSelectedIndex() == 5) {            //todas

                }

            }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "debe poner un numero");
        }
    }//GEN-LAST:event_jbBusqMascotasActionPerformed

    private void jbHacerVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHacerVisitaActionPerformed
//        MascotaData md = new MascotaData();
//        int filaSel = jtMascotas.getSelectedRow();
//
//        MenuPrincipal.jtfMemoMascotaId.setText("" + modelo2.getValueAt(filaSel, 0));
//        MenuPrincipal.jtfMemoAlias.setText("" + modelo2.getValueAt(filaSel, 1));
//        MenuPrincipal.jtfMemoEspecie.setText("" + modelo2.getValueAt(filaSel, 2));
//        MenuPrincipal.jtfMemoRaza.setText("" + modelo2.getValueAt(filaSel, 3));
//
//        LocalDate fechaNac = (LocalDate) modelo2.getValueAt(filaSel, 5);                           //     FALTA VER COMO AGREGAR OBJETO A LOCAL DATE
//        int edad = md.calcularEdad(fechaNac);
//        MenuPrincipal.jtfMemoEdad.setText("" + edad);
//        double pesoProm = md.obtenerPesoPromedio((Integer) modelo2.getValueAt(filaSel, 0));
//        MenuPrincipal.jtfMemoPesoProm.setText("" + pesoProm);
//
//        CargarVisita cv = new CargarVisita();
//        MenuPrincipal.jDesktopPane1.add(cv);
//
//        cv.toFront();
//        cv.setVisible(true);

    }//GEN-LAST:event_jbHacerVisitaActionPerformed

    private void jbEditarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarMascotaActionPerformed

    private void jbSelMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelMascotaActionPerformed
//        try {
//            int filaSel = jtClientes.getSelectedRow();
//            int dni = (Integer) modelo.getValueAt(filaSel, 4);
//            MascotaData md = new MascotaData();
//            MenuPrincipal.jtfMemoClienteID.setText("" + modelo.getValueAt(filaSel, 0));
//            MenuPrincipal.jtfMemoClienteApellido.setText("" + modelo.getValueAt(filaSel, 1));
//            MenuPrincipal.jtfMemoClienteNombre.setText("" + modelo.getValueAt(filaSel, 2));
//            MenuPrincipal.jtfMemoTelefono.setText("" + modelo.getValueAt(filaSel, 3));
//            MenuPrincipal.jtfMemoClienteDNI.setText("" + modelo.getValueAt(filaSel, 4));
//
//            List<Mascota> mascList = md.listarMascotasXIDCliente((Integer) jtClientes.getValueAt(filaSel, 0));
//            for (Mascota mascota : mascList) {
//                modelo2.addRow(new Object[]{
//                    mascota.getIdMascota(),
//                    mascota.getAlias(),
//                    mascota.getEspecie(),
//                    mascota.getRaza(),
//                    mascota.getSexo(),
//                    mascota.getFechaNac()});
//        }
//
//        } catch (ArrayIndexOutOfBoundsException e) {
//            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
//        }
    }//GEN-LAST:event_jbSelMascotaActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        try {

            ClienteData cd = new ClienteData();
            int filaSel = jtClientes.getSelectedRow();
            int input = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE QUERER ELIMINAR DEL SISTEMA AL CLIENTE " + modelo.getValueAt(filaSel, 1) + ", DNI: " + modelo.getValueAt(filaSel, 4), "Seleccione una opcion...",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            if (input == 0) {
                Cliente c = new Cliente();
                c = cd.buscarClienteDni((Integer) (modelo.getValueAt(filaSel, 4)));
                cd.eliminarCliente(c.getIdCliente());
                limpiarTablaClientes();
                jbBorrar.setVisible(false);
            } else {

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
        }
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbReActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReActivarActionPerformed
        try {

            ClienteData cd = new ClienteData();
            int filaSel = jtClientes.getSelectedRow();
            int input = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE QUERER Re-Activar AL SISTEMA AL CLIENTE " + modelo.getValueAt(filaSel, 1) + ", DNI: " + modelo.getValueAt(filaSel, 4), "Seleccione una opcion...",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            if (input == 0) {
                Cliente c = new Cliente();
                c = cd.buscarClienteDni((Integer) (modelo.getValueAt(filaSel, 4)));
                cd.reActivarCliente(c.getIdCliente());
                limpiarTablaClientes();
                jbReActivar.setVisible(false);
            } else {

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
        }

    }//GEN-LAST:event_jbReActivarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBusqMascotas;
    private javax.swing.JButton jbEditarMascota;
    private javax.swing.JButton jbHacerVisita;
    private javax.swing.JButton jbReActivar;
    private javax.swing.JButton jbSelMascota;
    private javax.swing.JComboBox<String> jcbTipoBusqueda;
    private javax.swing.JTable jtMascotas;
    private javax.swing.JTextField jtfbusqueda;
    // End of variables declaration//GEN-END:variables
private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Alias");
        modelo.addColumn("Apellido Cliente");
        modelo.addColumn("Especie");
        modelo.addColumn("Raza");
        modelo.addColumn("Sexo");
        modelo.addColumn("Color Pelo");
        modelo.addColumn("Fecha Nac.");
        modelo.addColumn("PesoUltimo");
        modelo.addColumn("PesoProm");
        jtMascotas.setModel(modelo);
    }

    private void limpiarTablaMacotas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
}
