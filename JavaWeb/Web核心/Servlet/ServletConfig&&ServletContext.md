# ServletConfig&&ServletContext





## ServletConfig

#### 概述

当Servlet容器初始化Servlet时，Servlet容器会给Servlet的init( )方式传入一个ServletConfig对象。



### 方法

```java
String getServletName();
String getInitParameter(String name);
Enumeration getInitParameterNames();
```







## ServletContext

ServletContext对象表示Servlet应用程序。**每个Web应用程序都只有一个ServletContext对象**。在将一个应用程序同时部署到多个容器的分布式环境中，每台Java虚拟机上的Web应用都会有一个ServletContext对象。

通过在ServletConfig中调用getServletContext方法，也可以获得ServletContext对象。

==有了ServletContext对象，就可以共享从应用程序中的所有资料处访问到的信息，并且可以动态注册Web对象==。前者将对象保存在ServletContext中的一个内部Map中。保存在ServletContext中的对象被称作属性。

ServletContext中的下列方法负责处理属性：
```java
Object getAttribute(String var1);
 
Enumeration<String> getAttributeNames();
 
void setAttribute(String var1, Object var2);
 
void removeAttribute(String var1);
```

