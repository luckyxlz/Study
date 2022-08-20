# Listener

- 概念：Listener表示监听器，是JavaWeb三大组件(Servlet, Filter, Listener)之一
- 监听器可以监听就是在application，session，request三个对象创建，销毁或者往其中添加修改删除属性时自动执行代码的功能组件
- Listener分类：JavaWeb提供了8个监听器



#### ServletContextListener使用

实现ServletContextListener接口，覆盖Init和Destroy方法

```java
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener.contextInitialized方法被调用");
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener.contextDestroyed方法被调用");
    }
}
```

在web.xml中注册Listener

