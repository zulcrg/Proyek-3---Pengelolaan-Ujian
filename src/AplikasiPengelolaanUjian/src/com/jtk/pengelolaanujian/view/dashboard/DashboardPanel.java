/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.view.dashboard;

/**
 *
 * @author pahlevi
 */
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class DashboardPanel extends javax.swing.JFrame {

    /**
     * Creates new form DashboardPanel
     */
    private JPanel panel;
    private final ChartPanel1 piechart;
    private final ChartPanel2 barchart;
    
    public DashboardPanel() {
        setTitle("GRAFIK DENGAN JFREECHART");
        piechart = new ChartPanel1();
        barchart = new ChartPanel2();
        setLayout(new BorderLayout());
        getContentPane().add(piechart,BorderLayout.CENTER);
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

        chartPanel11 = new com.jtk.pengelolaanujian.view.dashboard.ChartPanel1();
        chartPanel21 = new com.jtk.pengelolaanujian.view.dashboard.ChartPanel2();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(chartPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(chartPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chartPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chartPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jtk.pengelolaanujian.view.dashboard.ChartPanel1 chartPanel11;
    private com.jtk.pengelolaanujian.view.dashboard.ChartPanel2 chartPanel21;
    // End of variables declaration//GEN-END:variables
}
