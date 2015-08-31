/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fy.weixin.dao;

import fy.weixin.domain.User;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author it-liuzd
 */
public interface UserDao {

    User getUserById(int id);

    String addNewUser(User user);

    String updateUserById(int id, User user);

    String deleteUserById(int id);
    
    User getUserByObject(User u);
    

};
