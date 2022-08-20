package com.lucky.dao.factory;

import com.lucky.dao.UserDao;
import com.lucky.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDao getUserDao(){
        return  new UserDaoImpl();
    }
}
