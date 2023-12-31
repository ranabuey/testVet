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
import java.sql.DatabaseMetaData;
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

        jbOk.setEnabled(false);
        LocalDate fechaHoy = LocalDate.now();
        Date visita = Date.from(fechaHoy.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        jdcFechaVisita.setDate(visita);

        try {

            if (!MenuPrincipal.jtfMemoVisitaID.getText().isEmpty()) {
                VisitaData vd = new VisitaData();
                Visita v = vd.buscarVisitaXid(Integer.parseInt(MenuPrincipal.jtfMemoVisitaID.getText()));

                System.out.println(v);

                jtfIdVis.setText("" + v.getIdVisita());

                //
                jtfAlias.setText(MenuPrincipal.jtfMemoAlias.getText());
                jtfPesoActual.setText("" + v.getPesoActual());
                jtaDetalle.setText("" + v.getDetalle());
                Date fechaVis = Date.from(v.getFechaVisita().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                jdcFechaVisita.setDate(fechaVis);

                if (v.getFechaAlta() != null) {
                    Date fechaAlta = Date.from(v.getFechaAlta().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                    jdcFechaVisita.setDate(fechaAlta);
                } else {
                    jlInternado.setVisible(true);
                }
                TratamientoData td = new TratamientoData();
                Tratamiento tra = new Tratamiento();
                tra = td.buscarTratamientoXId(v.getTratamiento().getIdTratamiento());
                jtfIdTra.setText("" + tra.getIdTratamiento());
                jtfImporte.setText("" + tra.getImporte());
                jtfMedicamento.setText("" + tra.getMedicamento());
                jtaDescripcion.setText("" + tra.getDescripcion());
                //  jcbTipo.get
                jbGuardarVisita.setEnabled(false);
                jbOk.setEnabled(true);
                jbBorrarVisita.setEnabled(true);
            }
        } catch (NullPointerException e) {
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
        jbOk = new javax.swing.JButton();
        jbPagar = new javax.swing.JButton();
        jlIdVisita = new javax.swing.JLabel();
        jlIdTrata = new javax.swing.JLabel();
        jtfIdVis = new javax.swing.JTextField();
        jtfIdTra = new javax.swing.JTextField();

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
                .addGap(67, 67, 67)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlInternado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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
        jbBorrarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarVisitaActionPerformed(evt);
            }
        });

        jLabel4.setText("Importe:");

        jtfImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfImporteKeyTyped(evt);
            }
        });

        jbOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jbOk.setText("OK");
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });

        jbPagar.setText("Pagar");
        jbPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMAscotaNewLayout = new javax.swing.GroupLayout(jpMAscotaNew);
        jpMAscotaNew.setLayout(jpMAscotaNewLayout);
        jpMAscotaNewLayout.setHorizontalGroup(
            jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMAscotaNewLayout.createSequentialGroup()
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbGuardarVisita)
                        .addGap(114, 114, 114)
                        .addComponent(jbCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpMAscotaNewLayout.createSequentialGroup()
                        .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                .addContainerGap(47, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMAscotaNewLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                .addComponent(jtfImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbPagar)
                                .addGap(8, 8, 8))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpMAscotaNewLayout.createSequentialGroup()
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
                            .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                .addComponent(jbEditar)
                                .addGap(32, 32, 32)
                                .addComponent(jbOk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbBorrarVisita))
                            .addGroup(jpMAscotaNewLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                    .addComponent(jLabel4)
                    .addComponent(jbPagar))
                .addGap(18, 18, 18)
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBorrarVisita)
                    .addComponent(jbEditar)
                    .addComponent(jbOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpMAscotaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbGuardarVisita))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jtfIdVis.setEditable(false);
        jtfIdVis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdVisActionPerformed(evt);
            }
        });

        jtfIdTra.setEditable(false);
        jtfIdTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpClienteNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlIdVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlIdTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfIdTra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfIdVis, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)))
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
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlIdVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jlIdTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jtfIdVis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jtfIdTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                if (!jlInternado.isVisible()) {
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
                        mascota.setPesoUltimo(v.getPesoActual());
                        mascota.setPesoPromedio(md.obtenerPesoPromedio(mascota.getIdMascota()));
//                        md.modificarMascota(mascota);
                        jbBorrarVisita.setEnabled(true);
                        jbEditar.setEnabled(true);
                        jbGuardarVisita.setEnabled(false);
                        jbEditar.setVisible(true);
                        int edad = md.calcularEdad(mascota.getFechaNac());
                        MenuPrincipal.jtfMemoEdad.setText("" + edad);
                        MenuPrincipal.jtfMemoPesoProm.setText(String.format("%.2f", mascota.getPesoPromedio()));
//                        v.setTratamiento(trata);
//                        Visita visi = vd.guardarVisita(v);
//                        jbBorrarVisita.setEnabled(true);
//                        jbBorrarVisita.setVisible(true);
//                        jbEditar.setEnabled(true);
//                        jbEditar.setVisible(true);
//                        jbGuardarVisita.setEnabled(false);
//                        jbOk.setEnabled(true);
//                        jbOk.setVisible(true);
//                        deshabilitarCampos();
//
//                        jtfIdTra.setText("" + trata.getIdTratamiento());
//                        jtfIdVis.setText("" + visi.getIdVisita());
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Debe poner un numero en peso y/o importe");
            }
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
        habilitarCampos();
        jbOk.setEnabled(true);
        jbBorrarVisita.setEnabled(true);
        jbGuardarVisita.setEnabled(false);
        jbEditar.setEnabled(false);
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
        TratamientoData td = new TratamientoData();
        VisitaData vd = new VisitaData();

        String descrip = jtaDescripcion.getText();
        String detalle = jtaDetalle.getText();
        String medicam = jtfMedicamento.getText();
        double importe = Double.parseDouble(jtfImporte.getText());
        String tipoTrata = jcbTipo.getSelectedItem().toString();
        Tratamiento t = new Tratamiento();
        t.setIdTratamiento(Integer.parseInt(jtfIdTra.getText()));
        t.setActivo(true);
        t.setDescripcion(descrip);
        t.setImporte(importe);
        t.setMedicamento(medicam);
        t.setTipoTratamiento(tipoTrata);
        t.setUsuarioLog("fifi");
        td.modificarTratamiento(t);

        Visita v = new Visita();
        String alias = jtfAlias.getText();
        LocalDate fechaVisita = jdcFechaVisita.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        v.setIdVisita(Integer.parseInt(jtfIdVis.getText()));
        v.setActivo(true);
        v.setDetalle(detalle);
        double pesoActual = Double.parseDouble(jtfPesoActual.getText());
        if (!jlInternado.isVisible()) {
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

        vd.modificarVisita(v);
    }//GEN-LAST:event_jbOkActionPerformed

    private void jbBorrarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarVisitaActionPerformed
        TratamientoData td = new TratamientoData();
        VisitaData vd = new VisitaData();

        td.eliminarTratamiento(Integer.parseInt(jtfIdTra.getText()));
        System.out.println("id trata" + jtfIdTra.getText());
        vd.eliminarVisita(Integer.parseInt(jtfIdVis.getText()));
        borrarCampos();
        jbOk.setEnabled(false);
        jbEditar.setEnabled(false);
        jbGuardarVisita.setEnabled(true);


    }//GEN-LAST:event_jbBorrarVisitaActionPerformed

    private void jtfIdVisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdVisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdVisActionPerformed

    private void jtfIdTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdTraActionPerformed

    private void jbPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagarActionPerformed
        // TODO add your handling code here:
        jtfImporte.setText("0");
        jtfImporte.setVisible(false);
    }//GEN-LAST:event_jbPagarActionPerformed


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
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbPagar;
    private javax.swing.JComboBox<String> jcbTipo;
    private com.toedter.calendar.JDateChooser jdcFechaAlta;
    private com.toedter.calendar.JDateChooser jdcFechaVisita;
    private javax.swing.JLabel jlIdTrata;
    private javax.swing.JLabel jlIdVisita;
    private javax.swing.JLabel jlInternado;
    private javax.swing.JLabel jlTipoTratamiento;
    private javax.swing.JPanel jpClienteNew;
    private javax.swing.JPanel jpMAscotaNew;
    private javax.swing.JTextArea jtaDescripcion;
    private javax.swing.JTextArea jtaDetalle;
    private javax.swing.JTextField jtfAlias;
    private javax.swing.JTextField jtfIdTra;
    private javax.swing.JTextField jtfIdVis;
    public static javax.swing.JTextField jtfImporte;
    private javax.swing.JTextField jtfMedicamento;
    private javax.swing.JTextField jtfPesoActual;
    // End of variables declaration//GEN-END:variables
public void cargarComboBox() {

        for (EnumTipoTratamiento enumTipo : EnumTipoTratamiento.values()) {
            jcbTipo.addItem(enumTipo.toString());
        }
    }

    public void deshabilitarCampos() {
        jbAmbulatorio.setEnabled(false);
        jbInternar.setEnabled(false);
        jtfAlias.setEditable(false);
        jtaDetalle.setEditable(false);
        jtfPesoActual.setEditable(false);
        jdcFechaVisita.setEnabled(false);

        jtaDescripcion.setEditable(false);
        jtfMedicamento.setEditable(false);
        jtfImporte.setEditable(false);
        jcbTipo.setEditable(false);

    }

    public void habilitarCampos() {
        jbAmbulatorio.setEnabled(true);
        jbInternar.setEnabled(true);
        jtfAlias.setEditable(true);
        jtaDetalle.setEditable(true);
        jtfPesoActual.setEditable(true);
        jdcFechaVisita.setEnabled(true);

        jtaDescripcion.setEditable(true);
        jtfMedicamento.setEditable(true);
        jtfImporte.setEditable(true);
        jcbTipo.setEditable(true);
    }

    public void borrarCampos() {
        jtfAlias.setText("");
        jtaDetalle.setText("");
        jtfPesoActual.setText("");
        jdcFechaVisita.setDate(null);
        jdcFechaAlta.setDate(null);

        jtaDescripcion.setText("");
        jtfMedicamento.setText("");
        jtfImporte.setText("");

    }

}
