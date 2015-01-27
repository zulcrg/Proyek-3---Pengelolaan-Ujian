/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.dosenpengampu;

import com.jtk.pengelolaanujian.controller.dosenPengampu.UploadSoalController;
import com.jtk.pengelolaanujian.controller.reminder.Reminder3Controller;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.util.CommonHelper;
import com.jtk.pengelolaanujian.view.LoginPanel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class UploadSoal extends javax.swing.JPanel {

    private final UploadSoalController uploadSoalController = new UploadSoalController();
    private List<Ujian> ujianList;
    private String url;
    private Soal soal;

    /**
     * Creates new form RegistrasiUser
     */
    public UploadSoal() {
        initComponents();
    }

    public void preparation() {
        ujianList = uploadSoalController.searchMatkul(cboMatkul);
        clear();
    }

    public void clear() {
        url = "";
        soal = new Soal();
        soal.setSoalSifat("TUTUP BUKU");
        spinDurasi.setModel(CommonHelper.createDurasiSpinnerModel());
        textUrl.setText("");
        if (ujianList != null && !ujianList.isEmpty()) {
            cboMatkul.setSelectedIndex(0);
        }
        radTutupBuku.setSelected(true);
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
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textUrl = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboMatkul = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        radTutupBuku = new javax.swing.JRadioButton();
        radBukaBuku = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        spinDurasi = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Upload Nilai");

        setForeground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(640, 625));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Pilih File");

        textUrl.setEditable(false);

        btnBrowse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnUpload.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Ujian");

        cboMatkul.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMatkulActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Sifat Ujian");

        buttonGroup1.add(radTutupBuku);
        radTutupBuku.setSelected(true);
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Durasi");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Menit");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Upload Soal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spinDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radTutupBuku)
                                .addGap(18, 18, 18)
                                .addComponent(radBukaBuku))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboMatkul, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBrowse)))
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel7)
                .addGap(71, 71, 71)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(spinDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addComponent(btnUpload)
                .addContainerGap(172, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getTextUsername() {
        return textUrl;
    }

    public void setTextUsername(JTextField textUsername) {
        this.textUrl = textUsername;
    }

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        if (textUrl.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap pilih file yang akan di upload", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (!new File(url).exists()) {
            JOptionPane.showMessageDialog(null, "File yang anda upload tidak ada", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (spinDurasi.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Harap isi durasi ujian", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (!CommonHelper.isStringNumberMaxMin(spinDurasi.getValue().toString(), 1000, 1)) {
            JOptionPane.showMessageDialog(null, "Harap isi format durasi dengan benar", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                InputStream is = new FileInputStream(new File(url));
                int durasi = Integer.parseInt(spinDurasi.getValue().toString());
                String tipeFile = FilenameUtils.getExtension(url);
                String namaFile = FilenameUtils.getBaseName(url);
                if (uploadSoalController.uploadSoal(is, ujianList.get(cboMatkul.getSelectedIndex()).getUjianKode(), soal.getSoalSifat(), durasi, tipeFile, namaFile)) {
                    JOptionPane.showMessageDialog(null, "File berhasil di upload", "Perhatian", JOptionPane.INFORMATION_MESSAGE);
                    Reminder3Controller reminder3Controller = new Reminder3Controller();
                    reminder3Controller.preparation();
                    clear();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(UploadSoal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
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

    private void cboMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMatkulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMatkulActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnUpload;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboMatkul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton radBukaBuku;
    private javax.swing.JRadioButton radTutupBuku;
    private javax.swing.JSpinner spinDurasi;
    private javax.swing.JTextField textUrl;
    // End of variables declaration//GEN-END:variables
}
