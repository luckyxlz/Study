## EL表达式

- Expersion Language 表达式语言，用于简化JSP页面内的Java代码
- 主要功能：获取数据
- 语法：${expresion}
- JavaWeb中的四大域对象
  1. page：当前页面有效
  2. request：当前请求有效
  3. session：当前会话有效
  4. application：当前应用有效
  5. el表达式获取数据，会依次从这四个域中寻找，知道找到为止

## JSTL标签

- JSP标准标签库(JSP Standarded Tag Library)，使用标签取代JSP页面上的Java代码
- \<c:forEach>：相当于for循环
  - items：被遍历的容器
  - var：遍历产生的临时变量
  - begin：开始数
  - end：结束数
  - step：步长



## MVC模式和三层架构

- MVC是一种分层开发的模式，其中：
  - M：Model，业务模型，处理业务
  - V：View，试图，页面展示
  - C：controller，控制器，处理请求，调用模型和视图
- 三层架构：
  - 表现层：
    - 接收请求，封装数据，调用业务逻辑层，响应数据
    - 框架：SpringMVC/Struts2
  - 业务逻辑层：
    - 对业务逻辑进行封装，组合数据访问层层中的基本功能，形成复杂的业务逻辑功能呢
    - Spring
  - 数据访问层：
    - 对数据库的CRUD基本操作
    - Mybatis/Hibername