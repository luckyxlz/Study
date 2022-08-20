# IO流

### IO流的分类

根据数据的流向分为：输入流和输出流

- 输入流：把数据从**其他设备**上读取到**内存**上的流
- 输出流：把数据从**内存**中写到**其他设备**上的流

根据操作数据单位的不同分为：字节流和字符流

- 字节流：以字节为单位，读写数据的流
- 字符流：以字符为单位，读写数据的流

| 抽象基类 | 输入流                  | 输出流                   |
| -------- | ----------------------- | ------------------------ |
| 字节流   | 字节输入流(InputStream) | 字节输出流(OutputStream) |
| 字符流   | 字符输出流(Reader)      | 字符输出流(Writer)       |



## 字节流

### OutputStream

OutputStream是所有字节输出的顶层父类，该父类提供如下公共方法：

- public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
- public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
- public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
- public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
- public abstract void write(int b) ：将指定的字节输出流。

> tips：close方法，当完成流的操作时，必须调用此方法，释放系统资源









### FIleOutputStream

- FileOutputStream的构造方法如下：

  - public FileOutputStream(File file)：创建文件输出流以写入由指定的 File对象表示的文件。

  - public FileOutputStream(String name)： 创建文件输出流以指定的名称写入文件。

> tips：当创建一个流对象时，需要指定一个文件路径，如果该文件以及存在则会清空文件中的数据，如果不存在则创建一个新的文件；

经过以上的演示，每次程序运行，创建输出流对象，都会清空目标文件中的数据。如何保留目标文件中数据，还能继续添加新数据呢？

- public FileOutputStream(File file, boolean append)： 创建文件输出流以写入由指定的 File对象表示的文件。
- public FileOutputStream(String name, boolean append)： 创建文件输出流以指定的名称写入文件。

> - 回车符`\r`和换行符`\n`
>   - 回车符：回到一行的开头（return）。
>   - 换行符：下一行（newline）。
> - 系统中的换行：
>   - Windows系统里，每行结尾是 `回车+换行` ，即`\r\n`；
>   - Unix系统里，每行结尾只有 `换行` ，即`\n`；
>   - Mac系统里，每行结尾是 `回车` ，即`\r`。从 Mac OS X开始与Linux统一。







### InputStream

`java.io.InputStream` 抽象类是表示字节输入流的所有类的超类，可以读取字节信息到内存中。它定义了字节输入流的基本共性功能方法。

- `public void close()` ：关闭此输入流并释放与此流相关联的任何系统资源。
- `public abstract int read()`： 从输入流读取数据的下一个字节。
- `public int read(byte[] b)`： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

> tips：close方法，当完成流的操作时，必须调用此方法，释放系统资源。









### FIleInoutStream

`java.io.FileInputStream `类是文件输入流，从文件中读取字节。

#### 构造方法

- `FileInputStream(File file)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。
- `FileInputStream(String name)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。

当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出`FileNotFoundException` 。

#### 读取字节数据

- **读取字节**：`read`方法，每次可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回`-1`。
- **使用字节数组读取**：`read(byte[] b)`，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回`-1` 。













## 字符流

#### 简介：

一个字符都是由多个字节组成的，为此我们不能再基于字节的操作单位来操作文本文件了，因为这样太过麻烦，我们希望基于字符来操作文件，一次操作读取一个“字符”而不是一个“字节”，这样在操作文本文件时非常便捷；





### Reader

java.io.Reader抽象类是表示用于读取字符流的所有类的超类，可以读取字符信息到内存中。它定义了字符输入流的基本共性功能方法。

- `public void close()` ：关闭此流并释放与此流相关联的任何系统资源。
- `public int read()`： 从输入流读取一个字符。
- `public int read(char[] cbuf)`： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。



### FileReader

#### 简介

`java.io.FileReader `类是读取字符文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。

> tips：
>
> - 字符编码：字节与字符的对应规则。Windows系统的中文编码默认是GBK编码表。idea中默认是UTF-8
> - 字节缓冲区：一个字节数组，用来临时存储字节数据。

#### 构造方法

- `FileReader(File file)`： 创建一个新的 FileReader ，给定要读取的File对象。
- `FileReader(String fileName)`： 创建一个新的 FileReader ，给定要读取的文件的名称。

#### 读取字符数据

1. **读取字符**：`read`方法，每次可以读取一个字符的数据，提升为int类型，读取到文件末尾，返回`-1`，循环读取
2. **使用字符数组读取**：`read(char[] cbuf)`，每次读取b的长度个字符到数组中，返回读取到的有效字符个数，读取到末尾时，返回`-1` 





### Writer

#### 简介

`java.io.Writer `抽象类是表示用于写出字符流的所有类的超类，将指定的字符信息写出到目的地。它定义了字节输出流的基本共性功能方法。

- `void write(int c)` 写入单个字符。
- `void write(char[] cbuf)` 写入字符数组。
- `abstract void write(char[] cbuf, int off, int len)` 写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
- `void write(String str)` 写入字符串。
- `void write(String str, int off, int len)` 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
- `void flush()` 刷新该流的缓冲。
- `void close()` 关闭此流，但要先刷新它。





### FileWriter

#### 简介

`java.io.FileWriter `类是写出字符到文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。

#### 构造方法

- `FileWriter(File file)`： 创建一个新的 FileWriter，给定要读取的File对象。
- `FileWriter(String fileName)`： 创建一个新的 FileWriter，给定要读取的文件的名称。

#### 写入字符数据

**写出字符**：`write(int b)` 方法，每次可以写出一个字符数据

**写出字符数组** ：`write(char[] cbuf)` 和 `write(char[] cbuf, int off, int len)` ，每次可以写出字符数组中的数据

**写出字符串**：`write(String str)` 和 `write(String str, int off, int len)` ，每次可以写出字符串中的数据，更为方便

#### 关闭和刷新

因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无法继续写出数据的。如果我们既想写出数据，又想继续使用流，就需要flush 方法了。

- `flush` ：刷新缓冲区，流对象可以继续使用。
- `close `：先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。



> tips：字符流，只能操作文本文件，不能操作图片，视频等非文本文件。当我们单纯读或者写文本文件时 使用字符流 其他情况使用字节流











## 属性集

### Properties

#### 构造方法

`public Properties()` :创建一个空的属性列表

#### 基本的存储方法

- public Object setProperty(String key, String value) ： 保存一对属性。
- public String getProperty(String key) ：使用此属性列表中指定的键搜索属性值。
- public Set\<String> stringPropertyNames() ：所有键的名称的集合。

#### 与流相关的方法

- `public void load(InputStream inStream)`： 从字节输入流中读取键值对。



