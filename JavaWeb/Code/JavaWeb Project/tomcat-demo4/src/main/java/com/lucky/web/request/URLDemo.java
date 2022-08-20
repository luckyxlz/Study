package com.lucky.web.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String username = "张三";

        String encode = URLEncoder.encode(username, "utf-8");
        String decode = URLDecoder.decode(encode, "utf-8");
        System.out.println(decode);


    }
}
