/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.entity;

import com.jtk.pengelolaanujian.facade.RuanganUjianFacade;
import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author Rizki
 */
public class Nilai {

    private String ruanganKode;
    private String ujianKode;
    private InputStream nilaiFile;
    private RuanganUjian ruanganUjian;
    private String namaFile;
    private String tipeFile;
    
    public Nilai() {
    }
    
    public Nilai(String ruanganKode, String ujianKode, InputStream nilaiFile) {
        this.ruanganKode = ruanganKode;
        this.ujianKode = ujianKode;
        this.nilaiFile = nilaiFile;
    }
    
    public String getRuanganKode() {
        return ruanganKode;
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
    
    public InputStream getNilaiFile() {
        return nilaiFile;
    }
    
    public void setNilaiFile(InputStream nilaiFile) {
        this.nilaiFile = nilaiFile;
    }
    
    public RuanganUjian getRuanganUjian() {
        RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
        ruanganUjian = ruanganUjianFacade.findByRuanganKodeUjianKodeStafNip(ruanganKode, ujianKode, null).get(0);
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
    
}
