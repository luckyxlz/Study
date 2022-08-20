package com.lucky.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/resp2")
public class RespDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileInputStream fls = new FileInputStream("/Users/luckyzhong/Documents/Study/JavaWeb/JavaWeb Project/images/项目结构.png");//导入文件输入流
        ServletOutputStream os = resp.getOutputStream();//获取响应输出流
        IOUtils.copy(fls,os);//将文件输入流的内容复制到响应输出流中
        fls.close();//关闭文件输入流


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
