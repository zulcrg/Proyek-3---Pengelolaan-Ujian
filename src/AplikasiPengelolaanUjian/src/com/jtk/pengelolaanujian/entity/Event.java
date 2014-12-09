/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.entity;

import com.jtk.pengelolaanujian.facade.UjianFacade;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rizki
 */
public class Event {
    private String kode;
    private Date tanggalMulai;
    private Date tanggalSelesai;
    private Date uploadMulai;
    private Date uploadSelesai;
    private Date vnvMulai;
    private Date vnvSelesai;
    private List<Ujian> ujian;

    public Event() {
    }

    public Event(String kode, Date tanggalMulai, Date tanggalSelesai, Date uploadMulai, Date uploadSelesai, Date vnvMulai, Date vnvSelesai) {
        this.kode = kode;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.uploadMulai = uploadMulai;
        this.uploadSelesai = uploadSelesai;
        this.vnvMulai = vnvMulai;
        this.vnvSelesai = vnvSelesai;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public Date getUploadMulai() {
        return uploadMulai;
    }

    public void setUploadMulai(Date uploadMulai) {
        this.uploadMulai = uploadMulai;
    }

    public Date getUploadSelesai() {
        return uploadSelesai;
    }

    public void setUploadSelesai(Date uploadSelesai) {
        this.uploadSelesai = uploadSelesai;
    }

    public Date getVnvMulai() {
        return vnvMulai;
    }

    public void setVnvMulai(Date vnvMulai) {
        this.vnvMulai = vnvMulai;
    }

    public Date getVnvSelesai() {
        return vnvSelesai;
    }

    public void setVnvSelesai(Date vnvSelesai) {
        this.vnvSelesai = vnvSelesai;
    }

    public List<Ujian> getUjian() {
        UjianFacade ujianControler = new UjianFacade();
        ujian = ujianControler.findByKodeEvent(kode);
        return ujian;
    }

    public void setUjian(List<Ujian> ujian) {
        this.ujian = ujian;
    }
    
}
