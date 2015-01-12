/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.vnv;

import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.Vnv;
import com.jtk.pengelolaanujian.facade.DosenFacade;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.StafFacade;
import com.jtk.pengelolaanujian.facade.VnvFacade;
import com.jtk.pengelolaanujian.util.CommonHelper;
import com.jtk.pengelolaanujian.view.LoginPanel;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rizki
 */
public class BeritaAcaraVnvController {

    public void submitVnv(List<Dosen> dosen, Soal soal, String relevansi, String kesulitan, String bobotNilai, String bobotWaktu, String lain, boolean lulus) {
        StafFacade stafFacade = new StafFacade();

        Vnv vnv = new Vnv();
        vnv.setSoalKode(soal.getSoalKode());
        vnv.setStafNip(stafFacade.findByUsername(LoginPanel.getUsername()).getStafNIP());
        vnv.setVnvKelayakanBobot(bobotNilai);
        vnv.setVnvKelayakanWaktu(bobotWaktu);
        vnv.setVnvKesulitan(kesulitan);
        vnv.setVnvKode(CommonHelper.createUUID());
        vnv.setVnvLain(lain);
        vnv.setVnvRelevansi(relevansi);
        vnv.setVnvStatus(lulus);
        vnv.setVnvTgl(new Date());

        VnvFacade vnvFacade = new VnvFacade();
        vnvFacade.submitVnv(dosen, vnv);
    }

    public List<Soal> searchSoal(String text, JTable tSoal) {
        SoalFacade soalFacade = new SoalFacade();
        List<Soal> soalList = soalFacade.searchSoalInKbk(text);

        Object[] columnsName = {"Kode Soal", "Mata Kuliah", "Mata Kuliah Tipe","Kelas"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Soal soal : soalList) {
            Object[] o = new Object[4];
            o[0] = soal.getSoalKode();
            o[1] = soal.getMataKuliah().getMatkulNama();
            o[2] = soal.getMataKuliah().getMatkulTipe();
            o[3] = soal.getUjian().getRuanganUjian().getKelas().getKelasNama();

            dtm.addRow(o);
        }
        tSoal.setModel(dtm);
        return soalList;
    }

    public List<Dosen> searchTimVnv(String text, JTable tStaf) {
        List<Dosen> dosenList;
        DosenFacade dosenFacade = new DosenFacade();
        dosenList = dosenFacade.findAllDosenNotMe();

        Object[] columnsName = {"NIP", "Nama", ""};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }

        };
        for (Staf staf : dosenList) {
            Object[] o = new Object[3];
            o[0] = staf.getStafNIP();
            o[1] = staf.getStafNama();
            o[2] = Boolean.FALSE;

            dtm.addRow(o);
        }
        tStaf.setModel(dtm);
        CommonHelper.resizeColumnWidth(tStaf);
        return dosenList;
    }

}
