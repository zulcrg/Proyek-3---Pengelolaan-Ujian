/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujianserver.controller;

import com.jtk.pengelolaanujian.entity.Dosen;
import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.entity.MataKuliah;
import com.jtk.pengelolaanujian.entity.MataKuliahToDosen;
import com.jtk.pengelolaanujian.entity.RuanganUjian;
import com.jtk.pengelolaanujian.entity.Soal;
import com.jtk.pengelolaanujian.entity.Staf;
import com.jtk.pengelolaanujian.entity.Ujian;
import com.jtk.pengelolaanujian.facade.DosenFacade;
import com.jtk.pengelolaanujian.facade.EventFacade;
import com.jtk.pengelolaanujian.facade.GammuFacade;
import com.jtk.pengelolaanujian.facade.MataKuliahFacade;
import com.jtk.pengelolaanujian.facade.MataKuliahToDosenFacade;
import com.jtk.pengelolaanujian.facade.RuanganUjianFacade;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import com.jtk.pengelolaanujian.facade.StafFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
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
