# Cookie

### Cookie的基本使用

#### 简介：

客户端会话技术，将数据保存到客户端，以后每次请求都携带Cookie数据进行访问

#### 基本使用：

- **发送Cookie**
  
  1. 创建Cookie，设置数据：
  
  	- ```java
  		Cookie cookie = new Cookie("key","value")
  		```
  2. 发送Cookie到客户端：使用response对象 
  
  	- ```java
  		respone.addCookie(cookie)
  		```
- **获取Cookie**
  
  - 获取客户端携带的所有Cookie，使用request对象    
  
  	- ```java
  		req.getCookies()
  		```
  - 遍历数组，获取每一个Cookie对象
  - 使用Cookie对象方法获取数据 
  
  	- ```java
  		cookie.getName(); 
  		cookie.getValue();
  		```
  
  		



### Cookie原理

- Cookie的实现时基于HTTP协议的
  - 响应头：set-cookie
  - 请求头：cookie



### Cookie使用细节

- **Cookie存活时间**
  - 默认情况下，Cookie存储在浏览器内存中，当浏览器关闭，内存释放，则Cookie被销毁
  - **setMaxAge**(int second)：设置Cookie的存活时间
    - 正数：将Cookie写入浏览器所在电脑的硬盘，持久化存储。到时间自动删除
    - 负数：默认值，Cookie在当前浏览器内存中，当浏览器关闭，则Cookie被销毁
    - 零：删除对应Cookie
- **Cookie存储中文**
  - Cookie不能直接存储中文
  - 如果需要存储，则需要进行转码：URL编码