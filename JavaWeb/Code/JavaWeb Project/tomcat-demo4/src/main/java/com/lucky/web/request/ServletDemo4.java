package com.lucky.web.request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo4 extends MyHttpServlet{
    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
        System.out.println("demo 4,post...");
    }

    @Override
    protected void doGet(ServletRequest req, ServletResponse res) {
        System.out.println("demo 4,get...");
    }
}
