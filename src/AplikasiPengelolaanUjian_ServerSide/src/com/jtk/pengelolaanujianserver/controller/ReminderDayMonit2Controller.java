/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.controller;

import java.util.Date;

/**
 *
 * @author pahlevi
 * reminder pengingat dosen pengampu untuk upload soal
 * 
 */
public class ReminderDayMonit2Controller extends Reminder{
    private Date date;
            
    public ReminderDayMonit2Controller() {
        
    }

    public void preparation() {
        this.date = new Date();
        checkRule();
    }
    
    
    public void checkRule() {
        event = eventFacade.findLast();
        if (date.getDate() + event.getDelayUploadSoal() == event.getUploadSelesai().getDate()) {
            String smsReciever = null;
            String smsString = "Sekarang sudah H-"+event.getDelayUploadSoal()+" batas akhir Upload Soal, Mohon segera Upload Soal Ujian Anda. Terima Kasih";

            listSoal = soalFacade.findAllWhereUploaded(false);
            listMataKuliah = mataKuliahFacade.findAllWhereListedIn(listSoal);
            listMataKuliahToDosens = mataKuliahToDosenFacade.findAllWhereListedIn(listMataKuliah);
            listDosen = dosenFacade.findAllWhereListedIn(listMataKuliahToDosens);
            listStaf = stafFacade.findAllWhereListedIn(listDosen);

            //System.out.println(listStaf.get(0).getStafNIP());
            gammuFacade.sendRemainderUploadSoalSMS(listStaf, smsString);
        }

    }
}
