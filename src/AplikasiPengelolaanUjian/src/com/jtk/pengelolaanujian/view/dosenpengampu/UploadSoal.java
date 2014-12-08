/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.dosenpengampu;

import com.jtk.pengelolaanujian.controller.dosenPengampu.UploadSoalController;
import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.entity.Soal;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class UploadSoal extends javax.swing.JPanel {

    private final UploadSoalController uploadSoalController = new UploadSoalController();
    private List<MataKuliah> mataKuliahList;
    private String url;
    private Soal soal;

    /**
     * Creates new form RegistrasiUser
     */
    public UploadSoal() {
        initComponents();
    }

    public void preparation() {
        mataKuliahList = uploadSoalController.searchMatkul(cboMatkul);
        url = "";
        soal = new Soal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        textUrl = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboMatkul = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        radTutupBuku = new javax.swing.JRadioButton();
        radBukaBuku = new javax.swing.JRadioButton();

        jLabel1.setText("Pilih File");

        textUrl.setEditable(false);

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        jLabel2.setText("Mata Kuliah");

        cboMatkul.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Sifat Ujian");

        buttonGroup1.add(radTutupBuku);
        radTutupBuku.setText("Tutup Buku");
        radTutupBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTutupBukuActionPerformed(evt);
            }
        });

        buttonGroup1.add(radBukaBuku);
        radBukaBuku.setText("Buka Buku");
        radBukaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBukaBukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radTutupBuku)
                                .addGap(18, 18, 18)
                                .addComponent(radBukaBuku))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboMatkul, 0, 284, Short.MAX_VALUE)
                                    .addComponent(textUrl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBrowse))
                            .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(radTutupBuku)
                    .addComponent(radBukaBuku))
                .addGap(18, 18, 18)
                .addComponent(btnUpload)
                .addContainerGap(299, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getTextUsername() {
        return textUrl;
    }

    public void setTextUsername(JTextField textUsername) {
        this.textUrl = textUsername;
    }

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed

    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            url = fileChooser.getSelectedFile().getAbsolutePath();
            textUrl.setText(url);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void radTutupBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radTutupBukuActionPerformed
        soal.setSoalSifat("TUTUP BUKU");
    }//GEN-LAST:event_radTutupBukuActionPerformed

    private void radBukaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBukaBukuActionPerformed
        soal.setSoalSifat("BUKA BUKU");
    }//GEN-LAST:event_radBukaBukuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnUpload;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboMatkul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton radBukaBuku;
    private javax.swing.JRadioButton radTutupBuku;
    private javax.swing.JTextField textUrl;
    // End of variables declaration//GEN-END:variables
}
