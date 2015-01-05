/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view;

import com.jtk.pengelolaanujian.util.EnumRole;
import com.jtk.pengelolaanujian.view.admin.AdminPanel;
import com.jtk.pengelolaanujian.view.dashboard.DashboardPanel;
import com.jtk.pengelolaanujian.view.dashboard.StatusTransaksi;
import com.jtk.pengelolaanujian.view.dosenpengampu.DosenPengampuPanel;
import com.jtk.pengelolaanujian.view.panitia.PanitiaPanel;
import com.jtk.pengelolaanujian.view.util.AboutAppsDialog;
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
    private static boolean logedIn = false;
    private final AdminPanel adminPanel = new AdminPanel();
    private final DosenPengampuPanel dosenPengampuPanel = new DosenPengampuPanel();
    private final PanitiaPanel panitiaPanel = new PanitiaPanel();
    private final VnvPanel vnvPanel = new VnvPanel();
    private final LoginPanel loginPanel = new LoginPanel(this);
    private final WelcomePanel panel = new WelcomePanel(this);
    private final DashboardPanel dashboardPanel = new DashboardPanel(this);

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Applikasi Pengelolaan Ujian - Development");
        cardPanel.setLayout(cardLayout);
        cardPanel.add(loginPanel, "0");
        //cardPanel.add(dashboardPanel, "0");
        cardPanel.add(panel, "1");        
        cardPanel.add(adminPanel, EnumRole.ADMIN.toString());
        cardPanel.add(dosenPengampuPanel, EnumRole.DOSEN_PENGAMPU.toString());
        cardPanel.add(panitiaPanel, EnumRole.PANITIA.toString());
        cardPanel.add(vnvPanel, EnumRole.VNV.toString());
        cardPanel.add(dashboardPanel, EnumRole.DASHBOARD.toString());
        
        setMenuFalse();
        setMenuLogout();
    }

    public final void setMenuLogout() {
        if (isLogedIn()) {
            menuLogout.setVisible(true);
        } else {
            menuLogout.setVisible(false);
        }
    }

    public final void setMenuFalse() {
        btnAdmin.setVisible(false);
        btnDosen.setVisible(false);
        btnPanitia.setVisible(false);
        btnVnv.setVisible(false);
        menuPanel.setVisible(false);
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

    public static boolean isLogedIn() {
        return logedIn;
    }

    public static void setLogedIn(boolean logedIn) {
        MainFrame.logedIn = logedIn;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        menuPanel = new javax.swing.JPanel();
        btnAdmin = new javax.swing.JButton();
        btnDosen = new javax.swing.JButton();
        btnVnv = new javax.swing.JButton();
        btnPanitia = new javax.swing.JButton();
        btnDashBoard = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(818, 710));
        setPreferredSize(new java.awt.Dimension(818, 710));

        menuPanel.setBackground(new java.awt.Color(0, 102, 102));
        menuPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuPanel.setForeground(new java.awt.Color(102, 102, 102));

        btnAdmin.setBackground(new java.awt.Color(0, 102, 102));
        btnAdmin.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAdmin.setForeground(new java.awt.Color(240, 240, 240));
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jtk/pengelolaanujian/view/images/admin1.png"))); // NOI18N
        btnAdmin.setText("Admin");
        btnAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdmin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnDosen.setBackground(new java.awt.Color(0, 102, 102));
        btnDosen.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnDosen.setForeground(new java.awt.Color(240, 240, 240));
        btnDosen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jtk/pengelolaanujian/view/images/Teacher1.png"))); // NOI18N
        btnDosen.setText("Dosen Pengampu");
        btnDosen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDosen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosenActionPerformed(evt);
            }
        });

        btnVnv.setBackground(new java.awt.Color(0, 102, 102));
        btnVnv.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnVnv.setForeground(new java.awt.Color(240, 240, 240));
        btnVnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jtk/pengelolaanujian/view/images/vnv1.png"))); // NOI18N
        btnVnv.setText("VnV");
        btnVnv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVnv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVnvActionPerformed(evt);
            }
        });

        btnPanitia.setBackground(new java.awt.Color(0, 102, 102));
        btnPanitia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnPanitia.setForeground(new java.awt.Color(240, 240, 240));
        btnPanitia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jtk/pengelolaanujian/view/images/Crew1.png"))); // NOI18N
        btnPanitia.setText("Panitia Ujian");
        btnPanitia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPanitia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPanitia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanitiaActionPerformed(evt);
            }
        });

        btnDashBoard.setBackground(new java.awt.Color(0, 102, 102));
        btnDashBoard.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnDashBoard.setForeground(new java.awt.Color(240, 240, 240));
        btnDashBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jtk/pengelolaanujian/view/images/Dashboard1.png"))); // NOI18N
        btnDashBoard.setText("Dashboard");
        btnDashBoard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDashBoard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDashBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashBoardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVnv, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanitia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAdmin)
                .addComponent(btnDosen)
                .addComponent(btnVnv)
                .addComponent(btnPanitia)
                .addComponent(btnDashBoard))
        );

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(cardPanel);
        cardPanel.setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        menuLogout.setText("Log out");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuLogout);

        menuAbout.setText("About");
        menuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbout);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        cardLayout.show(cardPanel, EnumRole.ADMIN.toString());
        adminPanel.preparation();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosenActionPerformed
        cardLayout.show(cardPanel, EnumRole.DOSEN_PENGAMPU.toString());
        dosenPengampuPanel.preparation();
    }//GEN-LAST:event_btnDosenActionPerformed

    private void btnVnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVnvActionPerformed
        cardLayout.show(cardPanel, EnumRole.VNV.toString());
        vnvPanel.preparation();
    }//GEN-LAST:event_btnVnvActionPerformed

    private void btnPanitiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanitiaActionPerformed
        cardLayout.show(cardPanel, EnumRole.PANITIA.toString());
        panitiaPanel.preparation();
    }//GEN-LAST:event_btnPanitiaActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        cardLayout.show(cardPanel, "0");
        logedIn = false;
        setMenuLogout();
        menuPanel.setVisible(false);
        setMenuFalse();
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutActionPerformed
        AboutAppsDialog aboutAppsDialog = new AboutAppsDialog(this, true);
        aboutAppsDialog.show();
    }//GEN-LAST:event_menuAboutActionPerformed

    private void btnDashBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashBoardActionPerformed
        cardLayout.show(cardPanel, EnumRole.DASHBOARD.toString());
        dashboardPanel.preparation();
    }//GEN-LAST:event_btnDashBoardActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnDashBoard;
    private javax.swing.JButton btnDosen;
    private javax.swing.JButton btnPanitia;
    private javax.swing.JButton btnVnv;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}
