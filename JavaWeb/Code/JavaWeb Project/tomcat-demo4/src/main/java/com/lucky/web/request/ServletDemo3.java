package com.lucky.web.request;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req")
public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //打印请求方法
        String method = req.getMethod();
        System.out.println(method);
        //获取虚拟机目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //获取URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        //获取URI
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        //获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //获取请求头
        String header = req.getHeader("user-agent");
        System.out.println(header);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String line = reader.readLine();
        System.out.println(line);

    }
}
