/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.controller.vnv;

import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.StafFacade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rizki
 */
public class BeritaAcaraVnvController {
    
    public void submitVnv(List<Dosen> dosen, Soal soal, String relevansi, String kesulitan, String bobotNilai, String bobotWaktu, String lain){
        SoalFacade soalFacade = new SoalFacade();
    }
    public List<Soal> searchSoal(String text, JTable tSoal){
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
            o[1] = soal.getMataKuliah().getMatkulNama();
            o[2] = soal.getMataKuliah().getMatkulTipe();

            dtm.addRow(o);
        }
        tSoal.setModel(dtm);
        return soalList;
    }
    
    public List<Staf> searchTimVnv(String text, JTable tStaf){
        List<Staf> stafList;
        StafFacade stafFacade = new StafFacade();
        stafList = stafFacade.findAll();

        Object[] columnsName = {"Nama", "NIP"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Staf staf : stafList) {
            Object[] o = new Object[2];
            o[0] = staf.getStafNIP();
            o[1] = staf.getStafNama();

            dtm.addRow(o);
        }
        tStaf.setModel(dtm);
        return stafList;
    }
    
}
