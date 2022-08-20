## 第一章

AJAX = Asynchronous JavaScript and XML（异步的 JavaScript 和 XML）。

AJAX 最大的优点是在不重新加载整个页面的情况下，可以与服务器交换数据并更新部分网页内容。

### AJAX 应用

- 运用 XHTML+CSS 来表达资讯；
- 运用 JavaScript 操作 DOM（Document Object Model）来执行动态效果；
- 运用 XML 和 XSLT 操作资料;
- 运用 XMLHttpRequest 或新的 Fetch API 与网页服务器进行异步资料交换；
- **注意：**AJAX 与 Flash、Silverlight 和 Java Applet 等 RIA 技术是有区分的。

![image-20220604223541354](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604223541354.png)

### AJAX-创建XMLHttpRequest对象

XMLHttpRequest 是 AJAX 的基础。

#### XMLHttpRequest 对象

所有现代浏览器均支持 XMLHttpRequest 对象（IE5 和 IE6 使用 ActiveXObject）。

XMLHttpRequest 用于在后台与服务器交换数据。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。

#### 创建 XMLHttpRequest 对象

![image-20220604224043143](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604224043143.png)

#### 向服务器发送请求

如需将请求发送到服务器，我们使用 **XMLHttpRequest** 对象的 **open()** 和 **send()** 方法：

```javascript
xmlhttp.open("GET","ajax_info.txt",true);
xmlhttp.send();
```

![image-20220604224309968](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604224309968.png)

#### GET 还是 POST？

与 POST 相比，GET 更简单也更快，并且在大部分情况下都能用。

然而，在以下情况中，请使用 POST 请求：

- 不愿使用缓存文件（更新服务器上的文件或数据库）
- 向服务器发送大量数据（POST 没有数据量限制）
- 发送包含未知字符的用户输入时，POST 比 GET 更稳定也更可靠

#### 异步 - True 或 False？

AJAX 指的是异步 JavaScript 和 XML（Asynchronous JavaScript and XML）。

XMLHttpRequest 对象如果要用于 AJAX 的话，其 open() 方法的 async 参数必须设置为 true：

通过 AJAX，JavaScript 无需等待服务器的响应，而是：

- 在等待服务器响应时执行其他脚本
- 当响应就绪后对响应进行处理

### 服务器响应

如需获得来自服务器的响应，请使用 XMLHttpRequest 对象的 responseText 或 responseXML 属性。

| 属性         | 描述                       |
| ------------ | -------------------------- |
| responseText | 获得字符串形式的响应数据。 |
| responseXML  | 获得 XML 形式的响应数据。  |

####  responseText 属性

如果来自服务器的响应并非 XML，请使用 responseText 属性。

responseText 属性返回字符串形式的响应，因此您可以这样使用：

#### responseXML 属性

如果来自服务器的响应是 XML，而且需要作为 XML 对象进行解析，请使用 responseXML 属性：

### AJAX - onreadystatechange 事件

当请求被发送到服务器时，我们需要执行一些基于响应的任务。

每当 readyState 改变时，就会触发 onreadystatechange 事件。

readyState 属性存有 XMLHttpRequest 的状态信息。

下面是 XMLHttpRequest 对象的三个重要的属性：

| 属性               | 描述                                                         |
| ------------------ | ------------------------------------------------------------ |
| onreadystatechange | 存储函数（或函数名），每当 readyState 属性改变时，就会调用该函数。 |
| readyState         | 存有 XMLHttpRequest 的状态。从 0 到 4 发生变化。  0: 请求未初始化 1: 服务器连接已建立 2: 请求已接收 3: 请求处理中 4: 请求已完成，且响应已就绪 |
| status             | 200: "OK"  404: 未找到页面                                   |

在 onreadystatechange 事件中，我们规定当服务器响应已做好被处理的准备时所执行的任务。

当 readyState 等于 4 且状态为 200 时，表示响应已就绪：

##### 语法

```javascript

xmlhttp.onreadystatechange=function()
{
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
        document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
    }
}

```

