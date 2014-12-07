/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.util;

import com.jtk.pengelolaanujian.controller.admin.AssignRoleController;
import com.jtk.pengelolaanujian.controller.admin.EditUserController;
import com.jtk.pengelolaanujian.controller.admin.RegistrasiUserController;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.util.EnumPanel;
import java.awt.Color;
import java.awt.Frame;
import java.util.List;

/**
 *
 * @author pahlevi
 */
public class SearchDialog extends javax.swing.JDialog {

    boolean first = true;
    private Staf staf;
    private List<Staf> stafList;
    private final RegistrasiUserController registrasiUserController = new RegistrasiUserController();
    private final AssignRoleController assignRoleController = new AssignRoleController();
    private final EditUserController editUserController = new EditUserController();
    private final EnumPanel enumPanel;

    /**
     * Creates new form SearchStafDialog
     *
     * @param parent
     * @param modal
     * @param staf
     * @param enumPanel
     */
    public SearchDialog(Frame parent, boolean modal, Staf staf, EnumPanel enumPanel) {
        super(parent, modal);
        initComponents();
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.staf = staf;
        this.enumPanel = enumPanel;
        switchPanel();
    }

    public final void switchPanel() {
        switch (enumPanel) {
            case REGISTER_USER:
                registrasiUserController.searchUser("", tableStaf);
                textSearch.setText("Cari berdasarkan NIP atau Nama");
                break;
            case ASSIGN_ROLE:
                stafList = assignRoleController.searchUser("", tableStaf);
                textSearch.setText("Cari berdasarkan Nama atau Username");
                break;
            case EDIT_USER:
                stafList = editUserController.searchUserNotMe("", tableStaf);
                textSearch.setText("Cari berdasarkan Nama atau Username");
                break;
        }
    }
    
    public void select(){
        switch (enumPanel) {
            case REGISTER_USER:
                staf.setStafNama(tableStaf.getValueAt(tableStaf.getSelectedRow(), 0).toString());
                staf.setStafNIP(tableStaf.getValueAt(tableStaf.getSelectedRow(), 1).toString());
                break;
            case ASSIGN_ROLE:
            case EDIT_USER:
                staf.setStafNama(stafList.get(tableStaf.getSelectedRow()).getStafNama());
                staf.setStafNIP(stafList.get(tableStaf.getSelectedRow()).getStafNIP());
                break;
        }
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textSearch = new javax.swing.JTextField();
        btnSelect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStaf = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Staff");

        textSearch.setForeground(new java.awt.Color(153, 153, 153));
        textSearch.setText("Cari berdasarkan Nama atau NIP");
        textSearch.setToolTipText("Cari berdasakan Nama atau NIK");
        textSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textSearchFocusGained(evt);
            }
        });
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
        });

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        tableStaf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "NIK"
            }
        ));
        tableStaf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStafMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableStaf);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelect))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelect)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        select();
    }//GEN-LAST:event_btnSelectActionPerformed

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        switch (enumPanel) {
            case REGISTER_USER:
                registrasiUserController.searchUser(textSearch.getText(), tableStaf);
                break;
            case ASSIGN_ROLE:
                stafList = assignRoleController.searchUser(textSearch.getText(), tableStaf);
                break;
            case EDIT_USER:
                stafList = editUserController.searchUserNotMe(textSearch.getText(), tableStaf);
                break;
        }
    }//GEN-LAST:event_textSearchKeyReleased

    private void textSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textSearchFocusGained
        if (first) {
            textSearch.setForeground(Color.black);
            textSearch.setText("");
        }
    }//GEN-LAST:event_textSearchFocusGained

    private void tableStafMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStafMouseClicked
        if (evt.getClickCount() == 2) {
            select();
        }
    }//GEN-LAST:event_tableStafMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStaf;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
