# Filter 

#### 概念：

- Filter表示过滤器，是JavaWeb三大组件(`Servlet`, `Filter`, `Listener`)之一
- 过滤器可以把对资源的请求拦截下来，从而实现一些特殊功能
- 过滤器一般完成一些通用的操作，比如：**权限控制，统一编码处理。敏感字符处理**



#### Filter执行流程

- 执行放行前逻辑 --> 放行 --> 访问资源 --> 执行放行后逻辑
- **放行前，对request数据进行处理**
- **放行后，对response数据进行处理**



### Filter快速入门

1. 定义类，实现Filter接口，并重写其所有方法
2. 配置Filter拦截资源的路径：在类上定义@webFilter注解
3. 在doFilter方法中输出一句话，并放行

```java
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

```



#### Filter使用细节

- Filter拦截路径配置
  - 拦截具体的资源：
  - 目录拦截：
  - 后缀名拦截：
  - 拦截所有：
- 过滤器链
  - 一个Web应用，可以配置多个过滤器，这多个过滤器称为过滤器链
  - 注解配置的Filter，优先级按照过滤器类名的自然排序