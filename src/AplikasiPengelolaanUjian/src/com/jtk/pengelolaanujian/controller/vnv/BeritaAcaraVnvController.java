/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.controller.vnv;

import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rizki
 */
public class BeritaAcaraVnvController {
    public void searchSoal(String text, JTable tSoal){
        List<Soal> soalList;
        
        SoalFacade soalFacade = new SoalFacade();
        soalList = soalFacade.searchSoalInKbk(text);

        Object[] columnsName = {"Kode Soal", "Mata Kuliah", "Mata Kuliah Tipe"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Soal soal : soalList) {
            Object[] o = new Object[3];
            o[0] = soal.getSoalKode();
            o[1] = soal.getMataKuliah();
            o[2] = soal.getMatkulTipe();
            

            dtm.addRow(o);
        }
        tSoal.setModel(dtm);
    }
}
