/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.controller.dashboard;

import com.jtk.pengelolaanujian.entity.Event;
import com.jtk.pengelolaanujian.facade.EventFacade;

/**
 *
 * @author pahlevi
 */
public class TriggerDashboardController {

    public Event getListEvent() {
        EventFacade eventFacade = new EventFacade();        
        return eventFacade.findTrue();        
    }
    
}
