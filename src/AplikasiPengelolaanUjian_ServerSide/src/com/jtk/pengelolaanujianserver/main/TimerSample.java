
package com.jtk.pengelolaanujianserver.main;


import com.jtk.pengelolaanujianserver.proces.ValidityActionControlProcess;
import java.util.Timer;
 
public class TimerSample {
 
    public static void main(String[] args) {
        //1- Taking an instance of Timer class.
        Timer timer = new Timer();
 
        //2- Taking an instance of class contains your repeated method.        
        ValidityActionControlProcess actionControl = new ValidityActionControlProcess();
 
        //TimerTask is a class implements Runnable interface so
        //You have to override run method with your certain code black
 
        //Second Parameter is the specified the Starting Time for your timer in
        //MilliSeconds or Date
 
        //Third Parameter is the specified the Period between consecutive
        //calling for the method. 
        timer.schedule(actionControl, 0, 10000);         
    }
}