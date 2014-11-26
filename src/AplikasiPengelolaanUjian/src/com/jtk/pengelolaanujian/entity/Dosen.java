/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.entity;

/**
 *
 * @author M Haska Ash Shiddiq
 */
public class Dosen extends Staf{

    private String dosenKode;
    private String kbkKode;
    private Kbk kbk;

    public Dosen() {
    }

    public Dosen(String dosenKode, String kbkKode) {
        this.dosenKode = dosenKode;
        this.kbkKode = kbkKode;
    }

    public String getDosenKode() {
        return dosenKode;
    }

    public void setDosenKode(String dosenKode) {
        this.dosenKode = dosenKode;
    }

    public String getKbkKode() {
        return kbkKode;
    }

    public void setKbkKode(String kbkKode) {
        this.kbkKode = kbkKode;
    }

    public Kbk getKbk() {
        return kbk;
    }

    public void setKbk(Kbk kbk) {
        this.kbk = kbk;
    }

}
