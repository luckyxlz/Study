package com.lucky;

import com.lucky.dao.BookDao;
import com.lucky.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        //获取IoC容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
//        OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
//        orderDao.save();

        //获取bean
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.save();
//        ctx.close();


        UserDao userDao = (UserDao) ctx.getBean("userDao");
        userDao.save();
        System.out.println(userDao);

        //获取bean
//        BookService bookServiceImp = (BookService) ctx.getBean("bookServiceImp");
//        bookServiceImp.save();
//
//        UserDaoFactory userDaoFactory = new UserDaoFactory();
//        UserDao userDao = userDaoFactory.getUserDao();
//        userDao.save();

//        UserDao userDao1 = (UserDao) ctx.getBean("userDao");
//        UserDao userDao2 = (UserDao) ctx.getBean("userDao");
//        userDao1.save();
//        userDao2.save();
//        System.out.println(userDao1);
//        System.out.println(userDao2);

    }
}
