/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fy.weixin.service;

import fy.weixin.domain.User;

/**
 *
 * @author it-liuzd
 */
public interface UserService {

    User getUserById(int id);

    String addNewUser(User u);

    boolean checkUserExist(User u);

    User getUserByObject(User u);

}
