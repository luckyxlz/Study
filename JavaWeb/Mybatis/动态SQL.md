# 动态SQL

## 动态SQL的主要元素

- if
- choose(when, otherwise)
- trim(where, set)
- foreach



## scirpt

要在带注解的映射接口类中使用动态SQL，可以使用`script`元素。比如





## bind

`bind`元素运行你在OGNL表达式以外创建一个变量，并将其绑定到当前的上下文





## 多数据库支持

如果配置了 `databaseIdProvider`，你就可以在动态代码中使用名为 “`_databaseId`” 的变量来为不同的数据库构建特定的语句。







## 动态SQL中的插入脚本语言