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
import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PiePanelSoal extends javax.swing.JPanel {

    /**
     * Creates new form PiePanelSoal
     */
  
    private JFreeChart piechart;
    private final ChartPanel panel;
    
    public PiePanelSoal(){
        panel = createChart(createData());
        panel.setPreferredSize(new Dimension(250, 250));
 
        setLayout(new BorderLayout());
        add(panel,BorderLayout.CENTER);        
    }
 
    private PieDataset createData() {
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Belum Di Upload",90);
        data.setValue("Sudah Di Upload", 10);               
        return data;
    }
 
    private ChartPanel createChart(PieDataset data) {
          piechart = ChartFactory.createPieChart("Soal Upload", data, true, true, false);
          PiePlot plot = (PiePlot) piechart.getPlot();  
          plot.setSectionPaint("Belum Di Print", new Color(135,206,250));
          plot.setSectionPaint("Sudah Di Print", new Color(205,133,63));        
          plot.setNoDataMessage("Data Tidak Ada");
          plot.setExplodePercent("data", 0.1D);
          plot.setLabelBackgroundPaint(new Color(255,228,225));
          plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({1})"));
          plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator());
        
        // Key = 0 ----> section as String (Windows, Linux, Lainnya)
        // Key = 1 ----> section as value (300,200,100)
        // KEy - 2 ----> section as percentage (50%,33%,17 %) Muncul jika aplikasi telah di running
        
        plot.setSimpleLabels(true);
        plot.setInteriorGap(0.0D);
        return new ChartPanel(piechart);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
