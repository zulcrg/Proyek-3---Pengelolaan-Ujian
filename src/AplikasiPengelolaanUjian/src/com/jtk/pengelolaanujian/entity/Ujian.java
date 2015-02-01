/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.entity;

import com.jtk.pengelolaanujian.facade.EventFacade;
import com.jtk.pengelolaanujian.facade.SoalFacade;
import java.util.Date;

/**
 *
 * @author Rizki
 */
public class Ujian {

    private String ujianKode;
    private String eventKode;
    private String soalKode;
    private Date ujianMulai;
    private int ujianMenit;
    private Event event;
    private Soal soal;
    private String ujianNama;
    private RuanganUjian ruanganUjian;

    public RuanganUjian getRuanganUjian() {
        return ruanganUjian;
    }

    public void setRuanganUjian(RuanganUjian ruanganUjian) {
        this.ruanganUjian = ruanganUjian;
    }

    public String getUjianNama() {
        return ujianNama;
    }

    public void setUjianNama(String ujianNama) {
        this.ujianNama = ujianNama;
    }

    public Ujian() {

    }

    public Ujian(String ujianKode, String eventKode, String soalKode, Date ujianMulai, int ujianMenit) {
        this.ujianKode = ujianKode;
        this.eventKode = eventKode;
        this.soalKode = soalKode;
        this.ujianMulai = ujianMulai;
        this.ujianMenit = ujianMenit;
    }

    public String getUjianKode() {
        return ujianKode;
    }

    public void setUjianKode(String ujianKode) {
        this.ujianKode = ujianKode;
    }

    public String getEventKode() {
        return eventKode;
    }

    public void setEventKode(String eventKode) {
        this.eventKode = eventKode;
    }

    public String getSoalKode() {
        return soalKode;
    }

    public void setSoalKode(String soalKode) {
        this.soalKode = soalKode;
    }

    public Date getUjianMulai() {
        return ujianMulai;
    }

    public void setUjianMulai(Date ujianMulai) {
        this.ujianMulai = ujianMulai;
    }

    public int getUjianMenit() {
        return ujianMenit;
    }

    public void setUjianMenit(int ujianMenit) {
        this.ujianMenit = ujianMenit;
    }

    public Event getEventQuery() {
        EventFacade eventControler = new EventFacade();
        event = eventControler.findByKodeUjian(ujianKode);
        return event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Soal getSoalQuery() {
        SoalFacade soalFacade = new SoalFacade();
        soal = soalFacade.findByKodeSoal(soalKode);
        return soal;
    }

    public Soal getSoal() {
        return soal;
    }

    public void setSoal(Soal soal) {
        this.soal = soal;
    }

}
