# Servlet生命周期



#### 工作原理

**Servlet容器将Servlet类载入内存，并产生Servlet实例和调用它具体的方法**。但是要注意的是，**在一个应用程序中，每种Servlet类型只能有一个实例**。

**用户请求致使Servlet容器调用Servlet的Service（）方法**，并传入一个**ServletRequest**对象和一个**ServletResponse**对象。**ServletRequest**对象和**ServletResponse**对象都是由Servlet容器（例如TomCat）封装好的，可以**直接使用**

ServletRequest中封装了当前的Http请求，因此不必解析和操作原始的Http数据。ServletResponse表示当前用户的Http响应，只需直接操作ServletResponse对象就能把响应轻松的发回给用户。

对于每一个应用程序，Servlet容器还会创建一个**ServletContext**对象。这个对象中封装了上下文（应用程序）的环境详情。每个应用程序只有一个ServletContext。每个Servlet对象也都有一个封装Servlet配置的**ServletConfig**对象。



#### 过程

`Servlet` 生命周期可被定义为从**创建**直到**毁灭**的整个过程。以下是 `Servlet` 遵循的过程：

- `Servlet` 初始化后调用 `init()` 方法。
- `Servlet` 调用 `service()`方法来处理客户端的请求。
- `Servlet` 销毁前调用 `destroy()` 方法。
- 最后，`Servlet` 是由 `JVM` 的垃圾回收器进行垃圾回收的。



#### Init()方法

**init 方法被设计成只调用一次。它在第一次创建 Servlet 时被调用(==由servlet容器调用==)，在后续每次用户请求时不再调用。**

Servlet 创建于用户第一次调用对应于该 Servlet 的 URL 时，**但是您也可以指定 Servlet 在服务器第一次启动时被加载。**

当用户调用一个 Servlet 时，就会创建一个 Servlet 实例，每一个用户请求都会产生一个新的线程，适当的时候移交给 doGet 或 doPost 方法。**init() 方法简单地创建或加载一些数据，这些数据将被用于 Servlet 的整个生命周期。**







#### Service()方法

`service()` 方法是执行实际任务的主要方法。`Servlet` 容器（即 Web 服务器）调用 `service()` 方法来处理来自客户端（浏览器）的请求，并把格式化的响应写回给客户端。

每次服务器接收到一个 `Servlet` 请求时，服务器会产生一个新的线程并调用服务。`service()` 方法检查 `HTTP` 请求类型（`GET`、`POST`、`PUT`、`DELETE` 等），并在适当的时候调用 `doGet`、`doPost`、`doPut`，`doDelete` 等方法。



`service()` 方法由容器调用，`service` 方法在适当的时候调用`doGet`、`doPost`、`doPut`、`doDelete` 等方法。所以，不用对 `service()` 方法做任何动作，您只需要根据来自客户端的请求类型来重写 `doGet()` 或 `doPost()` 即可。





#### destroy() 方法

**destroy() 方法只会被调用一次，在 Servlet 生命周期结束时被调用。**`destroy()` 方法可以让您的 `Servlet` 关闭数据库连接、停止后台线程、把 `Cookie` 列表或点击计数器写入到磁盘，并执行其他类似的清理活动。

在调用 `destroy()` 方法之后，`servlet` 对象被标记为垃圾回收。





#### Servlet 的其它两个方法

<hr/>

- **getServletInfo（ ）**，这个方法会返回Servlet的一段描述，可以返回一段字符串。

- **getServletConfig（ ）**，这个方法会返回由Servlet容器传给init（ ）方法的ServletConfig对象。







#### 架构图

下图显示了一个典型的 Servlet 生命周期方案。

- 第一个到达服务器的 HTTP 请求被委派到 Servlet 容器。
- Servlet 容器在调用 service() 方法之前加载 Servlet。
- 然后 Servlet 容器处理由多个线程产生的多个请求，每个线程执行一个单一的 Servlet 实例的 service() 方法。

![](./images/Servlet-LifeCycle.jpg)