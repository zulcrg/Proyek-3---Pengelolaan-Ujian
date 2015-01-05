/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.controller;

import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.facade.RuanganUjianFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pahlevi reminder pemberitahuan dosen pengampu mgenenai H-X upload
 * nilai
 */
public class ReminderDayMonit8Controller extends Reminder {

    private Date date;

    public ReminderDayMonit8Controller() {
        this.date = new Date();
    }
    
    public void preparation(){
        checkRule();
    }

    public void checkRule(){
        event = eventFacade.findLast();
        List<RuanganUjian> listRuanganUjian = null;
        List<Ujian> listUjian = null;
        List<Soal> listSoal = null;
        
        RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
        UjianFacade ujianFace = new UjianFacade();        
        
        listUjian = ujianFacade.findByKodeEvent(event.getKode());
        String smsString = "Sekarang sudah H-" + event.getDelayUploadNilai() + " batas akhir Upload Nilai, Mohon segera Upload data Nilai Ujian Matkul anda. Terima Kasih";
        //System.out.println(listUjian.get(0).getUjianNama());
        
        if (date.getDate() + event.getDelayUploadNilai()== event.getUploadNilaiSelesai().getDate()) {
            listRuanganUjian=ruanganUjianFacade.findAllWhereNilaiUploaded(false);
            //System.out.println(listRuanganUjian.get(0).getRuanganKode());
            listUjian=ujianFace.findAllWhereListedIN(listRuanganUjian);
            listSoal=soalFacade.findAllWhereListedIN(listUjian);
            listMataKuliah = mataKuliahFacade.findAllWhereListedIn(listSoal);
            listMataKuliahToDosens = mataKuliahToDosenFacade.findAllWhereListedIn(listMataKuliah);
            listDosen = dosenFacade.findAllWhereListedIn(listMataKuliahToDosens);
            listStaf = stafFacade.findAllWhereListedIn(listDosen);
            
            gammuFacade.sendRemainderUploadNilaiSMS(listStaf, smsString);
        }
        
        
    }
}
