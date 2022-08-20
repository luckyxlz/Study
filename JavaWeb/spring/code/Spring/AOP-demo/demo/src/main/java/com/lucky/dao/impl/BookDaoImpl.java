package com.lucky.dao.impl;

import com.lucky.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {


    public void save() {
        System.out.println("save");
    }

    public void update() {
        System.out.println("update");
    }


}
