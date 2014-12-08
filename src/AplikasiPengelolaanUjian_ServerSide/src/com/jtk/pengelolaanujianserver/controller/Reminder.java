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
import com.jtk.pengelolaanujianserver.entity.RuanganUjian;
import com.jtk.pengelolaanujianserver.entity.Soal;
import com.jtk.pengelolaanujianserver.entity.Staf;
import com.jtk.pengelolaanujianserver.entity.Ujian;
import com.jtk.pengelolaanujianserver.facade.DosenFacade;
import com.jtk.pengelolaanujianserver.facade.EventFacade;
import com.jtk.pengelolaanujianserver.facade.GammuFacade;
import com.jtk.pengelolaanujianserver.facade.MataKuliahFacade;
import com.jtk.pengelolaanujianserver.facade.MataKuliahToDosenFacade;
import com.jtk.pengelolaanujianserver.facade.RuanganUjianFacade;
import com.jtk.pengelolaanujianserver.facade.SoalFacade;
import com.jtk.pengelolaanujianserver.facade.StafFacade;
import com.jtk.pengelolaanujianserver.facade.UjianFacade;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pahlevi
 */
public class Reminder {
        
    Event event;

    final GammuFacade gammuFacade = new GammuFacade();
    final SoalFacade soalFacade = new SoalFacade();
    final MataKuliahFacade mataKuliahFacade = new MataKuliahFacade();
    final DosenFacade dosenFacade = new DosenFacade();
    final MataKuliahToDosenFacade mataKuliahToDosenFacade = new MataKuliahToDosenFacade();
    final StafFacade stafFacade = new StafFacade();
    final EventFacade eventFacade = new EventFacade();
    final UjianFacade ujianFacade = new UjianFacade();
    final RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
            
    List<Staf> listStaf;
    List<Soal> listSoal;
    List<MataKuliah> listMataKuliah;
    List<Dosen> listDosen;
    List<MataKuliahToDosen> listMataKuliahToDosens;
    List<Ujian> listUjian;
    List<RuanganUjian> listRuanganUjian;


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Staf> getListStaf() {
        return listStaf;
    }

    public void setListStaf(List<Staf> listStaf) {
        this.listStaf = listStaf;
    }

    public List<Soal> getListSoal() {
        return listSoal;
    }

    public void setListSoal(List<Soal> listSoal) {
        this.listSoal = listSoal;
    }

    public List<MataKuliah> getListMataKuliah() {
        return listMataKuliah;
    }

    public void setListMataKuliah(List<MataKuliah> listMataKuliah) {
        this.listMataKuliah = listMataKuliah;
    }

    public List<Dosen> getListDosen() {
        return listDosen;
    }

    public void setListDosen(List<Dosen> listDosen) {
        this.listDosen = listDosen;
    }

    public List<MataKuliahToDosen> getListMataKuliahToDosens() {
        return listMataKuliahToDosens;
    }

    public void setListMataKuliahToDosens(List<MataKuliahToDosen> listMataKuliahToDosens) {
        this.listMataKuliahToDosens = listMataKuliahToDosens;
    }

   
}
