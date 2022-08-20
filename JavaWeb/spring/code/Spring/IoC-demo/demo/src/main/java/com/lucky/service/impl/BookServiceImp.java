package com.lucky.service.impl;

import com.lucky.dao.BookDao;

import com.lucky.service.BookService;

public class BookServiceImp implements BookService {
    private BookDao bookDao;


    public void save() {
        System.out.println("book service save");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
