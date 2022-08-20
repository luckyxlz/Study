## Note

### 用户登陆：

- 流程说明
  1. 用户填写用户名密码，提交到loginServlet
  2. 在LoginServlet中使用MyBatis查询数据库，验证用户名密码是否正确
  3. 如果正确，响应登陆成功，如果错误，响应登陆失败
- 环境搭建
  1. 复制资料中静态页面到项目的webapp目录下
  2. 创建db1数据库，创建tb_user表，创建User实体类
  3. 导入Mybatis坐标，MySQL驱动坐标
  4. 创建Mybatis-config.xm核心配置文件，UserMapper.xml映射文件，UserMapper接口

### 用户注册：

- 流程说明：
  1. 用户填写用户名/密码信息，点击注册按钮，提交到RegisterServlet
  2. 在RegisterServlet中使用Mybatis保存数据
  3. 保存前，需要判断用户名是否存在：根据用户名查询数据库



### 代码优化

- 创建SqlSessionFactory代码优化
- 问题：
  1. 代码重复
  2. SqlSessionFactory 工厂只创建一次，不要重复创建