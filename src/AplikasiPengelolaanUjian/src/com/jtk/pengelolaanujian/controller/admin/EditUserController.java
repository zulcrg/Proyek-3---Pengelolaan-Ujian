/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jtk.pengelolaanujian.controller.admin;

import com.jtk.pengelolaanujian.entity.User;
import com.jtk.pengelolaanujian.facade.UserFacade;

/**
 *
 * @author Rizki
 */
public class EditUserController {
    public void editUser(User user, String textNama, String textPassword) {
        UserFacade userFacade = new UserFacade();
        userFacade.editUser(user);
    }
}
