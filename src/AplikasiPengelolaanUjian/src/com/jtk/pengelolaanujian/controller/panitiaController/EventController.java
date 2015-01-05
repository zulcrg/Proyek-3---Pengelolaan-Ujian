/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.controller.AbstractController;
import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.facade.EventFacade;
import com.jtk.pengelolaanujian.util.ConnectionHelper;
import com.jtk.pengelolaanujian.view.LoginPanel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Zulkhair Abdullah D & Pahlevi Ridwan P.
 */
public class EventController extends AbstractController {

    public boolean createEvent(Event event) {
        EventFacade eventFacade = new EventFacade();
        if (eventFacade.findByKodeEvent(event.getKode()) == null) {
            try {
                ConnectionHelper.getConnection().setAutoCommit(false);
                eventFacade.updateActiveEvent();
                eventFacade.createEvent(event);
                ConnectionHelper.getConnection().commit();
                ConnectionHelper.getConnection().setAutoCommit(true);
                LoginPanel.setEvent(event);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
                addErrorMessage("Gagal membuat event", "Error");
                try {
                    ConnectionHelper.getConnection().rollback();
                    ConnectionHelper.getConnection().setAutoCommit(true);
                } catch (SQLException sqlex) {
                    Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, sqlex);
                }
            }
        } else {
            addWarnMessage("Event dengan kode " + event.getKode() + " sudah ada", "Perhatian");
        }
        return false;
    }

    public Event getListEvent() {
        EventFacade eventFacade = new EventFacade();
        return eventFacade.findTrue();
    }
}
