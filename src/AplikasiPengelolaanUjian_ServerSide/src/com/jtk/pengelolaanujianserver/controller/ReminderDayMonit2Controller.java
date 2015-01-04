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
    private final Date date;
    
    public ReminderDayMonit2Controller(Date date) {
        this.date = date;
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

            gammuFacade.sendRemainderUploadSoalSMS(listStaf, smsString);
        }

    }
}
