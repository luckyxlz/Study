package com.lucky;

import com.lucky.config.SpringConfig;
import com.lucky.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3 {
    public static void main(String[] args) {
        //获取IoC容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserDao userDao1 = ctx.getBean(UserDao.class);
        UserDao userDao2 = ctx.getBean(UserDao.class);

        System.out.println(userDao2);
        System.out.println(userDao1);
        ctx.close();



    }
}
