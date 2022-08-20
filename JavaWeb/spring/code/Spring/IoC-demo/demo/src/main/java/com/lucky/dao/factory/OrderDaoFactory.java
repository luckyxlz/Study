package com.lucky.dao.factory;

import com.lucky.dao.OrderDao;
import com.lucky.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        return new OrderDaoImpl();
    }
}
