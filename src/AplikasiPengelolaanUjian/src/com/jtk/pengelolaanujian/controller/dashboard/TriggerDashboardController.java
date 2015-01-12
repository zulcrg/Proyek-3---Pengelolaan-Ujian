/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.dashboard;

import com.jtk.pengelolaanujian.controller.panitiaController.EventController;
import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.entity.Kbk;
import com.jtk.pengelolaanujian.entity.Nilai;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.StorageSoal;
import com.jtk.pengelolaanujian.entity.User;
import com.jtk.pengelolaanujian.entity.Vnv;
import com.jtk.pengelolaanujian.facade.DashboardFacade;
import com.jtk.pengelolaanujian.facade.DosenFacade;
import com.jtk.pengelolaanujian.facade.EventFacade;
import com.jtk.pengelolaanujian.facade.KbkFacade;
import com.jtk.pengelolaanujian.facade.NilaiFacade;
import com.jtk.pengelolaanujian.facade.RuanganUjianFacade;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.StafFacade;
import com.jtk.pengelolaanujian.facade.StorageSoalFacade;
import com.jtk.pengelolaanujian.facade.UserFacade;
import com.jtk.pengelolaanujian.facade.VnvFacade;
import com.jtk.pengelolaanujian.util.CommonHelper;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pahlevi
 */
public class TriggerDashboardController {

    public Event getListEvent() {
        EventFacade eventFacade = new EventFacade();
        return eventFacade.findTrue();
    }

    public void viewTableAdmin(JTable tabelStatusAdmin) {
        List<User> users;
        List<Staf> stafs;
        UserFacade userFacade = new UserFacade();
        StafFacade stafFacade = new StafFacade();
        users = userFacade.findByRoleKode("0");
        stafs = stafFacade.findAllWhereListedIn1(users);

        Object[] columnsName = {"Nama", "Email", "No. Telp"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Staf staf : stafs) {
            Object[] o = new Object[3];
            o[0] = staf.getStafNama();
            o[1] = staf.getStafEmail();
            o[2] = staf.getStafKontak();

            dtm.addRow(o);
        }
        tabelStatusAdmin.setModel(dtm);
    }

    public void viewTablePanitia(JTable tabelStatusPanitia) {
        List<User> users;
        List<Staf> stafs;
        UserFacade userFacade = new UserFacade();
        StafFacade stafFacade = new StafFacade();
        users = userFacade.findByRoleKode("3");
        stafs = stafFacade.findAllWhereListedIn1(users);
        Object[] columnsName = {"Nama", "Email", "No. Telp"};

        DefaultTableModel dtm = new DefaultTableModel(null, columnsName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Staf staf : stafs) {
            Object[] o = new Object[3];
            o[0] = staf.getStafNama();
            o[1] = staf.getStafEmail();
            o[2] = staf.getStafKontak();

            dtm.addRow(o);
        }
        tabelStatusPanitia.setModel(dtm);

    }

    public void viewTableVnv(JTable tabelStatusVNV) {
        DashboardFacade dashboardFacade = new DashboardFacade();
        dashboardFacade.findAlltableVnv(tabelStatusVNV);
    }

    public void viewTableDosenPengampu(JTable tabelStatusDosenPengampu) {
        DashboardFacade dashboardFacade = new DashboardFacade();
        dashboardFacade.findAlltableDosenPengampu(tabelStatusDosenPengampu);
    }

    public void viewTableUjian(JTable tabelUjian) {
        DashboardFacade dashboardFacade = new DashboardFacade();
        dashboardFacade.findAlltableUjian(tabelUjian);
        CommonHelper.resizeColumnWidth(tabelUjian);
    }

    public int checkUploadedSoal() {
        SoalFacade soalFacade = new SoalFacade();
        //System.out.println("data ="+soalFacade.checkUploadedSoalFacade());
        return soalFacade.checkUploadedSoalFacade();
    }

    public int checkUnUploadedSoal() {
        SoalFacade soalFacade = new SoalFacade();
        return soalFacade.checkUnUploadedSoalFacade();
    }

    public int checkUploadNilaidSoal() {
        SoalFacade soalFacade = new SoalFacade();
        return soalFacade.checkUploadNilai();
    }

    public int checkUnUploadNilaiSoal() {
        SoalFacade soalFacade = new SoalFacade();
        return soalFacade.checkUnUploadNilai();

    }

    public int checkUploadVNV() {
        SoalFacade soalFacade = new SoalFacade();
        return soalFacade.checkUploadVNV();
    }

    public int checkUnUploadedVNV() {
        SoalFacade soalFacade = new SoalFacade();
        return soalFacade.checkUnUploadVNV();
    }

    public int checkUjianTerlalui() {
        RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();                
        return ruanganUjianFacade.checkTerlalui(true);            
    }

    public int cekUjianBelumTerlalui() {
        RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();        
        return ruanganUjianFacade.checkTerlalui(false);
    }

    public void viewTableUjian(JTable tableUjian, String toString) {
        DashboardFacade dashboardFacade = new DashboardFacade();
        dashboardFacade.findTableUjianWherePengawasLike(tableUjian,toString);    
    }

    public void setJumlahStatus(JLabel LnilaiCountF, JLabel LnilaiCountT, JLabel LsoalCountF, JLabel LsoalCountT, JLabel LvnvCountF, JLabel LvnvCountT) {        
        EventController eventController = new EventController();
        Event event = null;
        event = eventController.getListEvent();
        
        StorageSoalFacade storageSoalFacade  = new StorageSoalFacade();        
        VnvFacade vnvFacade = new VnvFacade();
        NilaiFacade nilaiFacade = new NilaiFacade();
        
        LsoalCountT.setText(String.valueOf(storageSoalFacade.findSoalTepatWaktCount(event)));        
        LsoalCountF.setText(String.valueOf(storageSoalFacade.findSoalTerlambatCount(event)));
        LvnvCountT.setText(String.valueOf(vnvFacade.findVnvTepatWaktuCount(event)));
        LvnvCountF.setText(String.valueOf(vnvFacade.findVnvTerlambatCount(event)));
        LnilaiCountT.setText(String.valueOf(nilaiFacade.findTepatWaktuCount(event)));
        LnilaiCountF.setText(String.valueOf(nilaiFacade.findTerlambatCount(event)));
        
    }

}
