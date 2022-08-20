## DCL--管理用户



#### 简介

DCL为数据控制语言，用来管理数据库用户，控制数据库的访问权限



- DCL-- 管理用户

  - 查询用户

    - ```mysql
      USE mysql;
      Select * from user;
      ```

  - 创建用户

    - ```mysql
      Create User '用户名'@'主机名' IDENTIFIED BY '密码';
      ```

    - ```mysql
      -- 创建用户可以在任意主机访问数据库
      Create user '用户名'@"%" Identified by '密码';
      ```

      

  - 修改用户密码

    - ```mysql
      Alter User '用户名'@'主机名' IDENTIFIED with mysql_native_password BY '新密码';
      ```

  - 删除用户

    - ```mysql
      Drop User '用户名'@'主机名';
      ```



- 权限控制

  - MySQL中定义类很多种权限，但是最常用的就以下几种

  - |        权限        |        说明        |
    | :----------------: | :----------------: |
    | ALL,ALL PRIVILEGES |      所有权限      |
    |       SELECT       |      查询数据      |
    |       INSERT       |      插入数据      |
    |       UPDATE       |      修改数据      |
    |       DELETE       |      删除数据      |
    |       ALTER        |       修改表       |
    |        DROP        | 删除数据库/表/视图 |
    |       CREATE       |   创建数据库/表    |

    查询权限

    ```mysql
    Show grants FOR "用户名"@"主机名";
    ```

  - 授予权限

    ```mysql
    GRANT 权限列表 ON 数据库名,表名 TO "用户名"@"主机名";
    ```

  - 插销权限

    ```mysql
    REVOKE 权限列表 ON 数据库名.表名 FROM '用户名'@"主机名";
    ```

    