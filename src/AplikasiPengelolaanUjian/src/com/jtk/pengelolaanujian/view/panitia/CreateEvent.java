/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.panitia;

import com.jtk.pengelolaanujian.controller.panitiaController.EventController;
import com.jtk.pengelolaanujian.entity.Event;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class CreateEvent extends javax.swing.JPanel {

    /**
     * Creates new form CreateEvent
     */
    public CreateEvent() {
        initComponents();
    }

    public void preparation() {
        textTahun.setText(String.valueOf(new Date().getYear() + 1900));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboSemester = new javax.swing.JComboBox();
        cboUjian = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        datePelaksanaanStart = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        datePelaksanaanEnd = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dateUploadSoalStart = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        dateUploadSoalEnd = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateVnvStart = new com.toedter.calendar.JDateChooser();
        dateVnvEnd = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnCreateEvent = new javax.swing.JButton();
        textTahun = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        dateUploadNilaiEnd = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        delayUploadNilai = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        delayUploadsoal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        spinnerJam = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        spinnerMenit = new javax.swing.JSpinner();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        delayPengawas = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jPasswordField1.setText("jPasswordField1");

        jLabel1.setText("Tahun Pelaksanaan");

        jLabel2.setText("Semester");

        jLabel4.setText("Ujian");

        cboSemester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ganjil", "Genap" }));
        cboSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSemesterActionPerformed(evt);
            }
        });

        cboUjian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UTS", "UAS" }));

        jLabel5.setText("Tanggal Pelaksanaan");

        jLabel6.setText("Dari");

        datePelaksanaanStart.setPreferredSize(new java.awt.Dimension(90, 20));

        jLabel7.setText("Sampai");

        jLabel8.setText("Tanggal Upload Soal");

        jLabel9.setText("Dari");

        dateUploadSoalStart.setPreferredSize(new java.awt.Dimension(90, 20));

        jLabel10.setText("Sampai");

        jLabel11.setText("Tanggal VNV");

        jLabel12.setText("Dari");
        jLabel12.setMaximumSize(new java.awt.Dimension(34, 14));
        jLabel12.setMinimumSize(new java.awt.Dimension(34, 14));
        jLabel12.setPreferredSize(new java.awt.Dimension(34, 14));

        dateVnvStart.setPreferredSize(new java.awt.Dimension(90, 20));

        jLabel13.setText("Sampai");

        btnCreateEvent.setText("Create Event");
        btnCreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEventActionPerformed(evt);
            }
        });

        textTahun.setEditable(false);
        textTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTahunActionPerformed(evt);
            }
        });

        jLabel14.setText("Reminder H - ");

        jLabel16.setText("Tanggal Upload Nilai");

        jLabel18.setText("Sampai");

        dateUploadNilaiEnd.setPreferredSize(new java.awt.Dimension(90, 20));

        jLabel19.setText("Hari");
        jLabel19.setMaximumSize(new java.awt.Dimension(34, 14));
        jLabel19.setMinimumSize(new java.awt.Dimension(34, 14));
        jLabel19.setPreferredSize(new java.awt.Dimension(34, 14));

        delayUploadNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delayUploadNilaiActionPerformed(evt);
            }
        });

        delayUploadsoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delayUploadsoalActionPerformed(evt);
            }
        });

        jLabel20.setText("Reminder Time");

        jLabel21.setText("Jam");

        jLabel22.setText("Menit");

        jLabel15.setText("Reminder H- Pengawas Ujian");

        delayPengawas.setPreferredSize(new java.awt.Dimension(90, 20));
        delayPengawas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delayPengawasActionPerformed(evt);
            }
        });

        jLabel17.setText("Hari");
        jLabel17.setMaximumSize(new java.awt.Dimension(34, 14));
        jLabel17.setMinimumSize(new java.awt.Dimension(34, 14));
        jLabel17.setPreferredSize(new java.awt.Dimension(34, 14));

        jLabel23.setText("Reminder H-");

        jLabel24.setText("Hari");
        jLabel24.setMaximumSize(new java.awt.Dimension(34, 14));
        jLabel24.setMinimumSize(new java.awt.Dimension(34, 14));
        jLabel24.setPreferredSize(new java.awt.Dimension(34, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(94, 94, 94)
                .addComponent(textTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(142, 142, 142)
                .addComponent(cboSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(163, 163, 163)
                .addComponent(cboUjian, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addGap(280, 280, 280)
                .addComponent(jLabel20))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addGap(33, 33, 33)
                .addComponent(datePelaksanaanStart, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(datePelaksanaanEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addGap(10, 10, 10)
                .addComponent(spinnerJam, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(4, 4, 4)
                .addComponent(spinnerMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator3)
            .addComponent(jSeparator6)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(btnCreateEvent))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(33, 33, 33)
                        .addComponent(dateUploadSoalStart, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(dateUploadSoalEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delayUploadsoal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14)))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delayPengawas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15)))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(dateUploadNilaiEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delayUploadNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23)))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateVnvStart, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(dateVnvEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(textTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(cboSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(cboUjian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePelaksanaanStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePelaksanaanEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerMenit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateUploadSoalStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateUploadSoalEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delayUploadsoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel11)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateVnvStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateVnvEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel15)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delayPengawas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateUploadNilaiEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnCreateEvent))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delayUploadNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEventActionPerformed
        Event event = new Event();       
        
        String string;
        char semester;
        char ujian;
        if (cboSemester.getSelectedIndex() == 0) {
            semester = '1';
        } else {
            semester = '0';
        }
        if (cboUjian.getSelectedIndex() == 0) {
            ujian = 'T';
        } else {
            ujian = 'A';
        }
        System.out.println(textTahun.getText().substring(2));
        event.setKode(textTahun.getText().substring(2) + semester + ujian);
        event.setTanggalMulai(datePelaksanaanStart.getDate());
        event.setTanggalSelesai(datePelaksanaanEnd.getDate());
        event.setUploadMulai(dateUploadSoalStart.getDate());
        event.setUploadSelesai(dateUploadSoalEnd.getDate());
        event.setVnvMulai(dateVnvStart.getDate());
        event.setVnvSelesai(dateVnvEnd.getDate());
        event.setUploadNilaiSelesai(dateUploadNilaiEnd.getDate());  
        
        string = delayUploadsoal.getText();
        event.setDelayUploadSoal(Integer.parseInt(string));
        //event.setDelayUploadSoal(delayUploadsoal.getText());
        System.out.println(Integer.parseInt(string));
                
        string = delayPengawas.getText();
        event.setDelayPengawas(Integer.parseInt(string));
        //event.setDelayPengawas(delayPengawas.getText());
        System.out.println(Integer.parseInt(string));           
        
        string = delayUploadNilai.getText();
        event.setDelayUploadNilai(Integer.parseInt(string));        
        //event.setDelayUploadNilai(delayUploadNilai.getText());
        System.out.println(Integer.parseInt(string));
        
        event.setTimeReminder(Integer.parseInt(spinnerJam.getValue().toString()));
        
        System.out.println(event.getKode());
        
        EventController createEventController = new EventController();
        if(createEventController.createEvent(event)){
            JOptionPane.showMessageDialog(this, "Event berhasil dibuat", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Gagal membuat event", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateEventActionPerformed

    private void delayUploadNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delayUploadNilaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delayUploadNilaiActionPerformed

    private void delayUploadsoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delayUploadsoalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delayUploadsoalActionPerformed

    private void delayPengawasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delayPengawasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delayPengawasActionPerformed

    private void cboSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSemesterActionPerformed

    private void textTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTahunActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateEvent;
    private javax.swing.JComboBox cboSemester;
    private javax.swing.JComboBox cboUjian;
    private com.toedter.calendar.JDateChooser datePelaksanaanEnd;
    private com.toedter.calendar.JDateChooser datePelaksanaanStart;
    private com.toedter.calendar.JDateChooser dateUploadNilaiEnd;
    private com.toedter.calendar.JDateChooser dateUploadSoalEnd;
    private com.toedter.calendar.JDateChooser dateUploadSoalStart;
    private com.toedter.calendar.JDateChooser dateVnvEnd;
    private com.toedter.calendar.JDateChooser dateVnvStart;
    private javax.swing.JTextField delayPengawas;
    private javax.swing.JTextField delayUploadNilai;
    private javax.swing.JTextField delayUploadsoal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSpinner spinnerJam;
    private javax.swing.JSpinner spinnerMenit;
    private javax.swing.JTextField textTahun;
    // End of variables declaration//GEN-END:variables
}
