/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.controller.AbstractController;
import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.facade.MataKuliahFacade;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
import com.jtk.pengelolaanujian.util.CommonHelper;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class CreateUjianController extends AbstractController {

    public boolean createUjian(String kodeEvent, String namaUjian, String kodeSoal, MataKuliah mataKuliah, Date waktu) {
        SoalFacade soalFacade = new SoalFacade();
        UjianFacade facade = new UjianFacade();

        if (soalFacade.findByKodeSoal(kodeSoal) != null) {
            addWarnMessage("Soal dengan kode " + kodeSoal + " sudah ada", "Perhatian");
        } else if (facade.findByKodeUjian(kodeEvent + kodeSoal) != null) {
            addWarnMessage("Ujian dengan kode " + kodeEvent + kodeSoal + " sudah ada", "Perhatian");
        } else {
            Soal soal = new Soal();
            soal.setMatkulKode(mataKuliah.getMatkulKode());
            soal.setSoalKode(kodeSoal);
//            soal.setSoalSifat(sifatSoal);
            soal.setSoalUploaded(false);
            soal.setSoalVnved(false);
            soal.setSoalPrinted(false);
            soal.setMatkulTipe(mataKuliah.getMatkulTipe());

            Ujian ujian = new Ujian();
            ujian.setEventKode(kodeEvent);
            ujian.setUjianNama(namaUjian);
            ujian.setSoalKode(kodeSoal);
            ujian.setUjianKode(kodeEvent + kodeSoal);
//            ujian.setUjianMenit(durasi);
            ujian.setUjianMulai(waktu);

            try {
                ConnectionHelper.getConnection().setAutoCommit(false);
                soalFacade.createSoal(soal);
                facade.createUjian(ujian);
                addInfoMessage("Berhasil menambahkan data", "Informasi");
                ConnectionHelper.getConnection().commit();
                ConnectionHelper.getConnection().setAutoCommit(true);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(CreateUjianController.class.getName()).log(Level.SEVERE, null, ex);
                addErrorMessage(ex.getMessage(), "Error");
                try {
                    ConnectionHelper.getConnection().rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(CreateUjianController.class.getName()).log(Level.SEVERE, null, ex1);
                    addErrorMessage(ex1.getMessage(), "Error");
                }
            }
        }
        return false;
    }

    public List<MataKuliah> searchMataKuliah(String text, JTable table) {
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
            o[2] = CommonHelper.convertTipeMatkul(matkul.getMatkulTipe());

            dtm.addRow(o);
        }
        table.setModel(dtm);
        return matkuls;
    }
}
