/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.controller.AbstractController;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.StorageSoal;
import com.jtk.pengelolaanujian.entity.User;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.StafFacade;
import com.jtk.pengelolaanujian.facade.StorageSoalFacade;
import com.jtk.pengelolaanujian.facade.UserFacade;
import com.zlib.io.ZIo;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author pahlevi
 */
public class PrintSoalController extends AbstractController {

    public void viewTableListPrintSoal(JTable tableViewListPrintSoal) {
        List<Soal> soalList = null;
        SoalFacade soalFacade = new SoalFacade();

        soalList = soalFacade.findAllWhereVNVtrue();

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

    public List<StorageSoal> searchSoalStorage(String kodeSoal, JTable jTable) {
        StorageSoalFacade storageSoalFacade = new StorageSoalFacade();
        StafFacade stafFacade = new StafFacade();
        List<StorageSoal> storageSoals = storageSoalFacade.findByKodeSoal(kodeSoal);
        Object[] columnsName = {"Nama File", "Tanggal Upload", "Uploader"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        for (StorageSoal soal : storageSoals) {
            Object[] o = new Object[4];
            o[0] = soal.getNamaFile();
            o[1] = sdf.format(soal.getStsoalTglUpload());
            o[2] = stafFacade.findByStafNip(soal.getStafNip()).getStafNama();

            dtm.addRow(o);
        }
        jTable.setModel(dtm);

        return storageSoals;
    }

    public void downloadSoal(String kodeSoal, int noUrut) {
        try {
            StorageSoalFacade storageSoalFacade = new StorageSoalFacade();
            StorageSoal storageSoal = storageSoalFacade.findByKodeSoalNoUrut(kodeSoal, noUrut);
            byte[] bytes = IOUtils.toByteArray(storageSoal.getStsoalFile());
            ZIo.saveAsFile(bytes, storageSoal.getTipeFile(), storageSoal.getNamaFile());
        } catch (IOException ex) {
            Logger.getLogger(PrintSoalController.class.getName()).log(Level.SEVERE, null, ex);
            addErrorMessage(ex.getMessage(), "Error");
        }
    }

}
