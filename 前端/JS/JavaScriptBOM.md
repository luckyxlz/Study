# JavaScriptBOM

## BOM概述

浏览器对象模型（BOM）使 JavaScript 有能力与浏览器"对话"。

浏览器对象模型（BOM）可以使我们通过JS来操作浏览器，在BOM中为我们提供了一组对象，用来完成对浏览器的操作，常见的BOM对象如下：

- `Window`：代表的是整个浏览器的窗口，同时window也是网页中的全局对象
- `Navigator`：代表的当前浏览器的信息，通过该对象可以来识别不同的浏览器
- `Location`：代表当前浏览器的地址栏信息，通过Location可以获取地址栏信息，或者操作浏览器跳转页面
- `History`：代表浏览器的历史记录，可以通过该对象来操作浏览器的历史记录，由于隐私原因，该对象不能获取到具体的历史记录，只能操作浏览器向前或向后翻页，而且该操作只在当次访问时有效
- `Screen`：代表用户的屏幕的信息，通过该对象可以获取到用户的显示器的相关的信息

这些BOM对象在浏览器中都是作为window对象的属性保存的，可以通过window对象来使用，也可以直接使用。





## Window对象

### 弹出框

**JavaScript 有三种类型的弹出框：警告框、确认框和提示框。**

#### 警告框

如果要确保信息传递给用户，通常会使用警告框。当警告框弹出时，用户将需要单击“确定”来继续。

**语法**

```javascript
window.alert("sometext");
```

> 注意：window.alert() 方法可以不带 window 前缀来写。

#### 确认框

如果您希望用户验证或接受某个东西，则通常使用“确认”框。

当确认框弹出时，用户将不得不单击“确定”或“取消”来继续进行。

如果用户单击“确定”，该框返回 **true**。如果用户单击“取消”，该框返回 **false**。

**语法**

```javascript
window.confirm("sometext");
```

> 注意：window.confirm() 方法可以不带 window 前缀来编写。
> 提示框

#### 提示框

如果您希望用户在进入页面前输入值，通常会使用提示框。

当提示框弹出时，用户将不得不输入值后单击“确定”或点击“取消”来继续进行。

如果用户单击“确定”，该框返回输入值。如果用户单击“取消”，该框返回 NULL。

**语法**

```js
window.prompt("sometext","defaultText");
```

> window.prompt() 方法可以不带 window 前缀来编写。

### 定时事件

**JavaScript 可以在时间间隔内执行，这就是所谓的定时事件（ Timing Events）。**

window 对象允许以指定的时间间隔执行代码，这些时间间隔称为定时事件。

通过 JavaScript 使用的有两个关键的方法：

- setTimeout(function, milliseconds)

	在等待指定的毫秒数后执行函数。

- setInterval(function, milliseconds)

	等同于 setTimeout()，但持续重复执行该函数。


> setTimeout() 和 setInterval() 都属于 window 对象的方法。

#### 延时器

`setTimeout`() 方法：延时器

```js
window.setTimeout(function, milliseconds);
```

> 注意：window.setTimeout() 方法可以不带 window 前缀来编写。
>

- 第一个参数是要执行的函数。

- 第二个参数指示执行之前的毫秒数。

#### 定时器

`setInterval`() 方法：定时器

setInterval() 方法在每个给定的时间间隔重复给定的函数。

```js
window.setInterval(function, milliseconds);
```

> 注意：window.setInterval() 方法可以不带 window 前缀来写。
>

- 第一个参数是要执行的函数。
- 第二个参数每个执行之间的时间间隔的长度。





### 常用窗口属性

两个属性可用用于确定浏览器窗口的尺寸。

这两个属性都以像素返回尺寸：

- window.innerHeight - 浏览器窗口的内高度（以像素计）

- window.innerWidth - 浏览器窗口的内宽度（以像素计）

浏览器窗口（浏览器视口）不包括工具栏和滚动条。



### 其它窗口方法

#### window.open():打开新的窗口

**语法介绍**

```js
window.open(URL,name,specs,replace);
```

#### window.close():关闭当前窗口

**语法介绍**

```js
window.close();
```

#### window.moveTo():移动当前窗口

**语法介绍**

```js
window.moveTo(x,y);
```

#### window.resizeTo():调整当前窗口

**语法介绍**

```js
window.resizeTo(width, height);
```



## Navigator对象

Navigator代表的当前浏览器的信息，通过该对象可以来识别不同的浏览器，由于历史原因，Navigator对象中的大部分属性都已经不能帮助我们识别浏览器了，一般我们只会使用userAgent来判断浏览器的信息，userAgent是一个字符串，这个字符串中包含有用来描述浏览器信息的内容，不同的浏览器会有不同的userAgent，如下代码：

```js
var ua = navigator.userAgent;
console.log(ua);
```



## Location对象

Location对象中封装了浏览器的地址栏的信息，如果直接打印location，则可以获取到地址栏的信息（当前页面的完整路径）

### 常用属性

```js
console.log(location);          //输出location对象
console.log(location.href);     //输出当前地址的全路径地址
console.log(location.origin);   //输出当前地址的来源
console.log(location.protocol); //输出当前地址的协议
console.log(location.hostname); //输出当前地址的主机名
console.log(location.host);     //输出当前地址的主机
console.log(location.port);     //输出当前地址的端口号
console.log(location.pathname); //输出当前地址的路径部分
console.log(location.search);   //输出当前地址的?后边的参数部分
```

### 常用方法

assign()：用来跳转到其它的页面，作用和直接修改location一样

```js
location.assign("https://www.baidu.com");
```

reload()：用于重新加载当前页面，作用和刷新按钮一样，如果在方法中传递一个true，作为参数，则会强制清空缓存刷新页面

```js
location.reload(true);
```


replace()：可以使用一个新的页面替换当前页面，调用完毕也会跳转页面，它不会生成历史记录，不能使用回退按钮回退

```js
location.replace("https://www.baidu.com");
```



## History对象

History对象可以用来操作浏览器向前或向后翻页

### 常用属性

```js
console.log(history);           //输出history对象
console.log(history.length);    //可以获取到当成访问的链接数量
```

### 常用方法

back()：可以回退到上一个页面，作用和浏览器的回退按钮一样

```js
history.back();
```

forward()：可以跳转到下一个页面，作用和浏览器的前进按钮一样

```js
history.forward();
```


go()：可以用来跳转到指定的页面，它需要一个整数作为参数

- 1：表示向前跳转一个页面，相当于forward()
- 2：表示向前跳转两个页面
- -1：表示向后跳转一个页面，相当于back()
- -2：表示向后跳转两个页面

```js
history.go(-2);
```





## Screen对象

Screen 对象包含有关客户端显示屏幕的信息。

> 注意：没有应用于 screen 对象的公开标准，不过所有浏览器都支持该对象。
>

### Screen对象描述

每个 Window 对象的 screen 属性都引用一个 Screen 对象。Screen 对象中存放着有关显示浏览器屏幕的信息。JavaScript 程序将利用这些信息来优化它们的输出，以达到用户的显示要求。例如，一个程序可以根据显示器的尺寸选择使用大图像还是使用小图像，它还可以根据显示器的颜色深度选择使用 16 位色还是使用 8 位色的图形。另外，JavaScript 程序还能根据有关屏幕尺寸的信息将新的浏览器窗口定位在屏幕中间。

### Screen对象属性

|属性	|描述
|-------|--------|
|availHeight|返回显示屏幕的高度 (除 Windows 任务栏之外)。
|availWidth|返回显示屏幕的宽度 (除 Windows 任务栏之外)。
|bufferDepth|设置或返回调色板的比特深度。
|colorDepth|	返回目标设备或缓冲器上的调色板的比特深度。
|deviceXDPI|	返回显示屏幕的每英寸水平点数。
|deviceYDPI|	返回显示屏幕的每英寸垂直点数。
|fontSmoothingEnabled|	返回用户是否在显示控制面板中启用了字体平滑。
|height|	返回显示屏幕的高度。
|logicalXDPI|	返回显示屏幕每英寸的水平方向的常规点数。
|logicalYDPI|	返回显示屏幕每英寸的垂直方向的常规点数。
|pixelDepth|	返回显示屏幕的颜色分辨率（比特每像素）。
|updateInterval|	设置或返回屏幕的刷新率。
|width|	返回显示器屏幕的宽度。
