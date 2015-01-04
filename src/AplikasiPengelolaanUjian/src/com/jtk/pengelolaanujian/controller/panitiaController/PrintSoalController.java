/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.User;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.StafFacade;
import com.jtk.pengelolaanujian.facade.UserFacade;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pahlevi
 */
public class PrintSoalController {

    public void viewTableListPrintSoal(JTable tableViewListPrintSoal) {        
        List<Soal> soalList = null;
        SoalFacade soalFacade = new SoalFacade();
        
        soalList=soalFacade.findAllWhereVNVtrue();        
        
        Object[] columnsName = {"Kode Soal", "Kode MatKul", "MatKul", "Dosen Pengampu"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Soal soal : soalList) {
            Object[] o = new Object[4];
            o[0] = soal.getSoalKode();
            o[1] = soal.getMataKuliah().getMatkulKode();
            o[2] = soal.getMataKuliah().getMatkulNama();
            o[3] = soal.getMataKuliah().getDosen().getStafNama();

            dtm.addRow(o);
        }
        tableViewListPrintSoal.setModel(dtm);

    }

}
