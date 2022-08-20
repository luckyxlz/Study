## JDBC API详解

#### DriverManger

1. ##### 注册驱动

> - MySQL 5 之后的驱动包，可以省略注册驱动的步骤
> - 自动加载jar包中META-INF/services/java.sql.Driver文件的驱动类

2. ##### 获取连接

   1. 参数
      - `url`：连接路径
      
         1. 语法：
      
            ```
            jdbc:mysql://ip地址(域名):端口号/数据库名称?参数键值对1&参数键值对2...
            ```
         2. 细节：
            - 如果连接的是本机的mysql服务器，并且mysql服务器默认端口3306，则url可以简写为：jdbc:mysql:///数据库名称?参数键值对1&参数键值对2
      - `user`：用户名
      - `password`：密码

#### Connection

1. 获取执行SQL的对象
   - 普通执行SQL对象
     - Statement createStatement()
   - 预编译SQL的执行对象SQL对象：防止SQL注入
     - PreparedStatement prepareStatement(sql)
   - 执行存储过程的对象
     - CallableStatement prepareCall()
2. 事务管理
   1. MySQL事务管理
      1. 开启事务
      2. 提交事务
      3. 回滚事务
   2. JDBC事务管理：Connection接口中定义了3个对应的方法
      1. 开启事务：
         - setAutoCommit(boolean autoCommit)
         - true为自动提交事务；false为手动提交事务，即为开启事务
      2. 提交事务：
         - commit()
      3. 回滚事务：
         - rollback()

#### Statement

- Statement作用
- 执行SQL语句
  - int executeUpdate(sql): 执行DML，DDL语句
    - 返回值：
      1. (1)DML语句影响的行数
      2. (2)DDL语句执行后，执行成功也可能返回0
  - ResultSet executeQuery(sql): 执行DQL语句
    - 返回值：
      1. ResultSet结果集对象



#### ResultSet

- ResultSet(结果集对象)作用：

  - 封装了DQL查询语句的结果

  ```java
  ResultSet stmt.executeQuery(sql)//执行DQL语句，返回ResultSet对象
  ```

- 获取查询结果

  - Boolean next(): 
    - 将光标从当前位置向移动一行
    - 判断当前行是否为有效行
    - 返回值
      - true：有效行，当前行有数据
      - false：无效行，当前行没有数据
  - xxx getXxx(参数)：获取数据
    - xxx：数据类型；如int getInt(参数)；String getString(参数)
    - 参数：
      - int：列的编码，从1开始
      - String：列的名称

- 使用步骤

  1. 游标向下移动一行，并判断该行是否有数据：next()
  2. 获取数据：getXxx(参数)