/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.dashboard;

import com.jtk.pengelolaanujian.view.MainFrame;

/**
 *
 * @author pahlevi
 */
public class DashboardPanelHeadinfo extends javax.swing.JPanel {

    MainFrame mainFrame = null;
            
    /**
     * Creates new form DashboardPanel2
     */
    public DashboardPanelHeadinfo(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
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

        piePanelVnv1 = new com.jtk.pengelolaanujian.view.dashboard.PiePanelVnv();
        piePanelNilai = new com.jtk.pengelolaanujian.view.dashboard.PiePanelNilai();
        piePanelVnv = new com.jtk.pengelolaanujian.view.dashboard.PiePanelVnv();
        piePanelSoal = new com.jtk.pengelolaanujian.view.dashboard.PiePanelSoal();
        labelDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        labelDate.setText("Date :");

        jLabel1.setText("Time :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(labelDate)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(piePanelSoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(piePanelVnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(piePanelNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(piePanelSoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(piePanelVnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(piePanelNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(217, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelDate;
    private com.jtk.pengelolaanujian.view.dashboard.PiePanelNilai piePanelNilai;
    private com.jtk.pengelolaanujian.view.dashboard.PiePanelSoal piePanelSoal;
    private com.jtk.pengelolaanujian.view.dashboard.PiePanelVnv piePanelVnv;
    private com.jtk.pengelolaanujian.view.dashboard.PiePanelVnv piePanelVnv1;
    // End of variables declaration//GEN-END:variables
    
    public void preparation() {

    }
}
