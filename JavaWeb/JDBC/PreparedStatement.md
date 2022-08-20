# PreparedStatement

### SQL注入

#### 原理：拼接字符串

```mysql
select * from user where user = 'zhangsan' and password = '' or '1' = '1'
```

- PrepareStatment作用

  - 好处

    - 预编译SQL，性能更高
    - 防止SQL注入：将敏感字符进行转义

  - 预编译SQL并执行SQL语句

    - 获取PreparedStatment对象

      ```mysql
      String sql = "select * from user where username = ? and password = ? "
      PreparedStatment pstmt = conn.prepareStatment(sql);
      ```

    - 设置参数值

      - PreparedStatment对象：setXxx(参数1，参数2)：给?赋值
        - Xxx：数据类型；如 setInt(参数1，参数2)
        - 参数：
          - 参数1：？的位置编号，从1开始
          - 参数2：？的值

    - 执行SQL

      - executeUpdate();/executeQuery(); 不需要再传递sql
      - PreparedStatment 预编译功能开启：userServerPrepStmts=true
      - 配置MySQL日志(重启mysql服务后生效)
      - PreparedStatment 原理：
        1. 在获取PreparedStatement对象时，将sql语句发送给musql服务器，进行检查，编译
        2. 执行时就不用再进行这些步骤了，速度更快
        3. 如果sql模块一样，则只需要进行一次检查，编译

