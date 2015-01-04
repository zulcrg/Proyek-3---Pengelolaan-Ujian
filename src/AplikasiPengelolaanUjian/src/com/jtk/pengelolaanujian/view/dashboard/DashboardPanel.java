/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.dashboard;

import com.jtk.pengelolaanujian.view.MainFrame;
import java.awt.Color;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class DashboardPanel extends javax.swing.JPanel {

    MainFrame mainFrame;

    /**
     * Creates new form DashboardPanel
     * @param mainFrame
     */
    public DashboardPanel(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
    }
    
    public void preparation(){
        statusUser1.preparation();
        statusEvent1.preparation();
        statusTransaksi1.preparation();
        statusAplikasi1.preparation();  
        this.setBackground(Color.darkGray);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        statusEvent1 = new com.jtk.pengelolaanujian.view.dashboard.StatusEvent();
        statusUser1 = new com.jtk.pengelolaanujian.view.dashboard.StatusUser();
        statusAplikasi1 = new com.jtk.pengelolaanujian.view.dashboard.StatusAplikasi();
        statusTransaksi1 = new com.jtk.pengelolaanujian.view.dashboard.StatusTransaksi();

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane1.addTab("Status Event", statusEvent1);
        jTabbedPane1.addTab("Status User", statusUser1);
        jTabbedPane1.addTab("Status Aplikasi", statusAplikasi1);
        jTabbedPane1.addTab("Status Transaksi", statusTransaksi1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.jtk.pengelolaanujian.view.dashboard.StatusAplikasi statusAplikasi1;
    private com.jtk.pengelolaanujian.view.dashboard.StatusEvent statusEvent1;
    private com.jtk.pengelolaanujian.view.dashboard.StatusTransaksi statusTransaksi1;
    private com.jtk.pengelolaanujian.view.dashboard.StatusUser statusUser1;
    // End of variables declaration//GEN-END:variables
}
