# bean

#### bean属性

- `id`
    - 功能：在获取Bean时使用
    - 是bean的唯一标识，IoC容器中bean的id标签不能重复，否则报错
- `class`
    - 功能：用来定义类的全限定名（包名＋类名）
    - 只有子类Bean不用定义该属性 

- `name`
    - 功能：起别名
    - 可定义多个，使用逗号 分号 空格 分隔
- `scope`
    - 功能：设置作用范围
    - `singleton`：单例（默认）；`prototype`：非单例
- `init-method`
    - 功能：可以再bean创建以后执行一些功能

- `destroy-method`
    - 功能：`bean`消亡之前执行一些功能

- `aotowire`
    - `byName`：按名字自动填充
    - `byType`：按类型自动填充

- `lazy-init`
    - 功能：是否延迟加载`bean`

- `factory`
    - 功能：bean工厂方法，应用于静态工厂或实例工厂

- `factory-bean`
    - 功能：实例工厂`bean`	

- **子标签**
    - `property`
        - 功能：设置bean类型的属性
        - 子属性
        - `name`属性：用于指定属性的名称（在类中的名字）
        - `value`属性：用于指定该属性的值（用于指定的值是基本类型，字符串类型）
        - `ref`属性：用于指定该属性的值
        - 子标签
            - `value`标签
            - `ref`标签

- **适合交给容器进行管理的bean**
    - 表现层对象
    - 业务层对象
    - 数据层对象
    - 工具对象
- **不适合交给容器进行管理的`bean`**
    - 封装实体的域对象





#### bean实例化

- **构造方法**	

    - 提供可访问的构造方法

    - 配置

    - 创建`bean`时，会默认调用该类的无参构造方法，无参构造方法如果不存在，将抛出异常`BeanCreationException`

        - ```java
            public class BookDaoImpl implements BookDao {
                
            
                private BookDaoImpl(){
                    System.out.println("BookDaoImpl");
                }
            
                public void save() {
                    System.out.println("book dao save");
                }
            }
            ```

        - ```xml
            <bean id="bookDao" class="com.lucky.dao.impl.BookDaoImpl"/>
            ```

- 静态工厂

    - **了解即可**

    - 提供静态工厂

    - 配置

        - ```java
            public class OrderDaoFactory {
                public static OrderDao getOrderDao(){
                    return new OrderDaoImpl();
                }
            }
            ```

        - ```xml
            <bean id="orderDao" class="com.lucky.dao.factory.OrderDaoFactory" factory-method="getOrderDao" />
            ```

- **实例工厂**

    - 提供实例工厂`bean`以及工程`bean`

    - 配置

        - ```java
            public class UserDaoFactory {
                public UserDao getUserDao(){
                    return  new UserDaoImpl();
                }
            }
            ```

        - ```xml
            <!-- 创建工厂对象-->
                <bean id="userFactory" class="com.lucky.dao.factory.UserDaoFactory"/>
                <bean id="userDao" factory-bean="userFactory" factory-method="getUserDao"></bean>
            ```

- **使用FactoryBean实例化bean**

    - **重点**

    - 创建`xxxFactoryBean`类，实现`FactoryBean<xxx>`接口

    - 配置

        - ```java
            public class UserDaoFactoryBean implements FactoryBean<UserDao> {
              	// 代替原始实例工厂中创建对象的方法
                @Override
                public UserDao getObject() throws Exception {
                    return new UserDaoImpl();
                }
            
              	// 返回创建对象的类型
                @Override
                public Class<?> getObjectType() {
                    return UserDao.class;
                }
                
              	//选择是否为单例模式
                @Override
                public boolean isSingleton() {
                    return false;
                }
            }
            ```

        - ```xml
            <bean id="userDao" class="com.lucky.dao.factory.UserDaoFactoryBean"/>
            ```








### bean的生命周期

- 生命周期：从创建到消亡的完整过程
- bean生命周期：bean从创建到销毁的整体过程
- bean生命周期控制：在bean创建后到销毁前做一些事情
- **过程**
    - 初始化容器
        1. 创建对象
        2. 执行构造方法
        3. 执行属性注入(set方法)
        4. 执行bean初始化方法
    - 使用bean
        - 执行业务操作
    - 关闭/销毁容器
        - 执行bean销毁方法
- **bean的销毁时机**
    - 容器关闭前触发bean的销毁
    - 关闭容器方式：
        - **手工关闭容器**
            - `ConfigurableApplicationContext`接口`close()`操作
        - **注册关闭钩子**，在虚拟机退出前先关闭容器再推出虚拟机
            - `ConfigurableApplicationContext`接口`registerShutdownHook`()操作

#### 实现bean进行生命周期的一些操作的方法

- 在类中实现`init`，`destroy`方法，并在bean中进行配置`init-method`, `destroy-method`属性，
- 实现`InitializingBean`,`DisposableBean`接口







#### 通过容器获取bean的三种方式

- 方式一：使用bean名称获取

    - ```java
        BookDao bookDao = (BookDao) ctx.getBean("bookDao")
        ```

- 方式二：使用bean名称获取指定类型

    - ```java
        BookDao bookDao = ctx.getBean("bookDao",BookDao.clss)
        ```

- 方式三：使用bean类型获取

    - ```
        BookDao bookDao = ctx.getBean(BookDao.clss)
        ```

### 