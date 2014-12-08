/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.controller;

import com.jtk.pengelolaanujianserver.entity.Dosen;
import com.jtk.pengelolaanujianserver.entity.Event;
import com.jtk.pengelolaanujianserver.entity.MataKuliah;
import com.jtk.pengelolaanujianserver.entity.MataKuliahToDosen;
import com.jtk.pengelolaanujianserver.entity.Soal;
import com.jtk.pengelolaanujianserver.entity.Staf;
import com.jtk.pengelolaanujianserver.facade.DosenFacade;
import com.jtk.pengelolaanujianserver.facade.EventFacade;
import com.jtk.pengelolaanujianserver.facade.GammuFacade;
import com.jtk.pengelolaanujianserver.facade.MataKuliahFacade;
import com.jtk.pengelolaanujianserver.facade.MataKuliahToDosenFacade;
import com.jtk.pengelolaanujianserver.facade.SoalFacade;
import com.jtk.pengelolaanujianserver.facade.StafFacade;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pahlevi
 */
public class Remainder2DayMonitController {

    private final Date date;
    private Event event;

    private final GammuFacade gammuFacade = new GammuFacade();
    private final SoalFacade soalFacade = new SoalFacade();
    private final MataKuliahFacade mataKuliahFacade = new MataKuliahFacade();
    private final DosenFacade dosenFacade = new DosenFacade();
    private final MataKuliahToDosenFacade mataKuliahToDosenFacade = new MataKuliahToDosenFacade();
    private final StafFacade stafFacade = new StafFacade();
    private final EventFacade eventFacade = new EventFacade();

    private List<Staf> listStaf;
    private List<Soal> listSoal;
    private List<MataKuliah> listMataKuliah;
    private List<Dosen> listDosen;
    private List<MataKuliahToDosen> listMataKuliahToDosens;

    public Remainder2DayMonitController(Date date) {
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
