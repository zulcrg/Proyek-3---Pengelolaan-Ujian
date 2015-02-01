/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.entity;

import com.jtk.pengelolaanujian.facade.RuanganUjianFacade;
import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Rizki
 */
public class Nilai {

    private String ujianKode;
    private InputStream nilaiFile;
    private RuanganUjian ruanganUjian;
    private String namaFile;
    private String tipeFile;
    private String kelasKode;
    private Date nilaiTanggal;

    public Date getNilaiTanggal() {
        return nilaiTanggal;
    }

    public void setNilaiTanggal(Date nilaiTanggal) {
        this.nilaiTanggal = nilaiTanggal;
    }
    
    public Nilai() {
    }
    
    public Nilai(String ujianKode, InputStream nilaiFile) {
        this.ujianKode = ujianKode;
        this.nilaiFile = nilaiFile;
    }
    
    public String getUjianKode() {
        return ujianKode;
    }
    
    public void setUjianKode(String ujianKode) {
        this.ujianKode = ujianKode;
    }
    
    public InputStream getNilaiFile() {
        return nilaiFile;
    }
    
    public void setNilaiFile(InputStream nilaiFile) {
        this.nilaiFile = nilaiFile;
    }
    
    public RuanganUjian getRuanganUjian() {
        RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
        ruanganUjian = ruanganUjianFacade.findByUjianKodeKelasKode(ujianKode, kelasKode);
        return ruanganUjian;
    }
    
    public void setRuanganUjian(RuanganUjian ruanganUjian) {
        this.ruanganUjian = ruanganUjian;
    }

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }

    public String getTipeFile() {
        return tipeFile;
    }

    public void setTipeFile(String tipeFile) {
        this.tipeFile = tipeFile;
    }

    public String getKelasKode() {
        return kelasKode;
    }

    public void setKelasKode(String kelasKode) {
        this.kelasKode = kelasKode;
    }
    
}
