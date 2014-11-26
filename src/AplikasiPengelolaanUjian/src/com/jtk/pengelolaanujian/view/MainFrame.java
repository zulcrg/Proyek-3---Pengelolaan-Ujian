/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view;

import com.jtk.pengelolaanujian.util.EnumRole;
import com.jtk.pengelolaanujian.view.admin.AdminPanel;
import com.jtk.pengelolaanujian.view.dosenpengampu.DosenPengampuPanel;
import com.jtk.pengelolaanujian.view.panitia.PanitiaPanel;
import com.jtk.pengelolaanujian.view.vnv.VnvPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class MainFrame extends javax.swing.JFrame {

    private CardLayout cardLayout = new CardLayout();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Applikasi Pengelolaan Ujian - Development");
        cardPanel.setLayout(cardLayout);
        AdminPanel adminPanel = new AdminPanel();
        DosenPengampuPanel dosenPengampuPanel = new DosenPengampuPanel();
        PanitiaPanel panitiaPanel = new PanitiaPanel();
        VnvPanel vnvPanel = new VnvPanel();
        LoginPanel loginPanel = new LoginPanel(this);
        JPanel panel = new JPanel();
        cardPanel.add(loginPanel, "0");
        cardPanel.add(panel, "1");
        cardPanel.add(adminPanel, EnumRole.ADMIN.toString());
        cardPanel.add(dosenPengampuPanel, EnumRole.DOSEN_PENGAMPU.toString());
        cardPanel.add(panitiaPanel, EnumRole.PANITIA.toString());
        cardPanel.add(vnvPanel, EnumRole.VNV.toString());
        btnAdmin.setVisible(false);
        btnDosen.setVisible(false);
        btnPanitia.setVisible(false);
        btnVnv.setVisible(false);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JButton getBtnAdmin() {
        return btnAdmin;
    }

    public void setBtnAdmin(JButton btnAdmin) {
        this.btnAdmin = btnAdmin;
    }

    public JButton getBtnDosen() {
        return btnDosen;
    }

    public void setBtnDosen(JButton btnDosen) {
        this.btnDosen = btnDosen;
    }

    public JButton getBtnPanitia() {
        return btnPanitia;
    }

    public void setBtnPanitia(JButton btnPanitia) {
        this.btnPanitia = btnPanitia;
    }

    public JButton getBtnVnv() {
        return btnVnv;
    }

    public void setBtnVnv(JButton btnVnv) {
        this.btnVnv = btnVnv;
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public void setCardPanel(JPanel cardPanel) {
        this.cardPanel = cardPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdmin = new javax.swing.JButton();
        btnDosen = new javax.swing.JButton();
        btnVnv = new javax.swing.JButton();
        btnPanitia = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdmin.setText("Admin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnDosen.setText("Dosen Pengampu");
        btnDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosenActionPerformed(evt);
            }
        });

        btnVnv.setText("VnV");
        btnVnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVnvActionPerformed(evt);
            }
        });

        btnPanitia.setText("Panitia Ujian");
        btnPanitia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanitiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVnv, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanitia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAdmin)
                .addComponent(btnDosen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPanitia))
        );

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(cardPanel);
        cardPanel.setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        cardLayout.show(cardPanel, EnumRole.ADMIN.toString());        
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosenActionPerformed
        cardLayout.show(cardPanel, EnumRole.DOSEN_PENGAMPU.toString());
    }//GEN-LAST:event_btnDosenActionPerformed

    private void btnVnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVnvActionPerformed
        cardLayout.show(cardPanel, EnumRole.VNV.toString());
    }//GEN-LAST:event_btnVnvActionPerformed

    private void btnPanitiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanitiaActionPerformed
        cardLayout.show(cardPanel, EnumRole.PANITIA.toString());
    }//GEN-LAST:event_btnPanitiaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnDosen;
    private javax.swing.JButton btnPanitia;
    private javax.swing.JButton btnVnv;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}