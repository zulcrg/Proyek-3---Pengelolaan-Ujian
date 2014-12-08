/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujianserver.proces;

import java.util.TimerTask;

/**
 *
 * @author pahlevi
 */
public class ActionControlProcess  extends TimerTask  {
     
    public void run() {
        System.out.println("Cek aturan main - action control setiap 10 detik 1x");
    }
}
