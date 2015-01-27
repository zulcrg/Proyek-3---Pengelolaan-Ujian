/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.admin;

import java.awt.Color;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class AdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
    }

    public void preparation() {
        registrasiUser1.preparation();
        assignRole1.preparation();
        editUser1.preparation();
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
        registrasiUser1 = new com.jtk.pengelolaanujian.view.admin.RegistrasiUser();
        assignRole1 = new com.jtk.pengelolaanujian.view.admin.AssignRole();
        editUser1 = new com.jtk.pengelolaanujian.view.admin.EditUser();

        setMinimumSize(new java.awt.Dimension(818, 625));
        setPreferredSize(new java.awt.Dimension(818, 625));

        jTabbedPane1.setBackground(new java.awt.Color(0, 153, 153));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(665, 217));
        jTabbedPane1.addTab("Registrasi User", registrasiUser1);
        jTabbedPane1.addTab("Assign Role", assignRole1);

        editUser1.setMinimumSize(new java.awt.Dimension(573, 212));
        editUser1.setPreferredSize(new java.awt.Dimension(701, 462));
        jTabbedPane1.addTab("Edit User", editUser1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jtk.pengelolaanujian.view.admin.AssignRole assignRole1;
    private com.jtk.pengelolaanujian.view.admin.EditUser editUser1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.jtk.pengelolaanujian.view.admin.RegistrasiUser registrasiUser1;
    // End of variables declaration//GEN-END:variables
}
