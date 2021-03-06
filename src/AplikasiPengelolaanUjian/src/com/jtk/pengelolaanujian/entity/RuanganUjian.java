/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.entity;

import com.jtk.pengelolaanujian.facade.BeritaAcaraFacade;
import com.jtk.pengelolaanujian.facade.KelasFacade;
import com.jtk.pengelolaanujian.facade.RuanganFacade;
import com.jtk.pengelolaanujian.facade.StafFacade;
import com.jtk.pengelolaanujian.facade.UjianFacade;
import java.util.Date;

/**
 *
 * @author Rizki
 */
public class RuanganUjian {

    private String ruanganKode;
    private String ujianKode;
    private String stafNip;
    private String beritaKode;
    private Ruangan ruangan;
    private BeritaAcara beritaAcara;
    private Ujian ujian;
    private Kelas kelas;
    private String kelasKode;
    private Staf staf;

    public String getKelasKode() {
        return kelasKode;
    }

    public void setKelasKode(String kelasKode) {
        this.kelasKode = kelasKode;
    }

    public boolean isRuanganUjianUploadNilaiStatus() {
        return ruanganUjianUploadNilaiStatus;
    }

    public void setRuanganUjianUploadNilaiStatus(boolean ruanganUjianUploadNilaiStatus) {
        this.ruanganUjianUploadNilaiStatus = ruanganUjianUploadNilaiStatus;
    }
    private boolean ruanganUjianUploadNilaiStatus;

    public RuanganUjian() {
    }

    public RuanganUjian(String ruanganKode, String ujianKOde, String stafNip, String beritaKode) {
        this.ruanganKode = ruanganKode;
        this.ujianKode = ujianKOde;
        this.stafNip = stafNip;
        this.beritaKode = beritaKode;
    }

    public String getRuanganKode() {
        return ruanganKode;
    }

    public Kelas getKelasQuery() {
        KelasFacade kelasFacade = new KelasFacade();
        kelas = kelasFacade.findByKelasKode(kelasKode);
        return kelas;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public void setRuanganKode(String ruanganKode) {
        this.ruanganKode = ruanganKode;
    }

    public String getUjianKode() {
        return ujianKode;
    }

    public void setUjianKode(String ujianKode) {
        this.ujianKode = ujianKode;
    }

    public String getStafNip() {
        return stafNip;
    }

    public void setStafNip(String stafNip) {
        this.stafNip = stafNip;
    }

    public String getBeritaKode() {
        return beritaKode;
    }

    public void setBeritaKode(String beritaKode) {
        this.beritaKode = beritaKode;
    }

    public Ruangan getRuanganQuery() {
        RuanganFacade ruanganFacade = new RuanganFacade();
        ruangan = ruanganFacade.findByKodeRuangan(ruanganKode);
        return ruangan;
    }

    public Ruangan getRuangan() {
        return ruangan;
    }

    public void setRuangan(Ruangan ruangan) {
        this.ruangan = ruangan;
    }

    public BeritaAcara getBeritaAcara() {
        BeritaAcaraFacade beritaAcaraFacade = new BeritaAcaraFacade();
        beritaAcara = beritaAcaraFacade.findByBeritaKode(beritaKode);
        return beritaAcara;
    }

    public void setBeritaAcara(BeritaAcara beritaAcara) {
        this.beritaAcara = beritaAcara;
    }

    public Ujian getUjianQuery() {
        UjianFacade ujianFacade = new UjianFacade();
        ujian = ujianFacade.findByKodeUjian(ujianKode);
        return ujian;
    }

    public Ujian getUjian() {
        return ujian;
    }

    public void setUjian(Ujian ujian) {
        this.ujian = ujian;
    }

    public Staf getStafQuery() {
        StafFacade stafFacade = new StafFacade();
        staf = stafFacade.findByStafNip(stafNip);
        return staf;
    }

    public Staf getStaf() {
        return staf;
    }

    public void setStaf(Staf staf) {
        this.staf = staf;
    }

}
