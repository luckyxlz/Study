## Mybaits快速入门

#### 查询user表中所有数据

1. 导入坐标
2. 创建pojo类（User类）
3. 编写Mybatis核心配置文件 --> 替换连接信息 解决硬编码问题
4. 编写SQL映射文件 -- > 统一管理sql语句，解决硬编码问题
5. 编码
   1. 定义POJO类
   2. 加载核心配置文件，获取SqlSessionFactory对象
   3. 获取SqlSession对象，执行SQL语句
   4. 释放资源