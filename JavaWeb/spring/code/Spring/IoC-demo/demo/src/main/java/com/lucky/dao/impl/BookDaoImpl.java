package com.lucky.dao.impl;

import com.lucky.dao.BookDao;

import java.util.List;

public class BookDaoImpl implements BookDao {



    private BookDaoImpl(){
        System.out.println("BookDaoImpl");
    }

    public void init(){
        System.out.println("init");
    }

    public void save() {
        System.out.println("book dao save");
    }

    public void destroy(){
        System.out.println("destroy");
    }
}
