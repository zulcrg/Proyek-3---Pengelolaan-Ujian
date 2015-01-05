/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.panitia;

import com.jtk.pengelolaanujian.controller.panitiaController.AssignUjianController;
import com.jtk.pengelolaanujian.entity.Kelas;
import com.jtk.pengelolaanujian.entity.Ruangan;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.util.EnumPanel;
import com.jtk.pengelolaanujian.view.util.SearchDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author pahlevi
 */
public class AssignUjian extends javax.swing.JPanel {

    private Ujian ujian;
    private Staf staf;
    private Ruangan ruangan;
    private Kelas kelas;

    /**
     * Creates new form AssignUjian
     */
    public AssignUjian() {
        initComponents();
    }

    public void preparation() {
        ujian = new Ujian();
        staf = new Staf();
        ruangan = new Ruangan();
        kelas = new Kelas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUjian = new javax.swing.JLabel();
        textUjian = new javax.swing.JTextField();
        btnBrowseUjian = new javax.swing.JButton();
        labelPengawas = new javax.swing.JLabel();
        textPengawas = new javax.swing.JTextField();
        btwBrowsePengawas = new javax.swing.JButton();
        btnBrowseRuangan = new javax.swing.JButton();
        labelRuangan = new javax.swing.JLabel();
        textRuangan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        labelRuangan1 = new javax.swing.JLabel();
        textKelas = new javax.swing.JTextField();
        btnBrowseKelas = new javax.swing.JButton();

        labelUjian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelUjian.setText("Ujian");

        textUjian.setEditable(false);

        btnBrowseUjian.setText("Browse");
        btnBrowseUjian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseUjianActionPerformed(evt);
            }
        });

        labelPengawas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPengawas.setText("Pengawas");

        textPengawas.setEditable(false);

        btwBrowsePengawas.setText("Browse");
        btwBrowsePengawas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btwBrowsePengawasActionPerformed(evt);
            }
        });

        btnBrowseRuangan.setText("Browse");
        btnBrowseRuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseRuanganActionPerformed(evt);
            }
        });

        labelRuangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRuangan.setText("Ruangan");

        textRuangan.setEditable(false);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        labelRuangan1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRuangan1.setText("Kelas");

        textKelas.setEditable(false);

        btnBrowseKelas.setText("Browse");
        btnBrowseKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseKelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUjian)
                    .addComponent(labelPengawas)
                    .addComponent(labelRuangan)
                    .addComponent(labelRuangan1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textKelas)
                    .addComponent(textUjian, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(textPengawas, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textRuangan, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSimpan)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBrowseRuangan)
                            .addComponent(btnBrowseUjian)
                            .addComponent(btwBrowsePengawas)))
                    .addComponent(btnBrowseKelas))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUjian)
                    .addComponent(textUjian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseUjian))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPengawas)
                    .addComponent(textPengawas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btwBrowsePengawas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBrowseRuangan)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelRuangan)
                        .addComponent(textRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRuangan1)
                    .addComponent(textKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseKelas))
                .addGap(17, 17, 17)
                .addComponent(btnSimpan)
                .addContainerGap(101, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseUjianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseUjianActionPerformed
        SearchDialog searchDialog = new SearchDialog(null, true, ujian, EnumPanel.SEARCH_UJIAN);
        searchDialog.show();
        textUjian.setText(ujian.getUjianNama());
    }//GEN-LAST:event_btnBrowseUjianActionPerformed

    private void btwBrowsePengawasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btwBrowsePengawasActionPerformed
        SearchDialog searchDialog = new SearchDialog(null, true, staf, EnumPanel.SEARCH_PENGAWAS);
        searchDialog.show();
        textPengawas.setText(staf.getStafNama());
    }//GEN-LAST:event_btwBrowsePengawasActionPerformed

    private void btnBrowseRuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseRuanganActionPerformed
        SearchDialog searchDialog = new SearchDialog(null, true, ruangan, EnumPanel.SEARCH_RUANGAN);
        searchDialog.show();
        textRuangan.setText(ruangan.getRuanganNama());
    }//GEN-LAST:event_btnBrowseRuanganActionPerformed

    private void btnBrowseKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseKelasActionPerformed
        SearchDialog searchDialog = new SearchDialog(null, true, kelas, EnumPanel.SEARCH_KELAS);
        searchDialog.show();
        textKelas.setText(kelas.getKelasNama());
    }//GEN-LAST:event_btnBrowseKelasActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (ujian.getUjianKode() == null) {
            JOptionPane.showMessageDialog(null, "Harap pilih ujian", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (ruangan.getRuanganKode() == null) {
            JOptionPane.showMessageDialog(null, "Harap pilih ruangan", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (staf.getStafNIP() == null) {
            JOptionPane.showMessageDialog(null, "Harap pilih staff", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (kelas.getKelasKode() == null) {
            JOptionPane.showMessageDialog(null, "Harap pilih kelas", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else {
            AssignUjianController assignUjianController = new AssignUjianController();
            assignUjianController.createRuanganUjian(ujian.getUjianKode(), ruangan.getRuanganKode(), staf.getStafNIP(), kelas.getKelasKode());
            ujian = new Ujian();
            ruangan = new Ruangan();
            staf = new Staf();
            kelas = new Kelas();
            textUjian.setText("");
            textRuangan.setText("");
            textPengawas.setText("");
            textKelas.setText("");
        }
    }//GEN-LAST:event_btnSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseKelas;
    private javax.swing.JButton btnBrowseRuangan;
    private javax.swing.JButton btnBrowseUjian;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btwBrowsePengawas;
    private javax.swing.JLabel labelPengawas;
    private javax.swing.JLabel labelRuangan;
    private javax.swing.JLabel labelRuangan1;
    private javax.swing.JLabel labelUjian;
    private javax.swing.JTextField textKelas;
    private javax.swing.JTextField textPengawas;
    private javax.swing.JTextField textRuangan;
    private javax.swing.JTextField textUjian;
    // End of variables declaration//GEN-END:variables

}
