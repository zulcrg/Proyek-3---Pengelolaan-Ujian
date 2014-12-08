/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.entity;

import com.jtk.pengelolaanujianserver.facade.SoalFacade;
import java.util.List;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class MataKuliah {

    private String matkulKode;
    private String matkulNama;
    private String matkulTipe;
    private List<Dosen> dosenList;
    private List<Soal> soalList;

    public String getMatkulKode() {
        return matkulKode;
    }

    public void setMatkulKode(String matkulKode) {
        this.matkulKode = matkulKode;
    }

    public String getMatkulNama() {
        return matkulNama;
    }

    public void setMatkulNama(String matkulNama) {
        this.matkulNama = matkulNama;
    }

    public String getMatkulTipe() {
        return matkulTipe;
    }

    public void setMatkulTipe(String matkulTipe) {
        this.matkulTipe = matkulTipe;
    }

    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    public List<Soal> getSoalList() {
        SoalFacade soalFacade = new SoalFacade();
        soalList = soalFacade.findByKodeMatkul(matkulKode);
        return soalList;
    }

    public void setSoalList(List<Soal> soalList) {
        this.soalList = soalList;
    }
}
