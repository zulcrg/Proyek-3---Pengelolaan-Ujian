/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.view.panitia;

/**
 *
 * @author pahlevi
 */
public class AssignUjian extends javax.swing.JPanel {

    /**
     * Creates new form AssignUjian
     */
    public AssignUjian() {
        initComponents();
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

        labelUjian.setText("Ujian");

        btnBrowseUjian.setText("Browse");

        labelPengawas.setText("Pengawas");

        btwBrowsePengawas.setText("Browse");

        btnBrowseRuangan.setText("Browse");

        labelRuangan.setText("Ruangan");

        btnSimpan.setText("Simpan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSimpan)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUjian)
                            .addComponent(labelPengawas)
                            .addComponent(labelRuangan))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textPengawas)
                            .addComponent(textUjian)
                            .addComponent(textRuangan, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBrowseRuangan)
                            .addComponent(btnBrowseUjian)
                            .addComponent(btwBrowsePengawas))))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
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
                .addGap(55, 55, 55)
                .addComponent(btnSimpan)
                .addContainerGap(203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseRuangan;
    private javax.swing.JButton btnBrowseUjian;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btwBrowsePengawas;
    private javax.swing.JLabel labelPengawas;
    private javax.swing.JLabel labelRuangan;
    private javax.swing.JLabel labelUjian;
    private javax.swing.JTextField textPengawas;
    private javax.swing.JTextField textRuangan;
    private javax.swing.JTextField textUjian;
    // End of variables declaration//GEN-END:variables
}