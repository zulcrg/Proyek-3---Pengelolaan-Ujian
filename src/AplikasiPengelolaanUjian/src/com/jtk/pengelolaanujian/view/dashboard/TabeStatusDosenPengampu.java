/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.view.dashboard;

import com.jtk.pengelolaanujian.entity.Soal;

/**
 *
 * @author pahlevi
 */
public class TabeStatusDosenPengampu extends javax.swing.JPanel {

    /**
     * Creates new form TabeStatusAdmin
     */
    public TabeStatusDosenPengampu() {
        initComponents();
    }

     public void preparation() {
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelStatusDosenPengampu = new javax.swing.JTable();

        tabelStatusDosenPengampu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Mata Kuliah", "Jenis Matkul", "Soal Stat", "Nilai Stat", "Email", "No. Telp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelStatusDosenPengampu);
        if (tabelStatusDosenPengampu.getColumnModel().getColumnCount() > 0) {
            tabelStatusDosenPengampu.getColumnModel().getColumn(0).setResizable(false);
            tabelStatusDosenPengampu.getColumnModel().getColumn(1).setResizable(false);
            tabelStatusDosenPengampu.getColumnModel().getColumn(2).setResizable(false);
            tabelStatusDosenPengampu.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelStatusDosenPengampu.getColumnModel().getColumn(3).setResizable(false);
            tabelStatusDosenPengampu.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabelStatusDosenPengampu.getColumnModel().getColumn(4).setResizable(false);
            tabelStatusDosenPengampu.getColumnModel().getColumn(4).setPreferredWidth(50);
            tabelStatusDosenPengampu.getColumnModel().getColumn(5).setResizable(false);
            tabelStatusDosenPengampu.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelStatusDosenPengampu;
    // End of variables declaration//GEN-END:variables
}
