## JDBC快速入门

#### 步骤

1. 创建工程
2. 注册驱动
3. 获取连接
4. 定义SQL语句
5. 获取执行SQL对象
6. 执行SQL
7. 处理返回结果
8. 释放资源

```java
//注册驱动
Class.forName("com.mysql.jdbc.Driver");


//连接的相关信息
String url = "jdbc:mysql://127.0.0.1:3306/db2";
String username = "root";
String password = "123456";


//连接数据库
Connection conn = DriverManager.getConnection(url, username, password);

//获取执行sql的对象
Statement stat = conn.createStatement();

//执行的sql
String sql = "update account set money = 1000 where id = 1";

//获取受影响的行数
int count = stat.executeUpdate(sql);

//打印行数
System.out.println(count);

//释放资源
stat.close();
conn.close();
```

