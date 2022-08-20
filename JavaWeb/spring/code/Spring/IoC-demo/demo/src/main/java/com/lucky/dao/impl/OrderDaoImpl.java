package com.lucky.dao.impl;

import com.lucky.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void save() {
        System.out.println("Order dao save");
    }
}
