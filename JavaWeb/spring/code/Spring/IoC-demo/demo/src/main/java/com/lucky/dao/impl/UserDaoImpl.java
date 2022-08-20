package com.lucky.dao.impl;

import com.lucky.dao.UserDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

@Component("userDao")
@Scope("singleton")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("UserDaoImpl save ...");
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }
}
