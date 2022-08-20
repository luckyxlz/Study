## 第一章

### 简介

#### 定义

超文本标记语言（英语：HyperText Markup Language，简称：HTML）是一种用于创建网页的标准标记语言。使用 HTML 来建立自己的 WEB 站点，HTML 运行在浏览器上，由浏览器来解析。

> **注意：**对于中文网页需要使用 **<meta charset="utf-8">** 声明编码，否则会出现乱码。有些浏览器(如 360 浏览器)会设置 GBK 为默认编码，则你需要设置为 **<meta charset="gbk">。**

#### HTML文档的后缀名

- .html
- .htm

以上两种后缀名没有区别，都可以使用。

#### HTML的结构

![image-20220604094435423](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604094435423.png)

> HTML 是用来描述网页的一种语言。
>
> - HTML 指的是超文本标记语言: **H**yper**T**ext **M**arkup **L**anguage
> - HTML 不是一种编程语言，而是一种**标记**语言
> - 标记语言是一套**标记标签** (markup tag)
> - HTML 使用标记标签来**描述**网页
> - HTML 文档包含了HTML **标签**及**文本**内容
> - HTML文档也叫做 **web 页面**

#### HTML 标签

HTML 标记标签通常被称为 HTML 标签 (HTML tag)。

- HTML 标签是由*尖括号*包围的关键词，比如 <html\>
- HTML 标签通常是*成对出现*的，比如 \<b\> 和 \</b\>
- 标签对中的第一个标签是*开始标签*，第二个标签是*结束标签*
- 开始和结束标签也被称为*开放标签*和*闭合标签*

##  <!DOCTYPE> 声明

<!DOCTYPE>声明有助于浏览器中正确显示网页。

网络上有很多不同的文件，如果能够正确声明HTML的版本，浏览器就能正确显示网页内容。

doctype 声明是不区分大小写的，以下方式均可：

\<!DOCTYPE html> 

 \<!DOCTYPE HTML> 

 <!doctype html> 

 <!Doctype Html>

## 第二章

### 基础

#### 标题 

HTML 标题（Heading）是通过\<h1> - \<h6> 标签来定义的。

```html
<h1>这是一个标题</h1>
```

#### 段落

HTML 段落是通过标签\<p> 来定义的。

```html
<p>这是一个段落。</p>
```



#### HTML 链接

HTML 链接是通过标签 \<a> 来定义的。

```html
<a href="https://www.runoob.com">这是一个链接</a>
```



> 在 href 属性中指定链接的地址。

#### HTML 图像

HTML 图像是通过标签 \<img> 来定义的.

```html
<img src="/images/logo.png" width="258" height="39" />
```

> img是一个单标签

### 元素

#### HTML 元素语法

- HTML 元素以**开始标签**起始
- HTML 元素以**结束标签**终止
- **元素的内容**是开始标签与结束标签之间的内容
- 某些 HTML 元素具有**空内容（empty content）**
  - 例如\<br/>
- 空元素**在开始标签中进行关闭**（以开始标签的结束而结束）
- 大多数 HTML 元素可拥有**属性**

### 属性

#### 定义

属性是 HTML 元素提供的附加信息。

#### HTML 属性

- HTML 元素可以设置**属性**
- 属性可以在元素中添加**附加信息**
- 属性一般描述于**开始标签**
- 属性总是以名称/值对的形式出现，**比如：name="value"**。

![image-20220604103752017](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604103752017.png)

### 标题

标题（Heading）是通过 <h1> - <h6> 标签进行定义的。

\<h1> 定义最大的标题。 \<h6> 定义最小的标题。

> **注释:** 浏览器会自动地在标题的前后添加空行。

#### HTML 水平线

\<hr> 标签在 HTML 页面中创建水平线。

hr 元素可用于分隔内容。

#### HTML 注释

可以将注释插入 HTML 代码中，这样可以提高其可读性，使代码更易被人理解。浏览器会忽略注释，也不会显示它们。

```html
<!-- 这是一个注释 -->
```

### 段落

段落是通过 \<p>  标签定义的。

浏览器会自动地在段落的前后添加空行。（</p> 是块级元素）

如果您希望在不产生一个新段落的情况下进行换行（新行），请使用 \<br> 标签：

## 第三章

### 文本格式化

HTML 使用标签 \<b>("bold") 与 \<i>("italic") 对输出的文本进行格式, 如：**粗体** or *斜体*

这些HTML标签被称为格式化标签（请查看底部完整标签参考手册）。

![image-20220604110847656](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604110847656.png)

![image-20220604111125563](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604111125563.png)

### 链接

#### 定义

HTML 使用超级链接与网络上的另一个文档相连。几乎可以在所有的网页中找到链接。点击链接可以从一张页面跳转到另一张页面。

#### 使用

HTML使用标签 \<a>来设置超文本链接。

超链接可以是一个字，一个词，或者一组词，也可以是一幅图像，您可以点击这些内容来跳转到新的文档或者当前文档中的某个部分。

当您把鼠标指针移动到网页中的某个链接上时，箭头会变为一只小手。

在标签\<a> 中使用了href属性来描述链接的地址。

默认情况下，链接将以以下形式出现在浏览器中：

- 一个未访问过的链接显示为蓝色字体并带有下划线。
- 访问过的链接显示为紫色并带有下划线。
- 点击链接时，链接显示为红色并带有下划线。

#### 语法

> ```html
> <a href="url">链接文本</a> 
> ```

#### 属性

##### target属性

使用 target 属性，你可以定义被链接的文档在何处显示。

> ```html
> 下面的这行会在新窗口打开文档：
> <a href="https://www.runoob.com/" target="_blank" rel="noopener noreferrer">访问菜鸟教程!</a>
> 
> ```

##### id属性

![image-20220604111853305](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604111853305.png)

### Head

-  使用 \<title> 标签定义HTML文档的标题
- 使用 \<base> 定义页面中所有链接默认的链接目标地址。
- 使用 \<meta> 元素来描述HTML文档的描述，关键词，作者，字符集等。

#### \<head> 元素

在 \<head>元素中你可以插入脚本（scripts）, 样式文件（CSS），及各种meta信息。

可以添加在头部区域的元素标签为: \<title>, \<style>,  \<meta>, \<link>,   \<script>, \<noscript> 和 \<base>。

####  \<title> 元素:

- 定义了浏览器工具栏的标题
- 当网页添加到收藏夹时，显示在收藏夹中的标题
- 显示在搜索引擎结果页面的标题

#### HTML\<base>元素

<base> 标签描述了基本的链接地址/链接目标，该标签作为HTML文档中所有的链接标签的默认链接:

####  HTML\<link> 元素

 \<link> 标签定义了文档与外部资源之间的关系。

 \<link> 标签通常用于链接到样式表:

#### HTML\<style> 元素

\<style>标签定义了HTML文档的样式文件引用地址.

在\<style> 元素中你也可以直接添加样式来渲染 HTML 文档:

#### HTML\<meta> 元素

meta标签描述了一些基本的元数据。

\<meta> 标签提供了元数据.元数据也不显示在页面上，但会被浏览器解析。

META 元素通常用于指定网页的描述，关键词，文件的最后修改时间，作者，和其他元数据。

元数据可以使用于浏览器（如何显示内容或重新加载页面），搜索引擎（关键词），或其他Web服务。

\<meta> 一般放置于 \<head> 区域

#### HTML\<script> 元素

\<script>标签用于加载脚本文件，如： JavaScript。

\<script> 元素在以后的章节中会详细描述

## 第四章

### 图像

#### HTML 图像- 图像标签（ \<img>）和源属性（Src）

#### 语法

> ```html
> <img src="url" alt="some_text" width="304" height="228">
> 描述
> <img>是空标签，只包含属性，并且没有闭合标签
> src的值是图像的URL地址
> alt属性用来为图像定义一串预备的可替换文本
> height和width属性用于设置图像的高度和宽度
> ```

> **提示:** 指定图像的高度和宽度是一个很好的习惯。如果图像指定了高度宽度，页面加载时就会保留指定的尺寸。如果没有指定图片的大小，加载页面时有可能会破坏HTML页面的整体布局。

### 表格

#### 语法实例：

> ```html
> <table border="1">
>         <tr>
>         <th>Header 1</th>
>         <th>Header 2</th>
>     </tr>
>     <tr>
>         <td>row 1, cell 1</td>
>         <td>row 1, cell 2</td>
>     </tr>
>     <tr>
>         <td>row 2, cell 1</td>
>         <td>row 2, cell 2</td>
>     </tr>
> </table>
> 表格由<table> 标签来定义
> 表格的行由<tr>标签定义
> 单元格由<td>标签定义
> 单元格可以包含文本、图片、列表、段落、表单、水平线、表格等等。
> ```

#### 属性

1. border用来指定边框

![image-20220604124218464](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604124218464.png)

### 列表

#### 无序列表

无序列表是一个项目的列表，此列项目使用粗体圆点（典型的小黑圆圈）进行标记。 

无序列表使用 <ul> 标签

```html
<ul>
<li>Coffee</li>
<li>Milk</li>
</ul> 
```

#### 有序列表 

同样，有序列表也是一列项目，列表项目使用数字进行标记。 有序列表始于 <ol> 标签。每个列表项始于 <li> 标签。

列表项使用数字来标记。

```html
<ol>
<li>Coffee</li>
<li>Milk</li>
</ol> 
```

### 区块

HTML 可以通过 \<div> 和\<span>将元素组合起来。

![image-20220604124941354](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604124941354.png)

#### HTML \<div> 元素

HTML \<div> 元素是块级元素，它可用于组合其他 HTML 元素的容器。

 \<div> 元素没有特定的含义。除此之外，由于它属于块级元素，浏览器会在其前后显示折行。

#### HTML \<span> 元素

HTML \<span> 元素是内联元素，可用作文本的容器

\<span> 元素也没有特定的含义。 

## 第五章

### 表单和输入

#### 定义

HTML 表单用于收集用户的输入信息。

HTML 表单表示文档中的一个区域，此区域包含交互控件，将用户收集到的信息发送到 Web 服务器。

#### 语法

```html
<form action="">
First name: <input type="text" name="firstname"><br>
Last name: <input type="text" name="lastname">
</form>
```

#### 输入框的type属性

##### 文本域

```html
<input type="text"> 
```

##### 密码

```html
<input type="password">
```

##### 单选按钮

```html
<input type="radio">
```

##### 复选框

```html
<input type="checkbox">
```

##### 提交按钮

```html
<input type="submit">
```

#### from属性

##### action属性

action属性会对接受到的用户输入数据进行相关处理

##### method属性

用于定义表单数据的提交方式

### 框架

通过使用框架，你可以在同一个浏览器窗口中显示不止一个页面。

#### 语法

```html
<iframe src="URL"></iframe>
URL指向不同的网页
```

#### 属性

##### frameborder 属性

用于定义iframe表示是否显示边框。0为移除边框

## 第六章

### 字符实体

HTML 中的预留字符必须被替换为字符实体。

一些在键盘上找不到的字符也可以使用字符实体来替换。

#### HTML实体

在 HTML 中，某些字符是预留的。

在 HTML 中不能使用小于号（<）和大于号（>），这是因为浏览器会误认为它们是标签。

如果希望正确地显示预留字符，我们必须在 HTML 源代码中使用字符实体（character entities）。 字符实体类似这样：

![image-20220604131627763](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220604131627763.png)