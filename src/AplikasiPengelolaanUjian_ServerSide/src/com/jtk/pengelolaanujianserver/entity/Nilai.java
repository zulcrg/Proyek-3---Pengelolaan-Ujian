/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujianserver.entity;

import com.jtk.pengelolaanujianserver.facade.RuanganUjianFacade;
import java.sql.Blob;

/**
 *
 * @author Rizki
 */
public class Nilai {

    private String ruanganKode;
    private String ujianKode;
    private Blob nilaiFile;
    private RuanganUjian ruanganUjian;
    
    public Nilai() {
    }
    
    public Nilai(String ruanganKode, String ujianKode, Blob nilaiFile) {
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
    
    public Blob getNilaiFile() {
        return nilaiFile;
    }
    
    public void setNilaiFile(Blob nilaiFile) {
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
    
}
