/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.entity;

/**
 *
 * @author pahlevi
 */
public class Kelas {
    private String kelasKode;
    private String kelasNama;

    public Kelas() {

    }

    public String getKelasKode() {
        return kelasKode;
    }

    public void setKelasKode(String kelasKode) {
        this.kelasKode = kelasKode;
    }

    public String getKelasNama() {
        return kelasNama;
    }

    public void setKelasNama(String kelasNama) {
        this.kelasNama = kelasNama;
    }

    public Kelas(String kelasKode, String kelasNama) {
        this.kelasKode = kelasKode;
        this.kelasNama = kelasNama;
    }
    
    
}
