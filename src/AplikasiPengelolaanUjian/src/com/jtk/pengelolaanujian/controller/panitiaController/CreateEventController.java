/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jtk.pengelolaanujian.controller.panitiaController;

import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.facade.EventFacade;

/**
 *
 * @author Zulkhair Abdullah D
 */
public class CreateEventController {

    public boolean createEvent(Event event) {
        EventFacade eventFacade = new EventFacade();
        return eventFacade.createEvent(event);
    }
}
