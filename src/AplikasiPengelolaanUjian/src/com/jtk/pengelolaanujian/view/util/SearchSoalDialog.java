/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.view.util;

/**
 *
 * @author Rizki
 */
public class SearchSoalDialog extends javax.swing.JPanel {

    /**
     * Creates new form SearchSoalDialog
     */
    public SearchSoalDialog() {
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

        textSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tSoal = new javax.swing.JTable();
        btnSelect = new javax.swing.JButton();

        textSearch.setForeground(new java.awt.Color(153, 153, 153));
        textSearch.setText("Cari berdasarkan Kode Soal atau Mata Kuliah");
        textSearch.setToolTipText("Cari berdasakan Kode Soal atau Mata Kuliah");
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

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tSoal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Soal", "Mata Kuliah", "Mata Kuliah Tipe"
            }
        ));
        tSoal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tSoalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tSoal);

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
    }// </editor-fold>//GEN-END:initComponents

    private void textSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textSearchFocusGained
//        if (first) {
//            textSearch.setForeground(Color.black);
//            textSearch.setText("");
//            first = false;
//        }
    }//GEN-LAST:event_textSearchFocusGained

    private void textSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textSearchFocusLost
//        if (textSearch.getText().isEmpty()) {
//            textSearch.setForeground(Color.getHSBColor(153, 153, 153));
//            switchText();
//            first = true;
//        }
    }//GEN-LAST:event_textSearchFocusLost

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
//        switch (enumPanel) {
//            case REGISTER_USER:
//            registrasiUserController.searchUser(textSearch.getText(), tSoal);
//            break;
//            case ASSIGN_ROLE:
//            stafList = assignRoleController.searchUser(textSearch.getText(), tSoal);
//            break;
//            case EDIT_USER:
//            stafList = editUserController.searchUserNotMe(textSearch.getText(), tSoal);
//            break;
//            case SEARCH_SOAL:
//            mataKuliahList = createUjianController.searchMataKuliah(textSearch.getText(), tSoal);
//            break;
//        }
    }//GEN-LAST:event_textSearchKeyReleased

    private void tSoalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tSoalMouseClicked
//        if (evt.getClickCount() == 2) {
//            select();
//        }
    }//GEN-LAST:event_tSoalMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
//        select();
    }//GEN-LAST:event_btnSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tSoal;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}