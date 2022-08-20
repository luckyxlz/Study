# GenericServlet



#### 概述

简化实现Servlet，实现了Servlet与ServletConfig;



#### 具体代码

```java
public abstract class GenericServlet implements Servlet, ServletConfig, Serializable {
    private static final String LSTRING_FILE = "javax.servlet.LocalStrings";
    private static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.LocalStrings");
    private transient ServletConfig config;
 
    public GenericServlet() {
    }
 
    public void destroy() {
    }
 
    public String getInitParameter(String name) {
        ServletConfig sc = this.getServletConfig();
        if (sc == null) {
            throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
        } else {
            return sc.getInitParameter(name);
        }
    }
 
    public Enumeration<String> getInitParameterNames() {
        ServletConfig sc = this.getServletConfig();
        if (sc == null) {
            throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
        } else {
            return sc.getInitParameterNames();
        }
    }
 
    public ServletConfig getServletConfig() {
        return this.config;
    }
 
    public ServletContext getServletContext() {
        ServletConfig sc = this.getServletConfig();
        if (sc == null) {
            throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
        } else {
            return sc.getServletContext();
        }
    }
 
    public String getServletInfo() {
        return "";
    }
 
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.init();
    }
 
    public void init() throws ServletException {
    }
 
    public void log(String msg) {
        this.getServletContext().log(this.getServletName() + ": " + msg);
    }
 
    public void log(String message, Throwable t) {
        this.getServletContext().log(this.getServletName() + ": " + message, t);
    }
 
    public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 
    public String getServletName() {
        ServletConfig sc = this.getServletConfig();
        if (sc == null) {
            throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
        } else {
            return sc.getServletName();
        }
    }
}
```



#### 优点：

- 简化开发
- 将需要执行的初始化操作覆盖到init()方法