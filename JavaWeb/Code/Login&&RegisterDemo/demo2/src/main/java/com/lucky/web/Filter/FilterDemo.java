package com.lucky.web.Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("1.filter被执行了");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("2.filter被执行了");
    }

    @Override
    public void destroy() {

    }
}
