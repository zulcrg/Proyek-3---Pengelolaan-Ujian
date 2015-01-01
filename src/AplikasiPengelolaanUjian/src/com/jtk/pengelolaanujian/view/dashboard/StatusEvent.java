/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.view.dashboard;

import com.jtk.pengelolaanujian.controller.dashboard.TriggerDashboardController;
import com.jtk.pengelolaanujian.entity.Event;
import java.util.Arrays;

/**
 *
 * @author pahlevi
 */
public class StatusEvent extends javax.swing.JPanel {

    TriggerDashboardController triggerDashboardController = new TriggerDashboardController();
    Event event;
    
    /**
     * Creates new form StatusEvent
     */
    public StatusEvent() {
        initComponents();        
    }
    
    public void preparation(){
        event=triggerDashboardController.getListEvent();
        String ujian = "Ujian ";
        char[] a;
        a = new char[5];
        a=event.getKode().toCharArray();                
               
        if(a[3]=='T'){
            ujian = ujian + "Tengah semester ";
        }else{
            ujian = ujian + "Akhir semester ";
        }
        
        if(a[2]=='1'){
            ujian = ujian + "Genap ";
        }else{
            ujian = ujian + "Ganjil ";
        }
        ujian = ujian+"Tahun 20"+a[0]+a[1];
        
        textUjian.setText(ujian);
        textEventMulai.setText(event.getTanggalMulai().toString());
        textEventAkhir.setText(event.getTanggalSelesai().toString());
        textNilaiAkhir.setText(event.getUploadNilaiSelesai().toString());
        textSoalMulai.setText(event.getUploadMulai().toString());
        textSoalAkhir.setText(event.getUploadSelesai().toString());
        textVnvMulai.setText(event.getVnvMulai().toString());
        textVnvAkhir.setText(event.getVnvSelesai().toString());
        
        triggerDashboardController.viewTableUjian(tableUjian);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelHeader1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelUjian = new javax.swing.JLabel();
        textUjian = new javax.swing.JTextField();
        textEventMulai = new javax.swing.JTextField();
        textEventAkhir = new javax.swing.JTextField();
        labelPelaksanaan = new javax.swing.JLabel();
        textSoalMulai = new javax.swing.JTextField();
        textSoalAkhir = new javax.swing.JTextField();
        textVnvMulai = new javax.swing.JTextField();
        textVnvAkhir = new javax.swing.JTextField();
        textNilaiAkhir = new javax.swing.JTextField();
        labelUploadSoal = new javax.swing.JLabel();
        labelBerakhirPada = new javax.swing.JLabel();
        labelUploadSoal2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelUploadSoal3 = new javax.swing.JLabel();
        labelHeader2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUjian = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHeader1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelHeader1.setText("Ujian yang akan diselenggarakan");
        add(labelHeader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 77, -1, -1));

        labelUjian.setText("Ujian");
        add(labelUjian, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 54, -1, -1));

        textUjian.setEditable(false);
        textUjian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUjianActionPerformed(evt);
            }
        });
        add(textUjian, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 51, 230, -1));

        textEventMulai.setEditable(false);
        textEventMulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEventMulaiActionPerformed(evt);
            }
        });
        add(textEventMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 83, 99, -1));

        textEventAkhir.setEditable(false);
        textEventAkhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEventAkhirActionPerformed(evt);
            }
        });
        add(textEventAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 83, 99, -1));

        labelPelaksanaan.setText("Pelaksanaan");
        add(labelPelaksanaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 86, -1, -1));

        textSoalMulai.setEditable(false);
        textSoalMulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSoalMulaiActionPerformed(evt);
            }
        });
        add(textSoalMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 121, 99, -1));

        textSoalAkhir.setEditable(false);
        textSoalAkhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSoalAkhirActionPerformed(evt);
            }
        });
        add(textSoalAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 121, 99, -1));

        textVnvMulai.setEditable(false);
        textVnvMulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textVnvMulaiActionPerformed(evt);
            }
        });
        add(textVnvMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 159, 99, -1));

        textVnvAkhir.setEditable(false);
        textVnvAkhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textVnvAkhirActionPerformed(evt);
            }
        });
        add(textVnvAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 159, 99, -1));

        textNilaiAkhir.setEditable(false);
        textNilaiAkhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNilaiAkhirActionPerformed(evt);
            }
        });
        add(textNilaiAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 99, -1));

        labelUploadSoal.setText("Upload Soal");
        add(labelUploadSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 124, -1, -1));

        labelBerakhirPada.setText("Berakhir Pada");
        add(labelBerakhirPada, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        labelUploadSoal2.setText("Upload VNV");
        add(labelUploadSoal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 162, -1, -1));

        jLabel4.setText("-");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 124, -1, -1));

        jLabel5.setText("-");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 162, -1, -1));

        jLabel6.setText("-");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 86, -1, -1));

        jLabel7.setText("-");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 162, -1, -1));

        labelUploadSoal3.setText("Upload Nilai");
        add(labelUploadSoal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 200, -1, -1));

        labelHeader2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelHeader2.setText("Beranda Informasi Event Ujian Terkini");
        add(labelHeader2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 11, -1, -1));

        tableUjian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ujian", "Kode Soal", "Kode Matkul", "Pelaksanaan", "Ruangan", "Pengawas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableUjian);
        if (tableUjian.getColumnModel().getColumnCount() > 0) {
            tableUjian.getColumnModel().getColumn(0).setResizable(false);
            tableUjian.getColumnModel().getColumn(1).setResizable(false);
            tableUjian.getColumnModel().getColumn(2).setResizable(false);
            tableUjian.getColumnModel().getColumn(3).setResizable(false);
            tableUjian.getColumnModel().getColumn(4).setResizable(false);
            tableUjian.getColumnModel().getColumn(5).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 620, 170));
    }// </editor-fold>//GEN-END:initComponents

    private void textUjianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUjianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUjianActionPerformed

    private void textEventMulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEventMulaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEventMulaiActionPerformed

    private void textEventAkhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEventAkhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEventAkhirActionPerformed

    private void textSoalMulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSoalMulaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSoalMulaiActionPerformed

    private void textSoalAkhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSoalAkhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSoalAkhirActionPerformed

    private void textVnvMulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textVnvMulaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textVnvMulaiActionPerformed

    private void textVnvAkhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textVnvAkhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textVnvAkhirActionPerformed

    private void textNilaiAkhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNilaiAkhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNilaiAkhirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBerakhirPada;
    private javax.swing.JLabel labelHeader1;
    private javax.swing.JLabel labelHeader2;
    private javax.swing.JLabel labelPelaksanaan;
    private javax.swing.JLabel labelUjian;
    private javax.swing.JLabel labelUploadSoal;
    private javax.swing.JLabel labelUploadSoal2;
    private javax.swing.JLabel labelUploadSoal3;
    private javax.swing.JTable tableUjian;
    private javax.swing.JTextField textEventAkhir;
    private javax.swing.JTextField textEventMulai;
    private javax.swing.JTextField textNilaiAkhir;
    private javax.swing.JTextField textSoalAkhir;
    private javax.swing.JTextField textSoalMulai;
    private javax.swing.JTextField textUjian;
    private javax.swing.JTextField textVnvAkhir;
    private javax.swing.JTextField textVnvMulai;
    // End of variables declaration//GEN-END:variables
}
