/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.entity;

import com.jtk.pengelolaanujianserver.facade.RuanganUjianFacade;
import java.util.List;

/**
 *
 * @author Rizki
 */
public class Ruangan {

    private String ruanganKode;
    private String ruanganNama;
    private List<RuanganUjian> ruanganUjianList;

    public Ruangan() {
    }

    public Ruangan(String ruanganKode, String ruanganNama) {
        this.ruanganKode = ruanganKode;
        this.ruanganNama = ruanganNama;
    }

    public String getRuanganKode() {
        return ruanganKode;
    }

    public void setRuanganKode(String ruanganKode) {
        this.ruanganKode = ruanganKode;
    }

    public String getRuanganNama() {
        return ruanganNama;
    }

    public void setRuanganNama(String ruanganNama) {
        this.ruanganNama = ruanganNama;
    }

    public List<RuanganUjian> getRuanganUjianList() {
        RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
        ruanganUjianList = ruanganUjianFacade.findByRuanganKodeUjianKodeStafNip(ruanganKode, null, null);
        return ruanganUjianList;
    }

    public void setRuanganUjianList(List<RuanganUjian> ruanganUjianList) {
        this.ruanganUjianList = ruanganUjianList;
    }

}
