/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import AccesoDatos.MascotaData;
import AccesoDatos.TratamientoData;
import AccesoDatos.VisitaData;
import Entidades.EnumTipoTratamiento;
import Entidades.Mascota;
import Entidades.Tratamiento;
import Entidades.Visita;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class CargarVisita extends javax.swing.JInternalFrame {

    /**
     * Creates new form CargarVisita
     */
    public CargarVisita() {
        initComponents();
        cargarComboBox();
        jlInternado.setVisible(false);
        jbBorrarVisita.setVisible(false);
        jbEditar.setVisible(false);
        jtfAlias.setText(MenuPrincipal.jtfMemoAlias.getText());

        LocalDate fechaHoy = LocalDate.now();
        Date visita = Date.from(fechaHoy.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        jdcFechaVisita.setDate(visita);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpClienteNew = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfAlias = new javax.swing.JTextField();
        jtfPesoActual = new javax.swing.JTextField();
        jbInternar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jdcFechaVisita = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaDetalle = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jdcFechaAlta = new com.toedter.calendar.JDateChooser();
        jbAmbulatorio = new javax.swing.JButton();
        jlInternado = new javax.swing.JLabel();
        jpMAscotaNew = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlTipoTratamiento = new javax.swing.JLabel();
        jtfMedicamento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbGuardarVisita = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescripcion = new javax.swing.JTextArea();
        jcbTipo = new javax.swing.JComboBox<>();
        jbEditar = new javax.swing.JButton();
        jbBorrarVisita = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfImporte = new javax.swing.JTextField();

        setClosable(true);

        jLabel6.setText("Peso Actual:");

        jLabel3.setText("Detalle:");

        jLabel2.setText("Fecha de Visita:");

        jLabel1.setText("Mascota \"Alias\"");

        jtfAlias.setEditable(false);

        jtfPesoActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPesoActualKeyTyped(evt);
            }
        });

        jbInternar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/internado.png"))); // NOI18N
        jbInternar.setText("Internar");
        jbInternar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInternarActionPerformed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("VISITA");

        jtaDetalle.setColumns(20);
        jtaDetalle.setRows(5);
        jScrollPane2.setViewportView(jtaDetalle);

        jLabel5.setText("Fecha Alta:");

        jbAmbulatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/internado.png"))); // NOI18N
        jbAmbulatorio.setText("Ambulatorio");
        jbAmbulatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAmbulatorioActionPerformed(evt);
            }
        });

        jlInternado.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        jlInternado.setForeground(new java.awt.Color(255, 0, 0));
        jlInternado.setText("Internado");

        javax.swing.GroupLayout jpClienteNewLayout = new javax.swing.GroupLayout(jpClienteNew);
        jpClienteNew.setLayout(jpClienteNewLayout);
        jpClienteNewLayout.setHorizontalGroup(
            jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClienteNewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpClienteNewLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jpClienteNewLayout.createSequentialGroup()
                        .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFechaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPesoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jpClienteNewLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jbInternar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAmbulatorio)
                        .addGap(22, 22, 22))))
            .addGroup(jpClienteNewLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jlInternado)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpClienteNewLayout.setVerticalGroup(
            jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClienteNewLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(19, 19, 19)
                .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(17, 17, 17)
                .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jdcFechaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpClienteNewLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel7))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jtfPesoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jpClienteNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbInternar)
                    .addComponent(jbAmbulatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jlInternado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jLabel15.setText("Medicamento:");

        jLabel16.setText("Descripcion:");

        jlTipoTratamiento.setText("Tipo de Tratamiento:");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("TRATAMIENTO");

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbGuardarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok.png"))); // NOI18N
        jbGuardarVisita.setText("Guardar");
        jbGuardarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarVisitaActionPerformed(evt);
            }
        });

        jtaDescripcion.setColumns(20);
        jtaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jtaDescripcion);

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbBorrarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/borrarCarpeta.png"))); // NOI18N
        jbBorrarVisita.setText("Borrar");

        jLabel4.setText("Importe:");

        jtfImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfImporteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jpMAscotaNewLayout = new javax.swing.GroupLayout(jpMAscotaNew);
        jpMAscotaNew.setLayout(jpMAscotaNewLayout);
        jpMAscotaNewLayout.setHorizontalGroup(
            jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                        .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMAscotaNewLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                        .addComponent(jlTipoTratamiento)
                                        .addGap(26, 26, 26)
                                        .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26))
                            .addComponent(jLabel15)
                            .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                        .addComponent(jbBorrarVisita)
                                        .addGap(115, 115, 115)
                                        .addComponent(jbCancelar))
                                    .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                        .addComponent(jbGuardarVisita)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbEditar)))))))
                .addGap(42, 42, 42))
        );
        jpMAscotaNewLayout.setVerticalGroup(
            jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(14, 14, 14)
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipoTratamiento)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(60, 60, 60)
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbGuardarVisita)
                    .addComponent(jbEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBorrarVisita)
                    .addComponent(jbCancelar))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpClienteNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199)
                .addComponent(jpMAscotaNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpMAscotaNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpClienteNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        jtfAlias.setText("");
        jdcFechaAlta.setDate(null);
        jdcFechaVisita.setDate(null);
        jtaDetalle.setText("");
        jtfPesoActual.setText("");
        jtaDescripcion.setText("");
        jtfMedicamento.setText("");
        jtfImporte.setText("");
        jbBorrarVisita.setEnabled(false);
        jbEditar.setEnabled(false);


    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGuardarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarVisitaActionPerformed
        if (jtfAlias.getText().isEmpty() || jdcFechaVisita.getDate() == null || jtaDescripcion.getText().isEmpty() || jtaDetalle.getText().isEmpty() || jtfPesoActual.getText().isEmpty() || jtfMedicamento.getText().isEmpty() || jtfImporte.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos de Visita/Tratatamiento para cargar una nueva Visita en el Sistema");
        } else {
            try {

                String alias = jtfAlias.getText();
                LocalDate fechaVisita = jdcFechaVisita.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                ///a revisar

                String descrip = jtaDescripcion.getText();
                String detalle = jtaDetalle.getText();
                String medicam = jtfMedicamento.getText();
                double pesoActual = Double.parseDouble(jtfPesoActual.getText());
                double importe = Double.parseDouble(jtfImporte.getText());
                String tipoTrata = jcbTipo.getSelectedItem().toString();

                TratamientoData td = new TratamientoData();
                Tratamiento t = new Tratamiento();
                t.setActivo(true);
                t.setDescripcion(descrip);
                t.setImporte(importe);
                t.setMedicamento(medicam);
                t.setTipoTratamiento(tipoTrata);
                t.setUsuarioLog("fifi");

                VisitaData vd = new VisitaData();
                Visita v = new Visita();
                v.setActivo(true);
                v.setDetalle(detalle);
                if (!jlInternado.isEnabled()) {
                    LocalDate fechaAlta = jdcFechaAlta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    fechaAlta = fechaVisita;
                    v.setFechaAlta(fechaAlta);
                }
                v.setFechaVisita(fechaVisita);
                v.setPesoActual(pesoActual);
                v.setTratamiento(t);
                v.setUsuarioLog("fifi");

                MascotaData md = new MascotaData();
                Mascota mascota = md.buscarMascotaId(Integer.parseInt(MenuPrincipal.jtfMemoMascotaId.getText()));
                v.setMascota(mascota);
                System.out.println("" + mascota);
                System.out.println("ccc");

                int input = JOptionPane.showConfirmDialog(null, "Esta seguro de cargar la Nueva Visita/Tratamiento en el Sistema?", "Seleccione una opcion...",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (input == 0) {

                    Tratamiento trata = td.guardarTratmiento(t);
                    if (trata == null) {
                        JOptionPane.showMessageDialog(this, "ERROR en la generacion del Tratamiento...");
                    } else {
                        v.setTratamiento(trata);
                        vd.guardarVisita(v);
                        jbBorrarVisita.setEnabled(true);
                        jbEditar.setEnabled(true);
                        jbGuardarVisita.setEnabled(false);
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Debe poner un numero en peso y/o importe");
            }
// if (jtfAlias.getText().isEmpty() || jtfEspecie.getText().isEmpty() || jtfRaza.getText().isEmpty() || jtfSexo.getText().isEmpty() || jtfColorPelo.getText().isEmpty() || jdcFechaNac.getDate() == null) {
//            JOptionPane.showMessageDialog(this, "Debe completar todos los campos de MAscota para cargar una nueva Mascota en el Sistema");
//        } else {
//            try {
//                String alias = jtfAlias.getText();
//                String especie = jtfEspecie.getText();
//                String raza = jtfRaza.getText();
//                //char sexo =  jtfSexo.getText().charAt(0);
//                String sexo = jtfSexo.getText().toUpperCase().substring(0, 0);
//                String colorPelo = jtfColorPelo.getText();
//                LocalDate fechaNac = jdcFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//                int dni = Integer.parseInt(jtfDni.getText());
//                ClienteData cd = new ClienteData();
//                Cliente cliente = cd.buscarClienteDni(dni);
//
//                MascotaData md = new MascotaData();
//                Mascota m = new Mascota();
//                m.setAlias(alias);
//                m.setEspecie(especie);
//                m.setRaza(raza);
//                m.setSexo(sexo);
//                m.setColorPelo(colorPelo);
//                m.setFechaNac(fechaNac);
//                m.setActivo(true);
//                m.setUsuarioLog("pipin");
//                m.setCliente(cliente);
//                int input = JOptionPane.showConfirmDialog(null, "Esta seguro de cargar la Nueva Mascota  en el Sistema?", "Seleccione una opcion...",
//                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
//                if (input == 0) {
//                    md.guardarMascota(m);
//                    jbGenerarVisita.setEnabled(true);
//                    jbGuardarMasc.setEnabled(false);
//                }
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(this, "Debe poner un numero en DNI y/o telefonos");
//            }
//
        }
    }//GEN-LAST:event_jbGuardarVisitaActionPerformed

    private void jbInternarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInternarActionPerformed
        jdcFechaAlta.setDate(null);
        jlInternado.setVisible(true);
        jdcFechaAlta.setEnabled(false);

    }//GEN-LAST:event_jbInternarActionPerformed

    private void jbAmbulatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAmbulatorioActionPerformed
        jdcFechaAlta.setDate(jdcFechaVisita.getDate());
        jlInternado.setVisible(false);
        jdcFechaAlta.setEnabled(true);

    }//GEN-LAST:event_jbAmbulatorioActionPerformed

    private void jtfPesoActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoActualKeyTyped
        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
        if (evt.getKeyChar() == KeyEvent.VK_SPACE) {
        }

    }//GEN-LAST:event_jtfPesoActualKeyTyped

    private void jtfImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfImporteKeyTyped
        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
        if (evt.getKeyChar() == KeyEvent.VK_SPACE) {
        }

    }//GEN-LAST:event_jtfImporteKeyTyped

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAmbulatorio;
    private javax.swing.JButton jbBorrarVisita;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbGuardarVisita;
    private javax.swing.JButton jbInternar;
    private javax.swing.JComboBox<String> jcbTipo;
    private com.toedter.calendar.JDateChooser jdcFechaAlta;
    private com.toedter.calendar.JDateChooser jdcFechaVisita;
    private javax.swing.JLabel jlInternado;
    private javax.swing.JLabel jlTipoTratamiento;
    private javax.swing.JPanel jpClienteNew;
    private javax.swing.JPanel jpMAscotaNew;
    private javax.swing.JTextArea jtaDescripcion;
    private javax.swing.JTextArea jtaDetalle;
    private javax.swing.JTextField jtfAlias;
    public static javax.swing.JTextField jtfImporte;
    private javax.swing.JTextField jtfMedicamento;
    private javax.swing.JTextField jtfPesoActual;
    // End of variables declaration//GEN-END:variables
public void cargarComboBox() {

        for (EnumTipoTratamiento enumTipo : EnumTipoTratamiento.values()) {
            jcbTipo.addItem(enumTipo.toString());
        }
    }

}
