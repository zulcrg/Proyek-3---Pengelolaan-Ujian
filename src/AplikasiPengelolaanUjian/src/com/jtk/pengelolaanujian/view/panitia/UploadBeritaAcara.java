/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.view.panitia;

import com.jtk.pengelolaanujian.controller.panitiaController.AssignBeritaAcaraController;
import com.jtk.pengelolaanujian.controller.panitiaController.UpdateBeritaAcaraController;
import com.jtk.pengelolaanujian.entity.BeritaAcara;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import java.util.List;

/**
 *
 * @author pahlevi
 */
public class UploadBeritaAcara extends javax.swing.JPanel {
    AssignBeritaAcaraController assignBeritaAcaraController = new AssignBeritaAcaraController();
    UpdateBeritaAcaraController updateBeritaAcaraController = new UpdateBeritaAcaraController();
    BeritaAcara beritaAcara;
    List<RuanganUjian> ruanganUjianList;
    RuanganUjian ruanganUjian;
            
    
    /**
     * Creates new form UploadBeritaAcara
     */
    public UploadBeritaAcara() {
        initComponents();
    }
    
    public void preparation(){        
        ruanganUjianList = assignBeritaAcaraController.searchUjianWhere(cboUjian);
        beritaAcara = new BeritaAcara();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboUjian = new javax.swing.JComboBox();
        labelUjian = new javax.swing.JLabel();
        labelKeterangan = new javax.swing.JLabel();
        labelJumlahHadir = new javax.swing.JLabel();
        labelJumlahTidakHadir = new javax.swing.JLabel();
        textJumlahHadir = new javax.swing.JTextField();
        textJumlahTidakHadir = new javax.swing.JTextField();
        labelSoalSisa = new javax.swing.JLabel();
        labelJawabanSisa = new javax.swing.JLabel();
        textSoalSisa = new javax.swing.JTextField();
        textJawabanSisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textKeterangan = new javax.swing.JTextArea();
        btnSimpan = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();

        cboUjian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboUjian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUjianActionPerformed(evt);
            }
        });

        labelUjian.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelUjian.setForeground(new java.awt.Color(51, 51, 51));
        labelUjian.setText("Ujian");

        labelKeterangan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelKeterangan.setForeground(new java.awt.Color(51, 51, 51));
        labelKeterangan.setText("keterangan");

        labelJumlahHadir.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelJumlahHadir.setForeground(new java.awt.Color(51, 51, 51));
        labelJumlahHadir.setText("Jml Hadir");

        labelJumlahTidakHadir.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelJumlahTidakHadir.setForeground(new java.awt.Color(51, 51, 51));
        labelJumlahTidakHadir.setText("Jml Tidak Hadir");

        textJumlahTidakHadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJumlahTidakHadirActionPerformed(evt);
            }
        });

        labelSoalSisa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelSoalSisa.setForeground(new java.awt.Color(51, 51, 51));
        labelSoalSisa.setText("Jml Soal Sisa");

        labelJawabanSisa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelJawabanSisa.setForeground(new java.awt.Color(51, 51, 51));
        labelJawabanSisa.setText("Jml Jawaban Sisa");

        textSoalSisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSoalSisaActionPerformed(evt);
            }
        });

        textKeterangan.setColumns(20);
        textKeterangan.setRows(5);
        jScrollPane1.setViewportView(textKeterangan);

        btnSimpan.setText("Submit");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 153));
        jLabel22.setText("Print Soal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelKeterangan)
                        .addGap(510, 510, 510))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelUjian)
                                    .addComponent(labelJumlahTidakHadir)
                                    .addComponent(labelJumlahHadir)
                                    .addComponent(labelSoalSisa))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelJawabanSisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cboUjian, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(173, 173, 173))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textSoalSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textJawabanSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textJumlahTidakHadir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textJumlahHadir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(81, 81, 81))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpan)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel22)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboUjian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUjian))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJumlahHadir)
                    .addComponent(textJumlahHadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJumlahTidakHadir)
                    .addComponent(textJumlahTidakHadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSoalSisa)
                    .addComponent(textSoalSisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textJawabanSisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJawabanSisa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelKeterangan)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnSimpan)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboUjianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUjianActionPerformed
        
    }//GEN-LAST:event_cboUjianActionPerformed

    private void textJumlahTidakHadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textJumlahTidakHadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textJumlahTidakHadirActionPerformed

    private void textSoalSisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSoalSisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSoalSisaActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:        
        ruanganUjian = ruanganUjianList.get(cboUjian.getSelectedIndex());         
        System.out.println(ruanganUjian.getBeritaKode());        
        
        beritaAcara.setBeritaKode(ruanganUjian.getBeritaKode());                
        beritaAcara.setBeritaHadir(Integer.parseInt(textJumlahHadir.getText()));
        beritaAcara.setBeritaTidakHadir(Integer.parseInt(textJumlahTidakHadir.getText()));
        beritaAcara.setBeritaSoalSisa(Integer.parseInt(textSoalSisa.getText()));
        beritaAcara.setBeritaJawabSisa(Integer.parseInt(textJawabanSisa.getText()));
        beritaAcara.setBeritaKet(textKeterangan.getText());
        
        updateBeritaAcaraController.updateBeritaAcara(beritaAcara);
    }//GEN-LAST:event_btnSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cboUjian;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelJawabanSisa;
    private javax.swing.JLabel labelJumlahHadir;
    private javax.swing.JLabel labelJumlahTidakHadir;
    private javax.swing.JLabel labelKeterangan;
    private javax.swing.JLabel labelSoalSisa;
    private javax.swing.JLabel labelUjian;
    private javax.swing.JTextField textJawabanSisa;
    private javax.swing.JTextField textJumlahHadir;
    private javax.swing.JTextField textJumlahTidakHadir;
    private javax.swing.JTextArea textKeterangan;
    private javax.swing.JTextField textSoalSisa;
    // End of variables declaration//GEN-END:variables

}
