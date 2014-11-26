/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.entity;

import com.jtk.pengelolaanujian.facade.DosenFacade;
import java.util.List;

/**
 *
 * @author M Haska Ash Shiddiq
 */
public class Kbk {

    private String kbkKode;
    private String kbkNama;
    private List<Dosen> dosenList;

    public Kbk() {
    }

    public Kbk(String kbkKode, String kbkNama, List<Dosen> dosenList) {
        this.kbkKode = kbkKode;
        this.kbkNama = kbkNama;
        this.dosenList = dosenList;
    }

    public String getKbkKode() {
        return kbkKode;
    }

    public void setKbkKode(String kbkKode) {
        this.kbkKode = kbkKode;
    }

    public String getKbkNama() {
        return kbkNama;
    }

    public void setKbkNama(String kbkNama) {
        this.kbkNama = kbkNama;
    }

    public List<Dosen> getDosenList() {
        DosenFacade dosenFacade = new DosenFacade();
        dosenList = dosenFacade.findByKbkKode(kbkKode);
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

}
