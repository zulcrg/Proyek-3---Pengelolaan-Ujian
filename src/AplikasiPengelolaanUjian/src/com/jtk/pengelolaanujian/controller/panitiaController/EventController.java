/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.facade.EventFacade;
import javax.swing.JOptionPane;

/**
 *
 * @author Zulkhair Abdullah D & Pahlevi Ridwan P.
 */
public class EventController {

    public boolean createEvent(Event event) {
        EventFacade eventFacade = new EventFacade();
        if (eventFacade.findByKodeEvent(event.getKode()) == null) {
            return eventFacade.createEvent(event);
        } else {
            JOptionPane.showMessageDialog(null, "Event dengan kode '" + event.getKode() + " sudah ada", "Perhatian", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public Event getListEvent() {
        EventFacade eventFacade = new EventFacade();        
        return eventFacade.findTrue();        
    }
}
