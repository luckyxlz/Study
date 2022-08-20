#### 第一章

### 简介

HTML5的设计目的是为了在移动设备上支持多媒体

### 基础

#### 将HTML5元素定义为块元素

HTML5 定了 8 个新的 HTML **语义（semantic）**  元素。所有这些元素都是 **块级** 元素。

为了能让旧版本的浏览器正确显示这些元素，你可以设置 CSS 的 **display** 属性值为 **block**:

```css

header, section, footer, aside, nav, main, article, figure {
    display: block; 
}

```

#### 向HTML添加新元素

你可以为 HTML 添加新的元素。

该实例向 HTML 添加的新的元素，并为该元素定义样式，元素名为 \<myHero>：

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<title>为 HTML 添加新元素</title>
<script>
document.createElement("myHero")
</script>
<style>
myHero {
    display: block;
    background-color: #ddd;
    padding: 50px;
    font-size: 30px;
}
</style> 
</head>
 
<body>
 
<h1>我的第一个标题</h1>
 
<p>我的第一个段落。</p>
 
<myHero>我的第一个新元素</myHero>
 
</body>
</html>

```

> JavaScript 语句 **document.createElement("myHero")** 是为 IE 浏览器添加新的元素。

## 第二章

### 新元素

![image-20220604161808293](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604161808293.png)

![image-20220604161815983](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604161815983.png)

![image-20220604161842904](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604161842904.png)

![image-20220604161904339](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604161904339.png)

![image-20220604162007230](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604162007230.png)

### canvas

#### 描述

 HTML5 \<canvas> 元素用于图形的绘制，通过脚本 (通常是JavaScript)来完成.

\<canvas> 标签只是图形容器，您必须使用脚本来绘制图形。

你可以通过多种方法使用 canvas 绘制路径,盒、圆、字符以及添加图像。

#### 语法

```html
<canvas id="myCanvas" width="200" height="100"></canvas> 

<script>
var c=document.getElementById("myCanvas");
var ctx=c.getContext("2d");
ctx.fillStyle="#FF0000";
ctx.fillRect(0,0,150,75);
</script>
```

![image-20220604162403259](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604162403259.png)

#### 坐标

![image-20220604162745843](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604162745843.png)

#### 绘制直线

![image-20220604162753746](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604162753746.png)

```javascript

var c=document.getElementById("myCanvas");
var ctx=c.getContext("2d");
ctx.moveTo(0,0);
ctx.lineTo(200,100);
ctx.stroke();

```

#### 绘制圆形

![image-20220604162900599](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604162900599.png)

#### 绘制文本

![image-20220604163116688](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604163116688.png)

```javascript

var c=document.getElementById("myCanvas");
var ctx=c.getContext("2d");
ctx.font="30px Arial";
ctx.fillText("Hello World",10,50);

```

```javascript

var c=document.getElementById("myCanvas");
var ctx=c.getContext("2d");
ctx.font="30px Arial";
ctx.strokeText("Hello World",10,50);

```

#### 渐变

![image-20220604163317044](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604163317044.png)

#### 图像

![image-20220604163627008](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604163627008.png)

### 视频

HTML5 规定了一种通过 video 元素来包含视频的标准方法。

 \<video> 元素提供了 播放、暂停和音量控件来控制视频。

同时 \<video> 元素也提供了 width 和 height  属性控制视频的尺寸.如果设置的高度和宽度，所需的视频空间会在页面加载时保留。如果没有设置这些属性，浏览器不知道大小的视频，浏览器就不能再加载时保留特定的空间，页面就会根据原始视频的大小而改变。

\<video> 与\</video> 标签之间插入的内容是提供给不支持 video 元素的浏览器显示的。

\<video> 元素支持多个 \<source> 元素. \<source>  元素可以链接不同的视频文件。浏览器将使用第一个可识别的格式：

#### 语法

```html

<video width="320" height="240" controls>
  <source src="movie.mp4" type="video/mp4">
  <source src="movie.ogg" type="video/ogg">
您的浏览器不支持Video标签。
</video>

```

![image-20220604164153355](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604164153355.png)

### 音频

HTML5 规定了在网页上嵌入音频元素的标准，即使用 \<audio> 元素。

#### 语法

```html

<audio controls>
  <source src="horse.ogg" type="audio/ogg">
  <source src="horse.mp3" type="audio/mpeg">
您的浏览器不支持 audio 元素。
</audio>

```

![image-20220604164837706](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604164837706.png)

### 输入

HTML5 拥有多个新的表单输入类型。这些新特性提供了更好的输入控制和验证。

#### HTML5新增的Input类型

- color

  - color 类型用在input字段主要用于选取颜色

- date

  - date 类型允许你从一个日期选择器选择一个日期。

- datetime

  - datetime 类型允许你选择一个日期（UTC 时间）。

- datetime-local

  - datetime-local 类型允许你选择一个日期和时间 (无时区).

- email

  - email 类型用于应该包含 e-mail 地址的输入域。

- month

  - month 类型允许你选择一个月份。

- number

  - number 类型用于应该包含数值的输入域。

  - 您还能够设定对所接受的数字的限定：

  - 语法：

    ```html
    <input type="number" name="quantity" min="1" max="5">
    ```

    

- range

  - range 类型用于应该包含一定范围内数字值的输入域
  - range 类型显示为滑动条。

- search

  - search 类型用于搜索域，比如站点搜索或 Google 搜索。

- tel

- time

  - time 类型允许你选择一个时间。

- url

  - url 类型用于应该包含 URL 地址的输入域。

- week

  - week 类型允许你选择周和年。

## 第三章

### 表单元素

#### HTML5 新的表单元素

HTML5 有以下新的表单元素:

- \<datalist>
- \<keygen>
- \<output>

#### HTML5 \<datalist> 元素

\<datalist> 元素规定输入域的选项列表。 

\<datalist>  属性规定 form 或 input 域应该拥有自动完成功能。当用户在自动完成域中开始输入时，浏览器应该在该域中显示填写的选项：

使用 \<input> 元素的列表属性与\<datalist> 元素绑定.

##### 语法

```html

<input list="browsers">
 
<datalist id="browsers">
  <option value="Internet Explorer">
  <option value="Firefox">
  <option value="Chrome">
  <option value="Opera">
  <option value="Safari">
</datalist>

```



#### HTML5 \<keygen> 元素

\<keygen> 元素的作用是提供一种验证用户的可靠方法。 

\<keygen>标签规定用于表单的密钥对生成器字段。

当提交表单时，会生成两个键，一个是私钥，一个公钥。

私钥（private key）存储于客户端，公钥（public key）则被发送到服务器。公钥可用于之后验证用户的客户端证书（client certificate）。

```html

<form action="demo_keygen.asp" method="get">
用户名: <input type="text" name="usr_name">
加密: <keygen name="security">
<input type="submit">
</form>

```

#### HTML5 \<output> 元素

\<output>  元素用于不同类型的输出，比如计算或脚本输出：

### 表单属性

![image-20220604170705591](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604170705591.png)

#### \<form> / \<input> autocomplete 属性

autocomplete 属性规定 form 或 input 域应该拥有自动完成功能。

当用户在自动完成域中开始输入时，浏览器应该在该域中显示填写的选项。

#### \<form> novalidate 属性

novalidate 属性是一个 boolean(布尔) 属性.

novalidate 属性规定在提交表单时不应该验证 form 或 input 域。

#### \<input> autofocus 属性

autofocus 属性是一个布尔属性。

autofocus 属性规定在页面加载时，域自动地获得焦点。

#### \<input> form 属性

form 属性规定输入域所属的一个或多个表单。

**提示:**如需引用一个以上的表单，请使用空格分隔的列表。

##### 语法

```html

<form action="demo-form.php" id="form1">
  First name: <input type="text" name="fname"><br>
  <input type="submit" value="提交">
</form>
 
Last name: <input type="text" name="lname" form="form1">

```

#### \<input> formaction 属性

The formaction 属性用于描述表单提交的URL地址.

The formaction 属性会覆盖\<form> 元素中的action属性.

#### \<input> formenctype 属性

 formenctype 属性描述了表单提交到服务器的数据编码 (只对form表单中 method="post" 表单)

formenctype 属性覆盖 form 元素的 enctype 属性。

#### \<input> formmethod  属性

 formmethod 属性定义了表单提交的方式。

 formmethod 属性覆盖了 \<form> 元素的 method 属性。

#### \<input> formnovalidate 属性

 novalidate 属性是一个 boolean 属性.

novalidate属性描述了 <input> 元素在表单提交时无需被验证。

formnovalidate 属性会覆盖 <form> 元素的novalidate属性.

#### \<input> formtarget 属性

formtarget 属性指定一个名称或一个关键字来指明表单提交数据接收后的展示。

formtarget 属性覆盖 <form>元素的target属性

#### \<input> height 和 width 属性

height 和 width 属性规定用于 image 类型的 \<input> 标签的图像高度和宽度。

#### \<input> list 属性

list 属性规定输入域的 datalist。datalist 是输入域的选项列表。

##### 语法

```html
<input list="browsers">

<datalist id="browsers">
  <option value="Internet Explorer">
  <option value="Firefox">
  <option value="Chrome">
  <option value="Opera">
  <option value="Safari">
</datalist> 
```

#### \<input> multiple 属性

multiple 属性是一个 boolean 属性.

multiple 属性规定\<input> 元素中可选择多个值。

#### \<input> pattern 属性

 pattern 属性描述了一个正则表达式用于验证 <input> 元素的值。

#### \<input> placeholder 属性

placeholder 属性提供一种提示（hint），描述输入域所期待的值。

简短的提示在用户输入值前会显示在输入域上。

#### \<input> required 属性

 required 属性是一个 boolean 属性.

required 属性规定必须在提交之前填写输入域（不能为空）。

## 第四章

### 语义元素

#### 定义：

一个语义元素能够清楚的描述其意义给浏览器和开发者。

![image-20220604204204598](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604204204598.png)

#### \<section> 元素

\<section> 标签定义文档中的节（section、区段）。比如章节、页眉、页脚或文档中的其他部分。

根据W3C HTML5文档:  section 包含了一组内容及其标题。

#### \<article> 元素

 \<article> 标签定义独立的内容。.

\<article> 元素使用实例:

- Forum post
- Blog post
- News story
- Comment

#### HTML5\<nav> 元素

\<nav> 标签定义导航链接的部分。

\<nav> 元素用于定义页面的导航链接部分区域，但是，不是所有的链接都需要包含在 \<nav> 元素中! 

#### HTML5 \<aside> 元素

\<aside>  标签定义页面主区域内容之外的内容（比如侧边栏）。

aside 标签的内容应与主区域的内容相关.

#### HTML5 \<header> 元素

\<header>元素描述了文档的头部区域

 \<header>元素主要用于定义内容的介绍展示区域.

在页面中你可以使用多个\<header> 元素.

#### HTML5 \<footer> 元素

\<footer> 元素描述了文档的底部区域.

 \<footer> 元素应该包含它的包含元素

一个页脚通常包含文档的作者，著作权信息，链接的使用条款，联系信息等

文档中你可以使用多个 \<footer>元素.

#### HTML5 \<figure> 和 \<figcaption> 元素

\<figure>标签规定独立的流内容（图像、图表、照片、代码等等）。

<figure> 元素的内容应该与主内容相关，但如果被删除，则不应对文档流产生影响。

\<figcaption> 标签定义 \<figure> 元素的标题.

\<figcaption>元素应该被置于 "figure" 元素的第一个或最后一个子元素的位置。

> 为了让这些块及元素在所有版本的浏览器中生效，你需要在样式表文件中设置一下属性 (以下样式代码可以让旧版本浏览器支持本章介绍的块级元素):
>
> ```css
> header, section, footer, aside, nav, article, figure
>  { 
>    display: block; 
>  }
> ```

### Web存储

#### 定义

HTML5 web 存储，一个比 cookie 更好的本地存储方式。

#### 与cookie的区别

早些时候,本地存储使用的是 cookie。但是Web 存储需要更加的安全与快速. 这些数据不会被保存在服务器上，但是这些数据只用于用户请求网站数据上.它也可以存储大量的数据，而不影响网站的性能.

数据以 键/值 对存在, web网页的数据只允许该网页访问使用。

#### 客户端存储数据的两个对象为：

- localStorage - 用于长久保存整个网站的数据，保存的数据没有过期时间，直到手动去除。
- sessionStorage - 用于临时保存同一窗口(或标签页)的数据，在关闭窗口或标签页之后将会删除这些数据。

## 第五章

### Web SQL数据库

Web SQL 数据库 API 并不是 HTML5 规范的一部分，但是它是一个独立的规范，引入了一组使用 SQL 操作客户端数据库的 APIs。

如果你是一个 Web 后端程序员，应该很容易理解 SQL 的操作。

你也可以参考我们的 SQL 教程，了解更多数据库操作知识。

Web SQL 数据库可以在最新版的  Safari, Chrome 和 Opera 浏览器中工作。

#### 核心方法

以下是规范中定义的三个核心方法：

1. **openDatabase**：这个方法使用现有的数据库或者新建的数据库创建一个数据库对象。
2. **transaction**：这个方法让我们能够控制一个事务，以及基于这种情况执行提交或者回滚。
3. **executeSql**：这个方法用于执行实际的 SQL 查询。

#### 打开数据库

##### 语法

```javascript
var db = openDatabase('mydb', '1.0', 'Test DB', 2 * 1024 * 1024);
openDatabase() 方法对应的五个参数说明：
数据库名称	
版本号
描述文本
数据库大小
创建回调
```

#### 执行查询操作

##### 语法

```javascript

var db = openDatabase('mydb', '1.0', 'Test DB', 2 * 1024 * 1024);
db.transaction(function (tx) {  
   tx.executeSql('CREATE TABLE IF NOT EXISTS LOGS (id unique, log)');
});

```

#### 插入数据

##### 语法

```javascript
var db = openDatabase('mydb', '1.0', 'Test DB', 2 * 1024 * 1024);
db.transaction(function (tx) {  
   tx.executeSql('CREATE TABLE IF NOT EXISTS LOGS (id unique, log)');
});
```

#### 读取数据

##### 语法

```javascript

var db = openDatabase('mydb', '1.0', 'Test DB', 2 * 1024 * 1024);
 
db.transaction(function (tx) {
   tx.executeSql('CREATE TABLE IF NOT EXISTS LOGS (id unique, log)');
   tx.executeSql('INSERT INTO LOGS (id, log) VALUES (1, "菜鸟教程")');
   tx.executeSql('INSERT INTO LOGS (id, log) VALUES (2, "www.runoob.com")');
});
 
db.transaction(function (tx) {
   tx.executeSql('SELECT * FROM LOGS', [], function (tx, results) {
      var len = results.rows.length, i;
      msg = "<p>查询记录条数: " + len + "</p>";
      document.querySelector('#status').innerHTML +=  msg;
    
      for (i = 0; i < len; i++){
         alert(results.rows.item(i).log );
      }
    
   }, null);
});

```

#### 删除数据

##### 语法

```javascript
db.transaction(function (tx) {
    tx.executeSql('DELETE FROM LOGS  WHERE id=1');
})
```

动态写法

```javascript
db.transaction(function(tx) {
    tx.executeSql('DELETE FROM LOGS WHERE id=?', [id]);
});
```

#### 更新数据

##### 语法

```javascript
db.transaction(function (tx) {
    tx.executeSql('UPDATE LOGS SET log=\'www.w3cschool.cc\' WHERE id=2');
});
```

动态的写法

```javascript
db.transaction(function(tx) {
    tx.executeSql('UPDATE LOGS SET log=\'www.w3cschool.cc\' WHERE id=?', [id]);
});
```

### 应用程序缓存

------

使用 HTML5，通过创建 cache manifest 文件，可以轻松地创建 web 应用的离线版本。

HTML5 引入了应用程序缓存，这意味着 web 应用可进行缓存，并可在没有因特网连接时进行访问。

应用程序缓存为应用带来三个优势：

1. 离线浏览 - 用户可在应用离线时使用它们
2. 速度 - 已缓存资源加载得更快
3. 减少服务器负载 - 浏览器将只从服务器下载更新过或更改过的资源。

#### Cache Manifest 基础

如需启用应用程序缓存，请在文档的\<html> 标签中包含 manifest 属性： 



### Web Wockers

web worker 是运行在后台的 JavaScript，不会影响页面的性能。

#### 什么是 Web Worker？

当在 HTML 页面中执行脚本时，页面的状态是不可响应的，直到脚本已完成。

web worker 是运行在后台的 JavaScript，独立于其他脚本，不会影响页面的性能。您可以继续做任何愿意做的事情：点击、选取内容等等，而此时 web worker 在后台运行。

### 服务器发送事件

#### 定义

HTML5 服务器发送事件（server-sent event）允许网页获得来自服务器的更新。

### WebSocket

WebSocket 是 HTML5 开始提供的一种在单个 TCP 连接上进行全双工通讯的协议。

#### 原理

在 WebSocket API 中，浏览器和服务器只需要完成一次握手，两者之间就直接可以创建持久性的连接，并进行双向数据传输。

在 WebSocket API 中，浏览器和服务器只需要做一个握手的动作，然后，浏览器和服务器之间就形成了一条快速通道。两者之间就直接可以数据互相传送。
