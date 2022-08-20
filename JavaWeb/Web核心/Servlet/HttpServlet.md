# HttpServlet

#### 概述

**HttpServlet**是由**GenericServlet**抽象类**扩展**而来的；

**HttpServlet**之所以运用广泛的另一个原因是现在**大部分的应用程序都要与HTTP**结合起来使用。这意味着我们可以利用HTTP的特性完成更多更强大的任务。



#### 使用

HttpServlet抽象类是继承于GenericServlet抽象类而来的。使用HttpServlet抽象类时，还需要借助分别代表Servlet请求和Servlet响应的HttpServletRequest和HttpServletResponse对象。

- HttpServletRequest接口扩展于javax.servlet.ServletRequest接口
- HttpServletResponse接口扩展于javax.servlet.servletResponse接口。



HttpServlet抽象类覆盖了GenericServlet抽象类中的Service( )方法，并且添加了一个自己独有的Service(HttpServletRequest request，HttpServletResponse方法。



```java
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    HttpServletRequest request;
    HttpServletResponse response;
    try {
        request = (HttpServletRequest)req;
        response = (HttpServletResponse)res;
    } catch (ClassCastException var6) {
        throw new ServletException("non-HTTP request or response");
    }
 
    this.service(request, response);
}
```

```java
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String method = req.getMethod();
    long lastModified;
    if (method.equals("GET")) {
        lastModified = this.getLastModified(req);
        if (lastModified == -1L) {
            this.doGet(req, resp);
        } else {
            long ifModifiedSince = req.getDateHeader("If-Modified-Since");
            if (ifModifiedSince < lastModified) {
                this.maybeSetLastModified(resp, lastModified);
                this.doGet(req, resp);
            } else {
                resp.setStatus(304);
            }
        }
    } else if (method.equals("HEAD")) {
        lastModified = this.getLastModified(req);
        this.maybeSetLastModified(resp, lastModified);
        this.doHead(req, resp);
    } else if (method.equals("POST")) {
        this.doPost(req, resp);
    } else if (method.equals("PUT")) {
        this.doPut(req, resp);
    } else if (method.equals("DELETE")) {
        this.doDelete(req, resp);
    } else if (method.equals("OPTIONS")) {
        this.doOptions(req, resp);
    } else if (method.equals("TRACE")) {
        this.doTrace(req, resp);
    } else {
        String errMsg = lStrings.getString("http.method_not_implemented");
        Object[] errArgs = new Object[]{method};
        errMsg = MessageFormat.format(errMsg, errArgs);
        resp.sendError(501, errMsg);
    }
 
}
```





#### 特性

- 不用覆盖service方法，而是覆盖doGet或者doPost方法。在少数情况，还会覆盖其他的5个方法。
- 使用的是HttpServletRequest和HttpServletResponse对象。







### HttpServletRequest

因为HttpRequest代表请求，所以我们可以通过该对象分别获得HTTP请求的请求行，请求头和请求体。

关于HTTP具体的详细解释，可以参考我的另一篇博文：JavaWeb——HTTP。

#### 方法

```java
String getContextPath();//返回请求上下文的请求URI部分
Cookie[] getCookies();//返回一个cookie对象数组
String getHeader(String var1);//返回指定HTTP标题的值
String getMethod();//返回生成这个请求HTTP的方法名称
String getQueryString();//返回请求URL中的查询字符串
HttpSession getSession();//返回与这个请求相关的会话对象
```



#### 乱码解决

- **解决post提交方式的乱码：**
	- request.setCharacterEncoding("UTF-8");

- **解决get提交的方式的乱码：**
	- parameter = newString(parameter.getbytes("iso8859-1"),"utf-8");





### HttpSerlvetResponse

在Service API中，定义了一个**HttpServletResponse**接口，它继承自**ServletResponse**接口，专门用来封装HTTP响应消息。    由于HTTP请求消息分为**状态行，响应消息头，响应消息体**三部分，因此，在**HttpServletResponse**接口中定义了向客户端发送响应状态码，响应消息头，响应消息体的方


#### 方法

**设置响应头**

```java
void addCookie(Cookie var1);//给这个响应添加一个cookie
void addHeader(String var1, String var2);//给这个请求添加一个响应头
void sendRedirect(String var1) throws IOException;//发送一条响应码，讲浏览器跳转到指定的位置
void setStatus(int var1);//设置响应行的状态码
```

**设置响应体**

```java
PrintWriter getWriter(); // 获得字符流
ServletOutputStream getOutputStream(); // 获得字节流
```





#### 乱码问题

response缓冲区的默认编码时iOS-8859-1,所以需要更改response的编码

```java
response.setCharacterEncoding("utf-8");// 更改Response的编码方式
response.setHeader("Context-Type","text/html;charset=utf-8");
```

**or**

```java
response.setContentType("text/html;charset=UTF-8");
```





