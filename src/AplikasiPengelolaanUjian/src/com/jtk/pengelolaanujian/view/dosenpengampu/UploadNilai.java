/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.dosenpengampu;

import com.jtk.pengelolaanujian.controller.dosenPengampu.UploadNilaiController;
import com.jtk.pengelolaanujian.entity.Nilai;
import com.jtk.pengelolaanujian.entity.Ruangan;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Ujian;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class UploadNilai extends javax.swing.JPanel {

    private final UploadNilaiController uploadNilaiController = new UploadNilaiController();
    private List<Ujian> ujianList;
    private List<Ruangan> ruanganList;
    private List<RuanganUjian> ruanganUjianList;
    private String url;
    private Nilai nilai;

    /**
     * Creates new form RegistrasiUser
     */
    public UploadNilai() {
        initComponents();
    }

    public void preparation() {
        ruanganUjianList = uploadNilaiController.searchUjianByUsername(cboUjian);
        clear();
    }

    private void clear() {
        url = "";
        textUrl.setText("");
        nilai = new Nilai();
    }

    public void searchRuangan() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textUrl = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboUjian = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Registrasi User");

        setMinimumSize(new java.awt.Dimension(640, 625));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Pilih File");

        textUrl.setEditable(false);

        btnBrowse.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnBrowse.setText("Cari");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnUpload.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Pelaksanaan Ujian");

        cboUjian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboUjian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUjianActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Upload Nilai");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboUjian, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(textUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBrowse))
                        .addGap(117, 117, 117))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel6)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cboUjian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnUpload)
                .addGap(173, 173, 173))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getTextUsername() {
        return textUrl;
    }

    public void setTextUsername(JTextField textUsername) {
        this.textUrl = textUsername;
    }

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        if (url != null && !url.isEmpty()) {
            if (new File(url).exists()) {
                try {
                    nilai.setNamaFile(FilenameUtils.getBaseName(url));
                    nilai.setNilaiFile(new FileInputStream(new File(url)));
                    nilai.setKelasKode(ruanganUjianList.get(cboUjian.getSelectedIndex()).getKelasKode());
                    nilai.setTipeFile(FilenameUtils.getExtension(url));
                    nilai.setUjianKode(ruanganUjianList.get(cboUjian.getSelectedIndex()).getUjianKode());

                    if (uploadNilaiController.uploadNilai(nilai)) {
                        JOptionPane.showMessageDialog(null, "Upload nilai berhasil");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(UploadNilai.class.getName()).log(Level.SEVERE, null, ex);
                }
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

    private void cboUjianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUjianActionPerformed
        searchRuangan();
    }//GEN-LAST:event_cboUjianActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox cboUjian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField textUrl;
    // End of variables declaration//GEN-END:variables
}
