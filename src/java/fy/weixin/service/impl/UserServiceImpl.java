/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fy.weixin.service.impl;

import fy.weixin.dao.UserDao;
import fy.weixin.domain.User;
import fy.weixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author it-liuzd
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public String addNewUser(User u) {
        String result = userDao.addNewUser(u);
        return result;
    }

    @Override
    public boolean checkUserExist(User u) {
        User user = null;
        if (u.getName() == null || ("").equals(u.getName()) || u.getEmpid() == null || ("").equals(u.getEmpid()) || u.getEmail() == null || ("").equals(u.getEmail())) {

        } else {
            user = userDao.getUserByObject(u);
        }
        return user != null;
    }

    @Override
    public User getUserByObject(User u) {
        User user = null;
        if (u.getName() != null && u.getEmpid() != null && u.getEmail() != null) {
            user = userDao.getUserByObject(u);
        }
        return user;
    }

}
