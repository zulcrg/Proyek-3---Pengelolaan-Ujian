/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.facade.MataKuliahFacade;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class CreateUjianController {

    public void createUjian(String kodeEvent, String namaUjian, String kodeSoal, MataKuliah mataKuliah, String sifatSoal, Date waktu, int durasi) {
        Soal soal = new Soal();
        soal.setMatkulKode(mataKuliah.getMatkulKode());
        soal.setSoalKode(kodeSoal);
        soal.setSoalSifat(sifatSoal);
        soal.setSoalUploaded(false);
        soal.setSoalVnved(false);
        soal.setSoalPrinted(false);
        soal.setMatkulTipe(mataKuliah.getMatkulTipe());

        SoalFacade soalFacade = new SoalFacade();
        soalFacade.createSoal(soal);

        Ujian ujian = new Ujian();
        ujian.setEventKode(kodeEvent);
        ujian.setUjianNama(namaUjian);
        ujian.setSoalKode(kodeSoal);
        ujian.setUjianKode(kodeEvent + kodeSoal);
        ujian.setUjianMenit(durasi);
        ujian.setUjianMulai(waktu);

        UjianFacade facade = new UjianFacade();
        facade.createUjian(ujian);
        JOptionPane.showMessageDialog(null, "Berhasil menambahkan data", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public List<MataKuliah> searchSoal(String text, JTable table) {
        MataKuliahFacade mataKuliahFacade = new MataKuliahFacade();
        List<MataKuliah> matkuls = mataKuliahFacade.findByLikeKodeMatkul(text);

        Object[] columnsName = {"Kode", "Nama", "Tipe"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (MataKuliah matkul : matkuls) {
            Object[] o = new Object[3];
            o[0] = matkul.getMatkulKode();
            o[1] = matkul.getMatkulNama();
            o[2] = matkul.getMatkulTipe();

            dtm.addRow(o);
        }
        table.setModel(dtm);
        return matkuls;
    }
}
