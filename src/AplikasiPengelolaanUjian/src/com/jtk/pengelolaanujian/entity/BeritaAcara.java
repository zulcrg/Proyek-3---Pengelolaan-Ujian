/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.entity;

/**
 *
 * @author Rizki
 */
public class BeritaAcara {
    private String beritaKode;
    private String beritaKet;
    private int beritaHadir;
    private int beritaTidakHadir;
    private int beritaSoalSisa;
    private int beritaJawabSisa;
    private boolean beritaStatus;
    

    public BeritaAcara() {
    }

    public BeritaAcara(String beritaKode, String beritaKet, int beritaHadir, int beritaTidakHadir, int beritaSoalSisa, int beritaJawabSisa) {
        this.beritaKode = beritaKode;
        this.beritaKet = beritaKet;
        this.beritaHadir = beritaHadir;
        this.beritaTidakHadir = beritaTidakHadir;
        this.beritaSoalSisa = beritaSoalSisa;
        this.beritaJawabSisa = beritaJawabSisa;
    }

    public String getBeritaKode() {
        return beritaKode;
    }

    public void setBeritaKode(String beritaKode) {
        this.beritaKode = beritaKode;
    }

    public String getBeritaKet() {
        return beritaKet;
    }

    public void setBeritaKet(String beritaKet) {
        this.beritaKet = beritaKet;
    }

    public int getBeritaHadir() {
        return beritaHadir;
    }

    public void setBeritaHadir(int beritaHadir) {
        this.beritaHadir = beritaHadir;
    }

    public int getBeritaTidakHadir() {
        return beritaTidakHadir;
    }

    public void setBeritaTidakHadir(int beritaTidakHadir) {
        this.beritaTidakHadir = beritaTidakHadir;
    }

    public int getBeritaSoalSisa() {
        return beritaSoalSisa;
    }

    public void setBeritaSoalSisa(int beritaSoalSisa) {
        this.beritaSoalSisa = beritaSoalSisa;
    }

    public int getBeritaJawabSisa() {
        return beritaJawabSisa;
    }

    public void setBeritaJawabSisa(int beritaJawabSisa) {
        this.beritaJawabSisa = beritaJawabSisa;
    }

    public boolean isBeritaStatus() {
        return beritaStatus;
    }

    public void setBeritaStatus(boolean beritaStatus) {
        this.beritaStatus = beritaStatus;
    }
    
    
}
