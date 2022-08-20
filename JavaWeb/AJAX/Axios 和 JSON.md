## Axios 和 JSON



### Axios异步框架

- Axios对原生的AJAX进行封装，简化书写



### Axios快速入门

1. 引入axios的js文件
2. 使用axios发送请求，并获取响应结果





### JSON

- 概念：JavaScript Obiect Notation。JavaScript对象表示法
- 由于其语法简单，层次结构鲜明，现多用于作为数据载体，在网络中进行数据传输



#### JSON基础语法

- 定义：

- ```javascript
  var 变量名 = {
  	"key1":value1,
  	"key2":value2,
  	...
  };
  ```

  - 示例：

  - ```javascript
    var json = {
    	"name":"zhangsan",
    	"age":23,
    	"addr":["北京","上海","西安"]
    };
    ```

- Value 的数据类型：

  - 数字
  - 字符串
  - 逻辑值
  - 数组
  - 对象
  - null

- 获取数据：

  - 变量名.key
  - Json.name



#### JSON数据和Java对象转换

- 请求数据：JSON字符串转换为Java对象

- 响应数据：Java对象转化为JSON字符串

- **Fastjson**是阿里巴巴提供的一个Java语言编写的高性能功能完善的JSON库，是目前Java语言中最快的JSON库，可以实现Java对象和JSON字符串的相互转换

- 使用

  1. 导入坐标

     - ```xml
       <dependency>
       	<groupId>com.alibaba</groupId>
         <artifactId>fastjson</artifactId>
         <version>1.2.62</version>
       </dependency>
       ```

  2. Java对象转JSON

     - String jsonStr = JSON.toJSONString(obj);

  3. JSON字符串转Java对象

     - User user = JSON.parseObiect(jsonStr, User.class);

