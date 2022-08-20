# MySQL语句单双引号



#### 在表中添加一个测试用户，使用双引号报错

```mysql
insert into user(id,username,password) values(null,"root","root");
insert into user(id,username,password) values(null,'test','test');

```

