/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.panitia;

import com.jtk.pengelolaanujian.controller.panitiaController.CreateUjianController;
import com.jtk.pengelolaanujian.controller.panitiaController.EventController;
import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.util.CommonHelper;
import com.jtk.pengelolaanujian.util.EnumPanel;
import com.jtk.pengelolaanujian.view.LoginPanel;
import com.jtk.pengelolaanujian.view.util.SearchDialog;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class CreateUjian extends javax.swing.JPanel {

    private MataKuliah mataKuliah;
    private Event event;

    /**
     * Creates new form CreateUjian
     */
    public CreateUjian() {
        initComponents();
    }

    public void preparation() {
        event = LoginPanel.getEvent();
        textEvent.setText(CommonHelper.createTahun(event));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNamaUjian = new javax.swing.JLabel();
        textNamaUjian = new javax.swing.JTextField();
        labelEventUjian = new javax.swing.JLabel();
        dateUjianMulai = new com.toedter.calendar.JDateChooser();
        labelTanggal = new javax.swing.JLabel();
        labelPukul = new javax.swing.JLabel();
        textJam = new javax.swing.JTextField();
        labelPukul1 = new javax.swing.JLabel();
        textMenit = new javax.swing.JTextField();
        labelArsipSoal = new javax.swing.JLabel();
        textMatkul = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnCreateUjian = new javax.swing.JButton();
        textEvent = new javax.swing.JTextField();
        labelArsipSoal1 = new javax.swing.JLabel();
        textKodeSoal = new javax.swing.JTextField();

        labelNamaUjian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNamaUjian.setText("Nama Ujian");

        labelEventUjian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEventUjian.setText("Event Ujian");

        dateUjianMulai.setPreferredSize(new java.awt.Dimension(90, 20));

        labelTanggal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTanggal.setText("Tanggal");

        labelPukul.setText("Pukul");

        labelPukul1.setText(":");

        labelArsipSoal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelArsipSoal.setText("Mata Kuliah");

        textMatkul.setEditable(false);

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnCreateUjian.setText("Create Ujian");
        btnCreateUjian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUjianActionPerformed(evt);
            }
        });

        textEvent.setEditable(false);
        textEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEventActionPerformed(evt);
            }
        });

        labelArsipSoal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelArsipSoal1.setText("Kode Soal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEventUjian)
                    .addComponent(labelTanggal)
                    .addComponent(labelArsipSoal)
                    .addComponent(labelNamaUjian)
                    .addComponent(labelArsipSoal1))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCreateUjian)
                    .addComponent(textKodeSoal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNamaUjian, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textMatkul, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textEvent, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateUjianMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPukul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textJam, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPukul1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBrowse)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEventUjian)
                    .addComponent(textEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNamaUjian)
                    .addComponent(textNamaUjian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArsipSoal)
                    .addComponent(textMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArsipSoal1)
                    .addComponent(textKodeSoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPukul)
                        .addComponent(textJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPukul1)
                        .addComponent(textMenit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateUjianMulai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(btnCreateUjian)
                .addContainerGap(252, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEventActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        mataKuliah = new MataKuliah();
        SearchDialog searchDialog = new SearchDialog(null, true, mataKuliah, EnumPanel.SEARCH_SOAL);
        searchDialog.show();
        textMatkul.setText(mataKuliah.getMatkulNama());
        textNamaUjian.setText(mataKuliah.getMatkulNama());
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnCreateUjianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUjianActionPerformed
        if (textNamaUjian.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi nama ujian", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (mataKuliah == null) {
            JOptionPane.showMessageDialog(null, "Harap pilih mata kuliah", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (textKodeSoal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi kode soal", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (textKodeSoal.getText().length() > 5) {
            JOptionPane.showMessageDialog(null, "Kode soal tidak boleh melebihi 5 karakter", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (dateUjianMulai.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Harap isi tanggal mulai ujian", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (textJam.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi jam mulai ujian", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (!CommonHelper.isStringNumberMaxMin(textJam.getText(), 23, 0)) {
            JOptionPane.showMessageDialog(null, "Harap isi format jam dengan benar", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (textMenit.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi menit mulai ujian", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else if (!CommonHelper.isStringNumberMaxMin(textMenit.getText(), 59, 0)) {
            JOptionPane.showMessageDialog(null, "Harap isi format menit dengan benar", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else {
            CreateUjianController controller = new CreateUjianController();
            Date date = new Date();
            date.setTime(date.getTime());
            date.setHours(Integer.parseInt(textJam.getText()));
            date.setMinutes(Integer.parseInt(textMenit.getText()));
            date.setSeconds(0);

            if (controller.createUjian(event.getKode(), textNamaUjian.getText(),
                    textKodeSoal.getText(), mataKuliah, date)) {
                textNamaUjian.setText("");
                mataKuliah = new MataKuliah();
                textMatkul.setText("");
                textKodeSoal.setText("");
                textJam.setText("");
                textMenit.setText("");
            }
        }
    }//GEN-LAST:event_btnCreateUjianActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCreateUjian;
    private com.toedter.calendar.JDateChooser dateUjianMulai;
    private javax.swing.JLabel labelArsipSoal;
    private javax.swing.JLabel labelArsipSoal1;
    private javax.swing.JLabel labelEventUjian;
    private javax.swing.JLabel labelNamaUjian;
    private javax.swing.JLabel labelPukul;
    private javax.swing.JLabel labelPukul1;
    private javax.swing.JLabel labelTanggal;
    private javax.swing.JTextField textEvent;
    private javax.swing.JTextField textJam;
    private javax.swing.JTextField textKodeSoal;
    private javax.swing.JTextField textMatkul;
    private javax.swing.JTextField textMenit;
    private javax.swing.JTextField textNamaUjian;
    // End of variables declaration//GEN-END:variables

}
