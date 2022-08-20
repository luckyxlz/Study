## 第一章

require是Node.js自带http模块，并且把它赋值给http变量。

##### http模快

1. createServer()函数：返回一个对象，这个对象有一个叫做 listen 的方法，这个方法有一个数值参数， 指定这个 HTTP 服务器监听的端口号。

##### npm使用介绍

1. 它是一个包管理工具，解决NodeJS代码部署上的很多问题

2. 使用场景

   - 允许用户从NPM服务器下载别人编写的第三方包到本地使用
   - 允许用户从NPM服务器下载并安装别人编写的命令行程序到本地使用
   - 允许用户将自己编写的包或命令行程序上传到NPM服务器供别人使用。

3. 在大陆下载包速度较慢，建议使用国内的淘宝镜像

   > ```
   > npm install -g cnpm --registry=https://registry.npmmirror.com
   > ```

4.安装模块

> npm install <Module Name>
>
> exemple : 安装Node.js.web框架模块 npm install express

##### 全局安装与本地安装	

1. 全局安装：使用时直接导入，不需要再安装
2. 本地安装：在使用时安装才可以导入，将包安装到当前工作目录中

##### 使用package.json

1. 位于模块的目录下，用于定义包的属性
2. 属性
   - name: 包名
   - version: 包的版本号
   - description: 包的描述
   - homepage: 包的官网url
   - author：包的作者姓名
   - contributors: 包的其他贡献者姓名
   - dependencies: 依赖包列表。如果依赖包没有安装，npm会自动将依赖包安装在node_module 目录下
   - repository: 包代码存放地方的类型，可以是git或svn，git可在github上
   - main：main字段指定了程序的主入口文件，require(moduleName)就会加载这个文件。这个字段的默认值是模块根目录下面的index.js
   - keywords：关键字

##### 卸载模块

> npm uninstall express

##### 更新模块

> npm update express

##### 搜索模块

> npm search express

##### npm常用命令

> - NPM提供了很多命令，例如`install`和`publish`，使用`npm help`可查看所有命令。
> - 使用`npm help <command>`可查看某条命令的详细帮助，例如`npm help install`。
> - 在`package.json`所在目录下使用`npm install . -g`可先在本地安装当前命令行程序，可用于发布前的本地测试。
> - 使用`npm update <package>`可以把当前目录下`node_modules`子目录里边的对应模块更新至最新版本。
> - 使用`npm update <package> -g`可以把全局安装的对应命令行程序更新至最新版。
> - 使用`npm cache clear`可以清空NPM本地缓存，用于对付使用相同版本号发布新版本代码的人。
> - 使用`npm unpublish <package>@<version>`可以撤销发布自己发布过的某个版本代码。



## 第二章

##### 使用变量

变量声明需要使用var关键字

> var x = 5

##### 回调函数

> Node.js异步编程的直接体现就是回调
>
> 异步编程依托于回调来实现，但不能说使用了回调后程序就异步化了。
>
> 回调函数在完成任务后就会被调用，Node 使用了大量的回调函数，Node 所有 API 都支持回调函数。
>
> 例如，我们可以一边读取文件，一边执行其他命令，在文件读取完成后，我们将文件内容作为回调函数的参数返回。这样在执行代码时就没有阻塞或等待文件 I/O 操作。这就大大提高了 Node.js 的性能，可以处理大量的并发请求。

##### Node.js事件循环

> Node.js 是单进程单线程应用程序，但是因为 V8 引擎提供的异步执行回调接口，通过这些接口可以处理大量的并发，所以性能非常高。
>
> Node.js 几乎每一个 API 都是支持回调函数的。
>
> Node.js 基本上所有的事件机制都是用设计模式中观察者模式实现。
>
> Node.js 单线程类似进入一个while(true)的事件循环，直到没有事件观察者退出，每个异步事件都生成一个事件观察者，如果有事件发生就调用该回调函数.

##### EventEmitter类

###### 方法：

- **addListener(event, listener)**
  为指定事件添加一个监听器到监听器数组的尾部。

- **on(event, listener)** 

  为指定事件注册一个监听器，接受一个字符串 event 和一个回调函数。

  `server.on('connection', function (stream) {  console.log('someone connected!'); });`

- **once(event, listener)**
  为指定事件注册一个单次监听器，即 监听器最多只会触发一次，触发后立刻解除该监听器。

  `server.once('connection', function (stream{
    console.log('Ah, we have our first user!');
  });`

- **removeListener(event, listener)**

  移除指定事件的某个监听器，监听器必须是该事件已经注册过的监听器。

  它接受两个参数，第一个是事件名称，第二个是回调函数名称。

  ```
  var callback = function(stream) {
    console.log('someone connected!');
  };
  server.on('connection', callback);
  // ...
  server.removeListener('connection', callback)
  ```

- **removeAllListeners([event])**
  移除所有事件的所有监听器， 如果指定事件，则移除指定事件的所有监听器。

- **setMaxListeners(n)**
  默认情况下， EventEmitters 如果你添加的监听器超过 10 个就会输出警告信息。 setMaxListeners 函数用于改变监听器的默认限制的数量

- **listeners(event)**
  返回指定事件的监听器数组。

- **emit(event, [arg1], [arg2], [...])**
  按监听器的顺序执行执行每个监听器，如果事件有注册监听返回 true，否则返回 false。

- **listenerCount(emitter, event)** 返回指定事件的监听器数量

  ```
  events.EventEmitter.listenerCount(emitter, eventName) //已废弃，不推荐
  events.emitter.listenerCount(eventName) //推荐
  ```

###### error事件

> EventEmitter 定义了一个特殊的事件 error，它包含了错误的语义，我们在遇到 异常的时候通常会触发 error 事件。
>
> 当 error 被触发时，EventEmitter 规定如果没有响 应的监听器，Node.js 会把它当作异常，退出程序并输出错误信息。

## 第三章

##### Node.js Buffer(缓冲区)

> JavaScript 语言自身只有字符串数据类型，没有二进制数据类型。
>
> 但在处理像TCP流或文件流时，必须使用到二进制数据。因此在 Node.js中，定义了一个 Buffer 类，该类用来创建一个专门存放二进制数据的缓存区。
>
> 在 Node.js 中，Buffer 类是随 Node 内核一起发布的核心库。Buffer 库为 Node.js 带来了一种存储原始数据的方法，可以让 Node.js 处理二进制数据，每当需要在 Node.js 中处理I/O操作中移动的数据时，就有可能使用 Buffer 库。原始数据存储在 Buffer 类的实例中。一个 Buffer 类似于一个整数数组，但它对应于 V8 堆内存之外的一块原始内存。

> - **Buffer.alloc(size[, fill[, encoding]])：** 返回一个指定大小的 Buffer 实例，如果没有设置 fill，则默认填满 0
> - **Buffer.allocUnsafe(size)：** 返回一个指定大小的 Buffer 实例，但是它不会被初始化，所以它可能包含敏感的数据
> - **Buffer.allocUnsafeSlow(size)**
> - **Buffer.from(array)：** 返回一个被 array 的值初始化的新的 Buffer 实例（传入的 array 的元素只能是数字，不然就会自动被 0 覆盖）
> - **Buffer.from(arrayBuffer[, byteOffset[, length]])：** 返回一个新建的与给定的 ArrayBuffer 共享同一内存的 Buffer。
> - **Buffer.from(buffer)：** 复制传入的 Buffer 实例的数据，并返回一个新的 Buffer 实例
> - **Buffer.from(string[, encoding])：** 返回一个被 string 的值初始化的新的 Buffer 实例

###### 写入数据

​	语法

> ```js
> buf.write(string[, offset[, length]][, encoding])
> ```
>
> - string - 写入缓冲区的字符串。
> - offset - 缓冲区开始写入的索引值，默认为 0 
> - length - 写入的字节数，默认buffer.length
> - encoding - 使用的编码。默认为 'utf8' 
>   

返回值

返回实际写入的大小。如果buffer空间不足，则只会写入部分字符串

###### 读取数据

语法

> ```
> buf.toString([encoding[, start[, end]]])
> ```
>
> -  encoding - 使用的编码。默认为 'utf8' 。
> -  start - 指定开始读取的索引位置，默认为 0。
> -  end - 结束位置，默认为缓冲区的末尾。

返回值：解码缓冲区数据并使用指定的编码返回字符串

###### 将Buffer转化为JSON对象

语法：

> ```
> buf.toJSON()
> ```

当字符串化一个 Buffer 实例时，JSON.stringify() 会隐式地调用该 toJSON()。

返回值：返回JSON对象

###### 缓冲区合并

语法

> ```
> Buffer.concat(list[, totalLength])
> ```
>
> - list - 用于合并的 Buffer 对象数组列表。
> - totalLength - 指定合并后Buffer对象的总长		度。
>
> 

返回值：返回一个多个成员合并的新Buffer对象

###### 缓冲区比较

语法

> ```
> buf.compare(otherBuffer);
> ```
>
> - otherBuffer - 与 buf 对象比较的另外一个 		Buffer 对象。 

返回值：返回一个数字，表示buf在otherBuffer之前，之后或相同

###### 拷贝缓冲区

语法

> ```
> buf.copy(targetBuffer[, targetStart[, sourceStart[, sourceEnd]]])
> ```
>
> - **targetBuffer** -  要拷贝的 Buffer 对象。
> - **targetStart** -  数字, 可选, 默认: 0
> - **sourceStart** -  数字, 可选, 默认: 0
> - **sourceEnd** -  数字, 可选, 默认: buffer.length

###### 缓冲区裁剪

> ```
> buf.slice([start[, end]])
> ```
>
> - **start** -   数字, 可选, 默认: 0
> - **end** -   数字, 可选, 默认: buffer.length

返回值：返回一个新的缓冲区，他和旧缓冲区指向同一块内存，但是从索引start到end的位置剪切

###### 缓冲区长度

语法

> buf.length;

返回值：返回 Buffer 对象所占据的内存长度

> 注意这未必是 buffer 里面内容的大小。length 是 buffer 对象所分配的内存数，它不会随着这个 buffer 对象内容的改变而改变。

## 第四章

### Stream

#### 概念及定义

Stream 是一个抽象接口，Node 中有很多对象实现了这个接口。例如，对http 服务器发起请求的request 对象就是一个 Stream，还有stdout（标准输出）。

#### 四种流类型

- **Readable** - 可读操作。
- **Writable** - 可写操作。
- **Duplex** - 可读可写操作.
- **Transform** - 操作被写入数据，然后读出结果。

#### 流的事件

所有的 Stream 对象都是 EventEmitter 的实例。常用的事件有：

- **data** - 当有数据可读时触发。
- **end** - 没有更多的数据可读时触发。
- **error** - 在接收和写入过程中发生错误时触发。
- **finish** - 所有数据已被写入到底层系统时触发。

#### 从流中读取数据

例子

```js
var fs = require("fs");
var data = '';

// 创建可读流
var readerStream = fs.createReadStream('input.txt');

// 设置编码为 utf8。
readerStream.setEncoding('UTF8');

// 处理流事件 --> data, end, and error
readerStream.on('data', function(chunk) {
   data += chunk;
});

readerStream.on('end',function(){
   console.log(data);
});

readerStream.on('error', function(err){
   console.log(err.stack);
});

console.log("程序执行完毕");
```

#### 写入流

例子

```js
var fs = require("fs");
var data = '菜鸟教程官网地址：www.runoob.com';

// 创建一个可以写入的流，写入到文件 output.txt 中
var writerStream = fs.createWriteStream('output.txt');

// 使用 utf8 编码写入数据
writerStream.write(data,'UTF8');

// 标记文件末尾
writerStream.end();

// 处理流事件 --> finish、error
writerStream.on('finish', function() {
    console.log("写入完成。");
});

writerStream.on('error', function(err){
   console.log(err.stack);
});

console.log("程序执行完毕");
```

### 管道流

#### 概念及定义

管道提供了一个输出流到输入流的机制。通常我们用于从一个流中获取数据并将数据传递到另外一个流中。

```js
var fs = require("fs");

// 创建一个可读流
var readerStream = fs.createReadStream('input.txt');

// 创建一个可写流
var writerStream = fs.createWriteStream('output.txt');

// 管道读写操作
// 读取 input.txt 文件内容，并将内容写入到 output.txt 文件中
readerStream.pipe(writerStream);

console.log("程序执行完毕");
```

### 链式流

#### 概念及定义

链式是通过连接输出流到另外一个流并创建多个流操作链的机制。链式流一般用于管道操作。

接下来我们就是用管道和链式来压缩和解压文件。

```js
var fs = require("fs");
var zlib = require('zlib');

// 压缩 input.txt 文件为 input.txt.gz
fs.createReadStream('input.txt')
  .pipe(zlib.createGzip())
  .pipe(fs.createWriteStream('input.txt.gz'));
  
console.log("文件压缩完成。");
```

这里通过了链式流既创建了压缩文件，又将文件输出到了另一个文件

### 模块系统

#### 概念及定义

为了让Node.js的文件可以相互调用，Node.js提供了一个简单的模块系统。 

模块是Node.js 应用程序的基本组成部分，文件和模块是一一对应的。换言之，一个 Node.js 文件就是一个模块，这个文件可能是JavaScript 代码、JSON 或者编译过的C/C++ 扩展。

> Node.js 提供了 exports 和 require 两个对象，其中 exports 是模块公开的接口，require 用于从外部获取一个模块的接口，即所获取模块的 exports 对象。

#### 引入模块

在Node.js中引入一个模块使用require()，引入的模块需要又一个export 的对象，作为模块公开的接口

### 函数

在 JavaScript中，一个函数可以作为另一个函数的参数。我们可以先定义一个函数，然后传递，也可以在传递参数的地方直接定义函数。

例子

```js
function say(word) {
  console.log(word);
}

function execute(someFunction, value) {
  someFunction(value);
}

execute(say, "Hello");

```

这里的someFunction作为形参，say作为实参，同时say也是一个函数。

#### 匿名函数

例子

```js
function execute(someFunction, value) {
  someFunction(value);
}

execute(function(word){ console.log(word) }, "Hello");
```

这里直接将函数体写到excute函数中，这里不需要给函数命名，但同时也失去了多次调用的功能

#### 路由

我们要为路由提供请求的 URL 和其他需要的 GET 及 POST 参数，随后路由需要根据这些数据来执行相应的代码。因此，我们需要查看 HTTP 请求，从中提取出请求的 URL 以及 GET/POST 参数。这一功能应当属于路由还是服务器（甚至作为一个模块自身的功能）确实值得探讨，但这里暂定其为我们的HTTP服务器的功能。

##### 解析模块

1. url模块
2. querystring模块

### 全局对象

#### 概念及定义

它及其所有属性都可以在程序的任何地方访问，即全局变量。在浏览器 JavaScript 中，通常 window 是全局对象， 而 Node.js 中的全局对象是 global，所有全局变量（除了 global 本身以外）都是 global 对象的属性。

#### 全局对象与全局变量

global 最根本的作用是作为全局变量的宿主。按照 ECMAScript 的定义，满足以下条 件的变量是全局变量：

- 在最外层定义的变量；
- 全局对象的属性；
- 隐式定义的变量（未定义直接赋值的变量）。

当你定义一个全局变量时，这个变量同时也会成为全局对象的属性，反之亦然。需要注 意的是，在 Node.js 中你不可能在最外层定义变量，因为所有用户代码都是属于当前模块的， 而模块本身不是最外层上下文。

> **注意：** 最好不要使用 var 定义变量以避免引入全局变量，因为全局变量会污染命名空间，提高代码的耦合风险。

#### __filename

__filename 表示当前正在执行的脚本的文件名。它将输出文件所在位置的绝对路径，且和命令行参数所指定的文件名不一定相同。 如果在模块中，返回的值是模块文件的路径。

#### __dirname

 __dirname 表示当前执行脚本所在的目录。

#### setTimeout(cb, ms)

 setTimeout(cb, ms) 全局函数在指定的毫秒(ms)数后执行指定函数(cb)。：setTimeout() 只执行一次指定函数。返回一个代表定时器的句柄值。

#### clearTimeout(t)

clearTimeout( t ) 全局函数用于停止一个之前通过 setTimeout() 创建的定时器。 参数 **t** 是通过 setTimeout() 函数创建的定时器。

#### setInterval(cb, ms)

 setInterval(cb, ms) 全局函数在指定的毫秒(ms)数后执行指定函数(cb)。

返回一个代表定时器的句柄值。可以使用 clearInterval(t) 函数来清除定时器。

setInterval() 方法会不停地调用函数，直到 clearInterval() 被调用或窗口被关闭。

#### console

console 用于提供控制台标准输出

- **console.log**([data]\[, ...])

  向标准输出流打印字符并以换行符结束。该方法接收若干 个参数，如果只有一个参数，则输出这个参数的字符串形式。如果有多个参数，则以类似于C 语言 printf() 命令的格式输出。 

- **console.info**([data]\[, ...]) 

  该命令的作用是返回信息性消息，这个命令与console.log差别并不大，除了在chrome中只会输出文字外，其余的会显示一个蓝色的惊叹号。

- **console.error**([data]\[, ...])
  输出错误消息的。控制台在出现错误时会显示是红色的叉子。

- **console.warn**([data]\[, ...])
  输出警告消息。控制台出现有黄色的惊叹号

- **console.dir**(obj[, options])
  用来对一个对象进行检查（inspect），并以易于阅读和打印的格式显示。

-  **console.time**(label) 输出时间，表示计时开始。

-  **console.timeEnd**(label) 结束时间，表示计时结束。

- **console.trace**(message[, ...])
  当前执行的代码在堆栈中的调用路径，这个测试函数运行很有帮助，只要给想测试的函数里面加入 console.trace 就行了。

- **console.assert**(value[, message]\[, ...]) 用于判断某个表达式或变量是否为真，接收两个参数，第一个参数是表达式，第二个参数是字符串。只有当第一个参数为false，才会输出第二个参数，否则不会有任何结果。

  

#### process

它是一个全局变量，即global对象的属性。它用于描述当前Node.js 进程状态的对象，提供了一个与操作系统的简单接口。通常在你写本地命令行程序的时候，少不了要 和它打交道。下面将会介绍 process 对象的一些最常用的成员方法。

1. **exit**
   当进程准备退出时触发。
2. **beforeExit** 当 node 清空事件循环，并且没有其他安排时触发这个事件。通常来说，当没有进程安排时 node 退出，但是 'beforeExit' 的监听器可以异步调用，这样 node 就会继续执行。
3. **uncaughtException** 当一个异常冒泡回到事件循环，触发这个事件。如果给异常添加了监视器，默认的操作（打印堆栈跟踪信息并退出）就不会发生。
4. **Signal 事件**
   当进程接收到信号时就触发。信号列表详见标准的 POSIX 信号名，如 SIGINT、SIGUSR1 等。

##### 退出状态码

![image-20220527211302424](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220527211302424.png)

##### process属性

![image-20220527211458566](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220527211458566.png)

##### proces的方法

![image-20220527212002643](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220527212002643.png)

## 第五章

### 常用工具

#### Util模块

##### 定义

util是一个Node.js模块，提供常用函数的集合，用于弥补核心JavaScript的功能过于精简的不足

### 文件系统

#### js文件系统定义

提供一组类似UNIX标准的文件操作API。

导入

```js
var fs = require("fs")	
```

#### 异步与同步

js文件系统模块中的方法均有异步和同步版本，异步方法函数最后一个参数作为回调函数，回调函数 的第一个参数包含了错误信息

#### 打开文件

语法

> ```js
> fs.open(path,flags[,mode],callback)
> ```
>
> 参数
>
> - path-文件路径
> - flags-文件打开的行为
> - mode-设置文件模式，文件创建默认权限为可读可写
> - callback-回调函数，带有两个参数：callback(err,fd)

flags参数可以是以下值

![image-20220528141722883](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220528141722883.png)

#### 获取文件信息

语法

> ```js
> fs.stat(path, callback)
> ```
>
> 参数
>
> - path-文件路径
> - callback-回调函数，带有两个参数如：(err, stats),stats是fs.Stats对象

stats类中的方法有

![image-20220528142312238](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220528142312238.png)

#### 写入文件

语法

> ```js
> fs.writeFile(file, data[,options], callback)
> ```
>
> 参数
>
> - file-文件名或文件描述符
> - data-要写入文件的数据，可以是String或Buffer
> - options-该参数是一个对象，包含(encoding, mode, flag)。默认编码为utf-8，模式为0666，flag为‘w’；
> - callback-回调函数，只包含错误信息参数，在写入失败时返回

> 默认是w模式，如果文件存在，会覆盖旧的内容

#### 读取文件

语法

> ```js
> fs.read(fd, buffer, offset, length, position, callback)
> ```
>
> 参数
>
> - fd-通过fs.open()方法返回的文件描述符
> - buffer-数据写入的缓冲区
> - offest-缓冲区写入的写入偏移量
> - length-要从文件读取的字节数
> - position-文件读取的起始位置，如果position的值为null，则会从该当前文件指针的位置读取
> - callback-回调函数，有三个参数err，bytesRead，Buffer，err为错误信息，bytesRead表示读取的字节数，buffer为缓冲区对象

#### 关闭文件

语法

> ```js
> fs.close(fd, callback)
> ```
>
> 参数
>
> - fd-通过fs.open()方法返回的文件描述符
> - callback-回调函数，没有参数

#### 截取文件

语法

> ```js
> fs.ftruncate(fd, len, callback)
> ```
>
> 参数
>
> - fd-通过fs.open()方法返回文件的描述符
> - len-文件内容的截取长度
> - callback-回调函数，没有参数

#### 删除文件

语法

> ```js
> fs.unlink(path, callback)
> ```
>
> 参数
>
> - path-文件路径
> - callback-回调函数，没有参数

#### 创建目录

语法

> ```js
> fs.mkdir(path[,options],callback)
> ```
>
> 参数
>
> - path-文件路径
> - options参数
>   - recursive-是否以递归的方式创建目录，默认为false
>   - mode-设置目录权限，默认为0777
> - callback-回调函数

#### 读取目录

语法

> ```js
> fs.readdir(path, callback)
> ```
>
> 参数
>
> - path-文件路径
> - callback-回调函数，回调函数带有两个参数err，files，err为错误信息，files为目录下的文件数组列表

#### 删除目录

语法

> ```js
> fs.rmdir(path, callback)
> ```
>
> 参数
>
> - path-文件路径
> - callback-回调函数，没有参数

### GET/POST请求

> 在很多场景中，我们的服务器都需要跟用户的浏览器打交道，如表单提交。
>
> 表单提交到服务器一般都使用 GET/POST 请求。

#### 获取GET请求内容

由于GET请求直接被嵌入在路径中，URL是完整的请求路径，包括了?后面的部分，因此你可以手动解析后面的内容作为GET请求的参数。

> node.js 中 url 模块中的 parse 函数提供了这个功能

#### 获取 POST 请求内容

POST 请求的内容全部的都在请求体中，http.ServerRequest 并没有一个属性内容为请求体，原因是等待请求体传输可能是一件耗时的工作。

## 第六章

### 工具模块

#### OS模块

定义：提供基本的系统操作函数

#### Path模块

定义：提供了处理和转化文件路径的工具

#### Net模块

定义：用于底层的网络通信，提供了服务端和客户端的操作

#### DNS模块

定义：用于解析域名

#### Domain模块

定义：简化异步代码的异常处理，可以捕捉处理try catch无法捕捉的。

### web模块

#### 什么是 Web 服务器？

Web服务器一般指网站服务器，是指驻留于因特网上某种类型计算机的程序，Web服务器的基本功能就是提供Web信息浏览服务。它只需支持HTTP协议、HTML文档格式及URL，与客户端的网络浏览器配合。

大多数 web 服务器都支持服务端的脚本语言（php、python、ruby）等，并通过脚本语言从数据库获取数据，将结果返回给客户端浏览器。

目前最主流的三个Web服务器是Apache、Nginx、IIS。

#### web应用结构

<img src="C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220528150619896.png" alt="image-20220528150619896" style="zoom: 200%;" />

#### 使用Node创建web服务器

Node.js提供了http模块，http模块主要用于搭建HTTP服务端和客户端。使用HTTP服务器或客户端功能必须调用http模块

例子



> Node.web服务端代码
>
> ```js
> 
> var http = require('http');
> var fs = require('fs');
> var url = require('url');
> 
> 
> // 创建服务器
> http.createServer( function (request, response) {  
>    // 解析请求，包括文件名
>    var pathname = url.parse(request.url).pathname;
> 
>    // 输出请求的文件名
>    console.log("Request for " + pathname + " received.");
> 
>    // 从文件系统中读取请求的文件内容
>    fs.readFile(pathname.substr(1), function (err, data) {
>       if (err) {
>          console.log(err);
>          // HTTP 状态码: 404 : NOT FOUND
>          // Content Type: text/html
>          response.writeHead(404, {'Content-Type': 'text/html'});
>       }else{             
>          // HTTP 状态码: 200 : OK
>          // Content Type: text/html
>          response.writeHead(200, {'Content-Type': 'text/html'});    
>          
>          // 响应文件内容
>          response.write(data.toString());        
>       }
>       //  发送响应数据
>       response.end();
>    });   
> }).listen(8080);
> 
> // 控制台会输出以下信息
> console.log('Server running at http://127.0.0.1:8080/');
> ```
>
> index文件
>
> ```html
> <!DOCTYPE html>
> <html>
> <head>
> <meta charset="utf-8">
> <title>菜鸟教程(runoob.com)</title>
> </head>
> <body>
>     <h1>我的第一个标题</h1>
>     <p>我的第一个段落。</p>
> </body>
> </html>
> 
> ```
>
> 



![image-20220528151411711](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220528151411711.png)

#### Express框架

定义：Express是一个简介而灵活的node.js Web应用框架，提供了一些列强大特性帮助你创建各种web应用，和丰富的HTTP工具。

Express 框架核心特性：

- 可以设置中间件来响应 HTTP 请求。
- 定义了路由表用于执行不同的 HTTP 请求动作。 
- 可以通过向模板传递参数来动态渲染 HTML 页面。

![image-20220528152312698](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220528152312698.png)

##### 请求和响应

Express应该使用回调函数的参数，request和response对象来处理请求和相应的数据

###### Request对象

request对象表示HTTP请求，包括了请求查询字符串，参数，内容，HTTP头部等属性。

![image-20220528153734482](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220528153734482.png)

###### Respone对象

respone对象表示HTTP响应，即在接收到请求时向客户端发送的HTTP响应数据。

![image-20220528154011125](C:\Users\Lucky\AppData\Roaming\Typora\typora-user-images\image-20220528154011125.png)

##### 路由

定义：路由决定了由谁(指定脚本)去响应客户端请求。

> 语法
>
> ```js
> 
> var express = require('express');
> var app = express();
>  
> //  主页输出 "Hello World"
> app.get('/', function (req, res) {
>    console.log("主页 GET 请求");
>    res.send('Hello GET');
> })
>  
>  
> //  POST 请求
> app.post('/', function (req, res) {
>    console.log("主页 POST 请求");
>    res.send('Hello POST');
> })
>  
> //  /del_user 页面响应
> app.get('/del_user', function (req, res) {
>    console.log("/del_user 响应 DELETE 请求");
>    res.send('删除页面');
> })
>  
> //  /list_user 页面 GET 请求
> app.get('/list_user', function (req, res) {
>    console.log("/list_user GET 请求");
>    res.send('用户列表页面');
> })
>  
> // 对页面 abcd, abxcd, ab123cd, 等响应 GET 请求
> app.get('/ab*cd', function(req, res) {   
>    console.log("/ab*cd GET 请求");
>    res.send('正则匹配');
> })
>  
>  
> var server = app.listen(8081, function () {
>  
>   var host = server.address().address
>   var port = server.address().port
>  
>   console.log("应用实例，访问地址为 http://%s:%s", host, port)
>  
> })
> ```

##### 静态文件

Express 提供了内置的中间件 **express.static**  来设置静态文件如：图片， CSS, JavaScript 等。你可以使用 **express.static**  中间件来设置静态文件路径。例如，如果你将图片， CSS, JavaScript 文件放在 public 目录下，你可以这么写：

> ```js
> app.use('/public', express.static('public'));
> ```

这样便可以在public目录中直接访问文件

##### GET方法

> index.html文件代码
>
> ```html
> <html>
> <body>
> <form action="http://127.0.0.1:8081/process_get" method="GET">
> First Name: <input type="text" name="first_name">  <br>
>  
> Last Name: <input type="text" name="last_name">
> <input type="submit" value="Submit">
> </form>
> </body>
> ```
>
> server.js代码
>
> ```js
> 
> var express = require('express');
> var app = express();
>  
> app.use('/public', express.static('public'));
>  
> app.get('/index.html', function (req, res) {
>    res.sendFile( __dirname + "/" + "index.html" );
> })
>  
> app.get('/process_get', function (req, res) {
>  
>    // 输出 JSON 格式
>    var response = {
>        "first_name":req.query.first_name,
>        "last_name":req.query.last_name
>    };
>    console.log(response);
>    res.end(JSON.stringify(response));
> })
>  
> var server = app.listen(8081, function () {
>  
>   var host = server.address().address
>   var port = server.address().port
>  
>   console.log("应用实例，访问地址为 http://%s:%s", host, port)
>  
> })
> ```

POST方法

> index.html代码
>
> ```html
> 
> <html>
> <body>
> <form action="http://127.0.0.1:8081/process_post" method="POST">
> First Name: <input type="text" name="first_name">  <br>
>  
> Last Name: <input type="text" name="last_name">
> <input type="submit" value="Submit">
> </form>
> </body>
> </html>
> ```
>
> server.js文件代码
>
> ```js
> 
> var express = require('express');
> var app = express();
> var bodyParser = require('body-parser');
>  
> // 创建 application/x-www-form-urlencoded 编码解析
> var urlencodedParser = bodyParser.urlencoded({ extended: false })
>  
> app.use('/public', express.static('public'));
>  
> app.get('/index.html', function (req, res) {
>    res.sendFile( __dirname + "/" + "index.html" );
> })
>  
> app.post('/process_post', urlencodedParser, function (req, res) {
>  
>    // 输出 JSON 格式
>    var response = {
>        "first_name":req.body.first_name,
>        "last_name":req.body.last_name
>    };
>    console.log(response);
>    res.end(JSON.stringify(response));
> })
>  
> var server = app.listen(8081, function () {
>  
>   var host = server.address().address
>   var port = server.address().port
>  
>   console.log("应用实例，访问地址为 http://%s:%s", host, port)
>  
> })
> ```
>
> 

##### 文件上传	

> index.html代码
>
> ```html
> 
> <html>
> <head>
> <title>文件上传表单</title>
> </head>
> <body>
> <h3>文件上传：</h3>
> 选择一个文件上传: <br />
> <form action="/file_upload" method="post" enctype="multipart/form-data">
> <input type="file" name="image" size="50" />
> <br />
> <input type="submit" value="上传文件" />
> </form>
> </body>
> </html>
> ```
>
> server.js代码
>
> ```js
> 
> var express = require('express');
> var app = express();
> var fs = require("fs");
>  
> var bodyParser = require('body-parser');
> var multer  = require('multer');
>  
> app.use('/public', express.static('public'));
> app.use(bodyParser.urlencoded({ extended: false }));
> app.use(multer({ dest: '/tmp/'}).array('image'));
>  
> app.get('/index.html', function (req, res) {
>    res.sendFile( __dirname + "/" + "index.html" );
> })
>  
> app.post('/file_upload', function (req, res) {
>  
>    console.log(req.files[0]);  // 上传的文件信息
>  
>    var des_file = __dirname + "/" + req.files[0].originalname;
>    fs.readFile( req.files[0].path, function (err, data) {
>         fs.writeFile(des_file, data, function (err) {
>          if( err ){
>               console.log( err );
>          }else{
>                response = {
>                    message:'File uploaded successfully', 
>                    filename:req.files[0].originalname
>               };
>           }
>           console.log( response );
>           res.end( JSON.stringify( response ) );
>        });
>    });
> })
>  
> var server = app.listen(8081, function () {
>  
>   var host = server.address().address
>   var port = server.address().port
>  
>   console.log("应用实例，访问地址为 http://%s:%s", host, port)
>  
> })
> 
> ```
>
> 

##### Cookie管理

我们可以使用中间件向Node.js服务器发送cookie信息，以下代码输出了客户端发送的cookie信息