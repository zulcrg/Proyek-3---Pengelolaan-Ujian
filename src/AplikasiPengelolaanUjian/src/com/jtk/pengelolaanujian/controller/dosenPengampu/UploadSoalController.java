/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.dosenPengampu;

import com.jtk.pengelolaanujian.controller.AbstractController;
import com.jtk.pengelolaanujian.entity.StorageSoal;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.StorageSoalFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
import com.jtk.pengelolaanujian.facade.UserFacade;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import com.jtk.pengelolaanujian.view.LoginPanel;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author pahlevi
 */
public class UploadSoalController extends AbstractController {

    public List<Ujian> searchMatkul(JComboBox cbo) {
        UjianFacade ujianFacade = new UjianFacade();
        List<Ujian> ujians = ujianFacade.findByUsername();
        String ujian[] = new String[ujians.size()];
        for (int i = 0; i < ujians.size(); i++) {
            Ujian mk = ujians.get(i);
            ujian[i] = mk.getUjianNama();
        }
        cbo.setModel(new DefaultComboBoxModel(ujian));
        return ujians;
    }

    public boolean uploadSoal(InputStream file, String kodeUjian, String sifatUjian, int durasi, String tipeFile, String namaFile) {
        UjianFacade ujianFacade = new UjianFacade();
        UserFacade userFacade = new UserFacade();
        StorageSoalFacade storageSoalFacade = new StorageSoalFacade();
        SoalFacade soalFacade = new SoalFacade();

        Ujian ujian = ujianFacade.findByKodeUjian(kodeUjian);
        ujian.getSoalQuery().setSoalSifat(sifatUjian);
        ujian.getSoal().setSoalUploaded(true);
        ujian.setUjianMenit(durasi);
        StorageSoal storageSoal = new StorageSoal();
        storageSoal.setSoalKode(ujian.getSoalKode());
        storageSoal.setStafNip(userFacade.findByUsername(LoginPanel.getUsername()).getStafNIP());
        storageSoal.setStsoalFile(file);
        storageSoal.setStsoalNoUrut(storageSoalFacade.findNoUrut(ujian.getSoalKode()) + 1);
        storageSoal.setStsoalTglUpload(new Date());
        storageSoal.setTipeFile(tipeFile);
        storageSoal.setNamaFile(namaFile);

        Connection connection = ConnectionHelper.getConnection();
        try {
            connection.setAutoCommit(false);
            ujianFacade.updateUjianMenit(ujian);
            soalFacade.updateSoalSifatUploaded(ujian.getSoal());
            storageSoalFacade.createStorageSoal(storageSoal);
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UploadSoalController.class.getName()).log(Level.SEVERE, null, ex);
            addErrorMessage(ex.getMessage(), "ERROR");
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UploadSoalController.class.getName()).log(Level.SEVERE, null, ex1);
                addErrorMessage(ex1.getMessage(), "ERROR");
            }
        }
        return false;

    }

}
