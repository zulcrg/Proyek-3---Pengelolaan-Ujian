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
public class PanitiaPanel extends javax.swing.JPanel {

    /**
     * Creates new form PanitiaPanel
     */
    public PanitiaPanel() {
        initComponents();
    }
    
    public void preparation(){
        createEvent1.preparation();
        createUjian2.preparation();
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
        createEvent1 = new com.jtk.pengelolaanujian.view.panitia.CreateEvent();
        createUjian2 = new com.jtk.pengelolaanujian.view.panitia.CreateUjian();
        assignUjian1 = new com.jtk.pengelolaanujian.view.panitia.AssignUjian();

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane1.addTab("Create Event", createEvent1);
        jTabbedPane1.addTab("Create Ujian", createUjian2);
        jTabbedPane1.addTab("Assign Ujian", assignUjian1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jtk.pengelolaanujian.view.panitia.AssignUjian assignUjian1;
    private com.jtk.pengelolaanujian.view.panitia.CreateEvent createEvent1;
    private com.jtk.pengelolaanujian.view.panitia.CreateUjian createUjian2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
