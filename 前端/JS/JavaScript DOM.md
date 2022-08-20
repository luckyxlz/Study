# JavaScript DOM

## DOM概述

当网页被加载时，浏览器会创建页面的文档对象模型（**D**ocument **O**bject **M**odel）。

HTML **DOM** 模型被结构化为 **对象树** ：

通过这个对象模型，JavaScript 获得创建动态 HTML 的所有力量：

- JavaScript 能改变页面中的所有 HTML 元素

- JavaScript 能改变页面中的所有 HTML 属性
- JavaScript 能改变页面中的所有 CSS 样式
- JavaScript 能删除已有的 HTML 元素和属性
- JavaScript 能添加新的 HTML 元素和属性
- JavaScript 能对页面中所有已有的 HTML 事件作出反应
- JavaScript 能在页面中创建新的 HTML 事件



## DOM文档节点

#### 节点概述

节点Node，是构成我们网页的最基本的组成部分，网页中的每一个部分都可以称为是一个节点。

**html标签、属性、文本、注释、整个文档等都是一个节点。**

常用节点分为四类：

- 文档节点：整个HTML文档
- 元素节点：HTML文档中的HTML标签
- 属性节点：元素的属性
	- 属性节点（Attribute）表示的是标签中的一个一个的属性，这里要注意的是属性节点并非是元素节点的子节点，而是元素节点的一部分。可以通过元素节点来获取指定的属性节点。
- 文本节点：HTML标签中的文本内容



### DOM文档操作

#### 查找HTML元素

|                  方法                   |            描述             |
| :-------------------------------------: | :-------------------------: |
|      document.getElementById(*id*)      |  通过元素 id 来查找元素。   |
|  document.getElementsByTagName(*name*)  |   通过标签名来查找元素。    |
| document.getElementsByClassName(*name*) |    通过类名来查找元素。     |
|   document.querySelector(*CSS选择器*)   | 通过CSS选择器选择一个元素。 |
| document.querySelectorAll(*CSS选择器*)  | 通过CSS选择器选择多个元素。 |

#### 获取HTML的值

|                方法                |             描述              |
| :--------------------------------: | :---------------------------: |
|         元素节点.innerText         | 获取 HTML 元素的 inner Text。 |
|         元素节点.innerHTML         | 获取 HTML 元素的 inner HTML。 |
|           元素节点.属性            |   获取 HTML 元素的属性值。    |
| 元素节点.getAttribute(*attribute*) |   获取 HTML 元素的属性值。    |
|        元素节点.style.样式         | 获取 HTML 元素的行内样式值。  |

#### 改变HTML的值

| 方法                                        | 描述                         |
| :------------------------------------------ | ---------------------------- |
| 元素节点.innerText = *new text content*     | 改变元素的 inner Text。      |
| 元素节点.innerHTML = *new html content*     | 改变元素的 inner HTML。      |
| 元素节点.属性 = *new value*                 | 改变 HTML 元素的属性值。     |
| 元素节点.setAttribute(*attribute*, *value*) | 改变 HTML 元素的属性值。     |
| 元素节点.style.样式 = *new style*           | 改变 HTML 元素的行内样式值。 |

#### 修改HTML元素

| 方法                                  | 描述                               |
| :------------------------------------ | :--------------------------------- |
| document.createElement(*element*)     | 创建 HTML 元素节点。               |
| document.createAttribute(*attribute*) | 创建 HTML 属性节点。               |
| document.createTextNode(*text*)       | 创建 HTML 文本节点。               |
| 元素节点.removeChild(*element*)       | 删除 HTML 元素。                   |
| 元素节点.appendChild(*element*)       | 添加 HTML 元素。                   |
| 元素节点.replaceChild(*element*)      | 替换 HTML 元素。                   |
| 元素节点.insertBefore(*element*)      | 在指定的子节点前面插入新的子节点。 |

#### 查找HTML父子

| **方法**                        | **描述**                                                     |
| ------------------------------- | ------------------------------------------------------------ |
| 元素节点.parentNode             | 返回元素的父节点。                                           |
| 元素节点.parentElement          | 返回元素的父元素。                                           |
| 元素节点.childNodes             | 返回元素的一个子节点的数组（包含空白文本Text节点）。         |
| 元素节点.children               | 返回元素的一个子元素的集合（不包含空白文本Text节点）。       |
| 元素节点.firstChild             | 返回元素的第一个子节点（包含空白文本Text节点）。             |
| 元素节点.firstElementChild      | 返回元素的第一个子元素（不包含空白文本Text节点）。           |
| 元素节点.lastChild              | 返回元素的最后一个子节点（包含空白文本Text节点）。           |
| 元素节点.lastElementChild       | 返回元素的最后一个子元素（不包含空白文本Text节点）。         |
| 元素节点.previousSibling        | 返回某个元素紧接之前节点（包含空白文本Text节点）。           |
| 元素节点.previousElementSibling | 返回指定元素的前一个兄弟元素（相同节点树层中的前一个元素节点）。 |
| 元素节点.nextSibling            | 返回某个元素紧接之后节点（包含空白文本Text节点）。           |
| 元素节点.nextElementSibling     | 返回指定元素的后一个兄弟元素（相同节点树层中的下一个元素节点）。 |





## 文档事件

#### 事件概述

HTML事件可以触发浏览器中的行为，比方说当用户点击某个 HTML 元素时启动一段 JavaScript。

#### 窗口事件

由窗口触发该事件 (同样适用于 <body> 标签)：

| 属性      | 描述                                                         |
| --------- | ------------------------------------------------------------ |
| onblur    | 当窗口失去焦点时运行脚本。                                   |
| onfocus   | 当窗口获得焦点时运行脚本。                                   |
| onload    | 当文档加载之后运行脚本。                                     |
| onresize  | 当调整窗口大小时运行脚本。                                   |
| onstorage | 当 Web Storage 区域更新时（存储空间中的数据发生变化时）运行脚本。 |

#### 表单事件

表单事件在HTML表单中触发 (适用于所有 HTML 元素，但该HTML元素需在form表单内)：

| 属性      | 描述                           |
| --------- | ------------------------------ |
| onblur    | 当元素失去焦点时运行脚本。     |
| onfocus   | 当元素获得焦点时运行脚本。     |
| onchange  | 当元素改变时运行脚本。         |
| oninput   | 当元素获得用户输入时运行脚本。 |
| oninvalid | 当元素无效时运行脚本。         |
| onselect  | 当选取元素时运行脚本。         |
| onsubmit  | 当提交表单时运行脚本。         |

#### 键盘事件

通过键盘触发事件，类似用户的行为：

| 属性       | 描述                         |
| ---------- | ---------------------------- |
| onkeydown  | 当按下按键时运行脚本。       |
| onkeyup    | 当松开按键时运行脚本。       |
| onkeypress | 当按下并松开按键时运行脚本。 |

#### 鼠标事件

通过鼠标触发事件，类似用户的行为：

|属性	|描述|
|-----------|--------------|
|onclick	|当单击鼠标时运行脚本。
|ondblclick	|当双击鼠标时运行脚本。
|onmousedown	|当按下鼠标按钮时运行脚本。
|onmouseup	|当松开鼠标按钮时运行脚本。
|onmousemove	|当鼠标指针移动时运行脚本。
|onmouseover	|当鼠标指针移至元素之上时运行脚本，不可以阻止冒泡。
|onmouseout	|当鼠标指针移出元素时运行脚本，不可以阻止冒泡。
|onmouseenter	|当鼠标指针移至元素之上时运行脚本，可以阻止冒泡。
|onmouseleave	|当鼠标指针移出元素时运行脚本，可以阻止冒泡。
|onmousewheel	|当转动鼠标滚轮时运行脚本。
|onscroll	|当滚动元素的滚动条时运行脚本。

媒体事件
通过视频（videos），图像（images）或音频（audio） 触发该事件。

|属性	|描述
|-----------|--------------|
|onabort	|当发生中止事件时运行脚本。
|oncanplay	|当媒介能够开始播放但可能因缓冲而需要停止时运行脚本。
|oncanplaythrough  |当媒介能够无需因缓冲而停止即可播放至结尾时运行脚本。
|ondurationchange	|当媒介长度改变时运行脚本。
|onemptied	|当媒介资源元素突然为空时（网络错误、加载错误等）运行脚本。
|onended	|当媒介已抵达结尾时运行脚本。
|onerror	|当在元素加载期间发生错误时运行脚本。
|onloadeddata	|当加载媒介数据时运行脚本。
|onloadedmetadata	|当媒介元素的持续时间以及其它媒介数据已加载时运行脚本。
|onloadstart	|当浏览器开始加载媒介数据时运行脚本。
|onpause	|当媒介数据暂停时运行脚本。
|onplay	|当媒介数据将要开始播放时运行脚本。
|onplaying	|当媒介数据已开始播放时运行脚本。
|onprogress	|当浏览器正在取媒介数据时运行脚本。
|onratechange	|当媒介数据的播放速率改变时运行脚本。
|onreadystatechange	|当就绪状态（ready-state）改变时运行脚本。
|onseeked	|当媒介元素的定位属性不再为真且定位已结束时运行脚本。
|onseeking	|当媒介元素的定位属性为真且定位已开始时运行脚本。
|onstalled	|当取回媒介数据过程中（延迟）存在错误时运行脚本。
|onsuspend	|当浏览器已在取媒介数据但在取回整个媒介文件之前停止时运行脚本。
|ontimeupdate	|当媒介改变其播放位置时运行脚本。
|onvolumechange	|当媒介改变音量亦或当音量被设置为静音时运行脚本。
|onwaiting	|当媒介已停止播放但打算继续播放时运行脚本。

#### 其它事件

| 属性     | 描述                                    |
| -------- | --------------------------------------- |
| onshow   | 当 <menu> 元素在上下文显示时触发。      |
| ontoggle | 当用户打开或关闭 <details> 元素时触发。 |

#### 事件冒泡

事件的冒泡（Bubble）：所谓的冒泡指的就是事件的向上传导，当后代元素上的事件被触发时，其祖先元素的相同事件也会被触发，在开发中大部分情况冒泡都是有用的，如果不希望发生事件冒泡可以通过事件对象来取消冒泡。

#### 事件委派

我们希望只绑定一次事件，即可应用到多个的元素上，即使元素是后添加的，我们可以尝试将其绑定给元素的共同的祖先元素，也就是事件的委派。事件的委派，是指将事件统一绑定给元素的共同的祖先元素，这样当后代元素上的事件触发时，会一直冒泡到祖先元素，从而通过祖先元素的响应函数来处理事件。事件委派是利用了事件冒泡，通过委派可以减少事件绑定的次数，提高程序的性能。


#### 事件绑定

#### 事件传播

