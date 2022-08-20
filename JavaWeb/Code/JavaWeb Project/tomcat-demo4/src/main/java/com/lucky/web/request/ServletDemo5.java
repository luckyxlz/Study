package com.lucky.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet("/req2")
public class ServletDemo5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post乱码问题
//        req.setCharacterEncoding("UTF-8");

        //获取请求体
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            //打印key
            System.out.print(key+"：");
            //获取key对应values
            String[] values = map.get(key);
            //遍历values
            for (String value : values) {
                //String encode = URLEncoder.encode(value, "ISO-8859-1");
                //System.out.println(encode);
                //value = URLDecoder.decode(encode, "utf-8");
                value = new String(value.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
                System.out.print(value + ' ');
            }
            //打印换行
            System.out.println();
        }
        System.out.println("----------------");

    }
}
