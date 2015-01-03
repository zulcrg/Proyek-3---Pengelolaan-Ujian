/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.view.util;

import com.jtk.pengelolaanujian.controller.admin.AssignRoleController;
import com.jtk.pengelolaanujian.controller.admin.EditUserController;
import com.jtk.pengelolaanujian.controller.admin.RegistrasiUserController;
import com.jtk.pengelolaanujian.controller.panitiaController.CreateUjianController;
import com.jtk.pengelolaanujian.entity.MataKuliah;
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
    private MataKuliah mataKuliah;
    private List<Staf> stafList;
    private List<MataKuliah> mataKuliahList;
    private RegistrasiUserController registrasiUserController;
    private AssignRoleController assignRoleController;
    private EditUserController editUserController;
    private CreateUjianController createUjianController;
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

    /**
     * Creates new form SearchStafDialog
     *
     * @param parent
     * @param modal
     * @param mataKuliah
     * @param enumPanel
     */
    public SearchDialog(Frame parent, boolean modal, MataKuliah mataKuliah, EnumPanel enumPanel) {
        super(parent, modal);
        initComponents();
        setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.mataKuliah = mataKuliah;
        this.enumPanel = enumPanel;
        switchPanel();
    }

    private void switchPanel() {
        switch (enumPanel) {
            case REGISTER_USER:
                registrasiUserController = new RegistrasiUserController();
                registrasiUserController.searchUser("", table);
                textSearch.setText("Cari berdasarkan NIP atau Nama");
                break;
            case ASSIGN_ROLE:
                assignRoleController = new AssignRoleController();
                stafList = assignRoleController.searchUser("", table);
                textSearch.setText("Cari berdasarkan Nama atau Username");
                break;
            case EDIT_USER:
                editUserController = new EditUserController();
                stafList = editUserController.searchUserNotMe("", table);
                textSearch.setText("Cari berdasarkan Nama atau Username");
                break;
            case SEARCH_SOAL:
                createUjianController = new CreateUjianController();
                mataKuliahList = createUjianController.searchMataKuliah("", table);
                textSearch.setText("Cari berdasarkan Kode atau Nama Mata kuliah");
                setTitle("Mata Kuliah");
                break;
        }
    }

    private void switchText() {
        switch (enumPanel) {
            case REGISTER_USER:
                textSearch.setText("Cari berdasarkan NIP atau Nama");
                break;
            case ASSIGN_ROLE:
                textSearch.setText("Cari berdasarkan Nama atau Username");
                break;
            case EDIT_USER:
                textSearch.setText("Cari berdasarkan Nama atau Username");
                break;
            case SEARCH_SOAL:
                textSearch.setText("Cari berdasarkan Kode atau Nama Mata kuliah");
                break;
        }
    }

    private void select() {
        switch (enumPanel) {
            case REGISTER_USER:
                staf.setStafNama(table.getValueAt(table.getSelectedRow(), 0).toString());
                staf.setStafNIP(table.getValueAt(table.getSelectedRow(), 1).toString());
                break;
            case ASSIGN_ROLE:
            case EDIT_USER:
                staf.setStafNama(stafList.get(table.getSelectedRow()).getStafNama());
                staf.setStafNIP(stafList.get(table.getSelectedRow()).getStafNIP());
                break;
            case SEARCH_SOAL:
                mataKuliah.setMatkulKode(mataKuliahList.get(table.getSelectedRow()).getMatkulKode());
                mataKuliah.setMatkulNama(mataKuliahList.get(table.getSelectedRow()).getMatkulNama());
                mataKuliah.setMatkulTipe(mataKuliahList.get(table.getSelectedRow()).getMatkulTipe());
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
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Staff");

        textSearch.setForeground(new java.awt.Color(153, 153, 153));
        textSearch.setText("Cari berdasarkan Nama atau NIP");
        textSearch.setToolTipText("Cari berdasakan Nama atau NIK");
        textSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textSearchFocusLost(evt);
            }
        });
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
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

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "NIK"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelect)
                        .addGap(0, 421, Short.MAX_VALUE))
                    .addComponent(textSearch))
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
                registrasiUserController.searchUser(textSearch.getText(), table);
                break;
            case ASSIGN_ROLE:
                stafList = assignRoleController.searchUser(textSearch.getText(), table);
                break;
            case EDIT_USER:
                stafList = editUserController.searchUserNotMe(textSearch.getText(), table);
                break;
            case SEARCH_SOAL:
                mataKuliahList = createUjianController.searchMataKuliah(textSearch.getText(), table);
                break;
        }
    }//GEN-LAST:event_textSearchKeyReleased

    private void textSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textSearchFocusGained
        if (first) {
            textSearch.setForeground(Color.black);
            textSearch.setText("");
            first = false;
        }
    }//GEN-LAST:event_textSearchFocusGained

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() == 2) {
            select();
        }
    }//GEN-LAST:event_tableMouseClicked

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

    private void textSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textSearchFocusLost
        if (textSearch.getText().isEmpty()) {
            textSearch.setForeground(Color.getHSBColor(153, 153, 153));
            switchText();
            first = true;
        }
    }//GEN-LAST:event_textSearchFocusLost

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
