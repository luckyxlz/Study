## Mybaits核心配置文件

- configuration
  - properties
  - settings
  - typeAliases
  - typeHandlers
  - objectFactory
  - plugins
  - environments
    - environment
      - transactionManger
      - dataSource
  - databaseldProvider
  - mappers



#### properties

- 可以在外部进行配置，并可以进行动态替换。既可以在properties文件中配置属性，也可以在properties元素的子元素中设置

- 也可以在 SqlSessionFactoryBuilder.build() 方法中传入属性值。例如：

  ```java
  SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader, props);
  
  // ... 或者 ...
  
  SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader, environment, props);
  ```

- 如果一个属性在不只一个地方进行了配置，那么，MyBatis 将按照下面的顺序来加载：

  - 首先读取在 properties 元素体内指定的属性。
  - 然后根据 properties 元素中的 resource 属性读取类路径下属性文件，或根据 url 属性指定的路径读取属性文件，并覆盖之前读取过的同名属性。
  - 最后读取作为方法参数传递的属性，并覆盖之前读取过的同名属性。

- 从 MyBatis 3.4.2 开始，你可以为占位符指定一个默认值。

> 因此，通过方法参数传递的属性具有最高优先级，resource/url 属性中指定的配置文件次之，最低优先级的则是 properties 元素中指定的属性。





#### settings

这是 MyBatis 中极为重要的调整设置，它们会改变 MyBatis 的运行时行为。 下表描述了设置中各项设置的含义、默认值等。

|          设置名          |                             描述                             |
| :----------------------: | :----------------------------------------------------------: |
| mapUnderscoreToCamelCase | 是否开启驼峰命名自动映射，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn。 |
|                          |                                                              |
|                          |                                                              |





#### typeAliases

类型别名可位Java类型设置一个缩写名字。它用于XML配置，意在降低冗余的全限定类型名书写

- 可以指定一个包名，Mybatis会在包名下面搜索需要的JavaBean

```xml
mybatis-config.xml
<typeAliases>
        <package name = "com.itheima.pojo"></package>
</typeAliases>
```

```xml
UserMapper.xml
<!--  使用typeAliases-->
<mapper namespace="com.itheima.mapper.UserMapper">
<select id="selectAll" resultType="User">
    select * from tb_user;
</select>
</mapper>
```





#### typeHandlers

MyBatis 在设置预处理语句（PreparedStatement）中的参数或从结果集中取出一个值时， 都会用类型处理器将获取到的值以合适的方式转换成 Java 类型。下表描述了一些默认的类型处理器。





#### objectFactory

每次 MyBatis 创建结果对象的新实例时，它都会使用一个对象工厂（ObjectFactory）实例来完成实例化工作。 默认的对象工厂需要做的仅仅是实例化目标类，要么通过默认无参构造方法，要么通过存在的参数映射来调用带有参数的构造方法。 如果想覆盖对象工厂的默认行为，可以通过创建自己的对象工厂来实现.





#### plugins

MyBatis 允许你在映射语句执行过程中的某一点进行拦截调用。



#### Environments

- MyBatis 可以配置成适应多种环境，这种机制有助于将 SQL 映射应用于多种数据库之中， 现实情况下有多种理由需要这么做。

- 配置数据库的连接环境信息，可以配置多个environment，通过default属性切换不同的environment

- > 不过要记住：尽管可以配置多个环境，但每个 SqlSessionFactory 实例只能选择一种环境。
  >
  > 所以，如果你想连接两个数据库，就需要创建两个 SqlSessionFactory 实例，每个数据库对应一个。

- 为了指定创建哪种环境，只要将它作为可选的参数传递给 SqlSessionFactoryBuilder 即可。可以接受环境配置的两个方法签名是：

- 如果忽略了环境参数，那么将会加载默认环境

- 事务管理器

  - 在 MyBatis 中有两种类型的事务管理器（也就是 type="[JDBC|MANAGED]"）：

    - JDBC – 这个配置直接使用了 JDBC 的提交和回滚功能，它依赖从数据源获得的连接来管理事务作用域。默认情况下，为了与某些驱动程序兼容，它在关闭连接时启用自动提交。然而，对于某些驱动程序来说，启用自动提交不仅是不必要的，而且是一个代价高昂的操作。因此，从 3.5.10 版本开始，你可以通过将 "skipSetAutoCommitOnClose" 属性设置为 "true" 来跳过这个步骤。例如：

      ```xml
      <transactionManager type="JDBC">
        <property name="skipSetAutoCommitOnClose" value="true"/>
      </transactionManager>
      ```

    - MANAGED – 这个配置几乎没做什么。它从不提交或回滚一个连接，而是让容器来管理事务的整个生命周期（比如 JEE 应用服务器的上下文）。 默认情况下它会关闭连接。然而一些容器并不希望连接被关闭，因此需要将 closeConnection 属性设置为 false 来阻止默认的关闭行为。例如:

      ```xml
      <transactionManager type="MANAGED">
        <property name="closeConnection" value="false"/>
      </transactionManager>
      ```

- 数据源

  - dataSource 元素使用标准的 JDBC 数据源接口来配置 JDBC 连接对象的资源。

  - 大多数 MyBatis 应用程序会按示例中的例子来配置数据源。虽然数据源配置是可选的，但如果要启用延迟加载特性，就必须配置数据源。

  - 有三种内建的数据源类型（也就是 type="[UNPOOLED|POOLED|JNDI]"）：

    - **POOLED**– 这种数据源的实现利用“池”的概念将 JDBC 连接对象组织起来，避免了创建新的连接实例时所必需的初始化和认证时间。 这种处理方式很流行，能使并发 Web 应用快速响应请求。

      除了上述提到 UNPOOLED 下的属性外，还有更多属性用来配置 POOLED 的数据源：

      - `poolMaximumActiveConnections` – 在任意时间可存在的活动（正在使用）连接数量，默认值：10
      - `poolMaximumIdleConnections` – 任意时间可能存在的空闲连接数。
      - `poolMaximumCheckoutTime` – 在被强制返回之前，池中连接被检出（checked out）时间，默认值：20000 毫秒（即 20 秒）
      - `poolTimeToWait` – 这是一个底层设置，如果获取连接花费了相当长的时间，连接池会打印状态日志并重新尝试获取一个连接（避免在误配置的情况下一直失败且不打印日志），默认值：20000 毫秒（即 20 秒）。
      - `poolMaximumLocalBadConnectionTolerance` – 这是一个关于坏连接容忍度的底层设置， 作用于每一个尝试从缓存池获取连接的线程。 如果这个线程获取到的是一个坏的连接，那么这个数据源允许这个线程尝试重新获取一个新的连接，但是这个重新尝试的次数不应该超过 `poolMaximumIdleConnections`与 `poolMaximumLocalBadConnectionTolerance` 之和。 默认值：3（新增于 3.4.5）
      - `poolPingQuery` – 发送到数据库的侦测查询，用来检验连接是否正常工作并准备接受请求。默认是“NO PING QUERY SET”，这会导致多数数据库驱动出错时返回恰当的错误消息。
      - `poolPingEnabled` – 是否启用侦测查询。若开启，需要设置 `poolPingQuery` 属性为一个可执行的 SQL 语句（最好是一个速度非常快的 SQL 语句），默认值：false。
      - `poolPingConnectionsNotUsedFor` – 配置 poolPingQuery 的频率。可以被设置为和数据库连接超时时间一样，来避免不必要的侦测，默认值：0（即所有连接每一时刻都被侦测 — 当然仅当 poolPingEnabled 为 true 时适用）。

```xml
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql:///mybatis?useSSL=false&amp;serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
```



#### mappers

既然 MyBatis 的行为已经由上述元素配置完了，我们现在就要来定义 SQL 映射语句了。 但首先，我们需要告诉 MyBatis 到哪里去找到这些语句。 在自动查找资源方面，Java 并没有提供一个很好的解决方案，所以最好的办法是直接告诉 MyBatis 到哪里去找映射文件。 你可以使用相对于类路径的资源引用，或完全限定资源定位符（包括 `file:///` 形式的 URL），或类名和包名等。例如：

- ```xml
  <!-- 使用相对于类路径的资源引用 -->
  <mappers>
    <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
    <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
    <mapper resource="org/mybatis/builder/PostMapper.xml"/>
  </mappers>
  ```

- ```xml
  <!-- 使用完全限定资源定位符（URL） -->
  <mappers>
    <mapper url="file:///var/mappers/AuthorMapper.xml"/>
    <mapper url="file:///var/mappers/BlogMapper.xml"/>
    <mapper url="file:///var/mappers/PostMapper.xml"/>
  </mappers>
  ```

- ```xml
  <!-- 使用映射器接口实现类的完全限定类名 -->
  <mappers>
    <mapper class="org.mybatis.builder.AuthorMapper"/>
    <mapper class="org.mybatis.builder.BlogMapper"/>
    <mapper class="org.mybatis.builder.PostMapper"/>
  </mappers>
  ```

- ```xml
  <!-- 将包内的映射器接口实现全部注册为映射器 -->
  <mappers>
    <package name="org.mybatis.builder"/>
  </mappers>
  ```

  
