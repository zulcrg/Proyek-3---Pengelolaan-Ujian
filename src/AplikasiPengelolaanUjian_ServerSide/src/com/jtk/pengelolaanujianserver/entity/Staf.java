/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujianserver.entity;

import com.jtk.pengelolaanujianserver.facade.RuanganUjianFacade;
import com.jtk.pengelolaanujianserver.facade.UserFacade;
import java.util.List;

/**
 *
 * @author pahlevi
 */
public class Staf {

    private String stafNIP;
    private String stafNama;
    private String stafEmail;
    private String stafKontak;
    private User user;
    private List<RuanganUjian> ruanganUjianList;

    public Staf() {

    }

    public String getStafNIP() {
        return stafNIP;
    }

    public void setStafNIP(String stafNIP) {
        this.stafNIP = stafNIP;
    }

    public String getStafNama() {
        return stafNama;
    }

    public void setStafNama(String stafNama) {
        this.stafNama = stafNama;
    }

    public String getStafEmail() {
        return stafEmail;
    }

    public void setStafEmail(String stafEmail) {
        this.stafEmail = stafEmail;
    }

    public String getStafKontak() {
        return stafKontak;
    }

    public void setStafKontak(String stafKontak) {
        this.stafKontak = stafKontak;
    }

    public User getUserQuery() {
        UserFacade userFacade = new UserFacade();
        user = userFacade.findByKodeStafNip(stafNIP);
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RuanganUjian> getRuanganUjianList() {
        RuanganUjianFacade ruanganUjianFacade = new RuanganUjianFacade();
        ruanganUjianList = ruanganUjianFacade.findByRuanganKodeUjianKodeStafNip(null, null, stafNIP);
        return ruanganUjianList;
    }

    public void setRuanganUjianList(List<RuanganUjian> ruanganUjianList) {
        this.ruanganUjianList = ruanganUjianList;
    }

}
