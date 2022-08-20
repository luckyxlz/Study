# IoC与DI



#### 背景：

- 代码书写的耦合度过高，使用IoC与DI技术可以进行充分结偶

#### 技术实现：

- 使用IoC容器管理bean(IoC)
- 在IoC容器内将有依赖关系的bean进行关系绑定(DI)

#### 效果：

- 使用对象时不仅可以直接从IoC容器中获取，并且获取到的bean已经绑定了所有的依赖关系



## IOC

**定义**：**控制反转**；使用对象时，由主动new产生对象转换为由**外部**提供对象，此过程中对象创建控制权由程序转移到**外部**，此思想称为控制反转

**spring技术对IoC思想进行实现**

- Spring提供了一个容器，称为**IoC容器**，用来充当IoC思想中的"外部"
- IoC容器负责对象的创建，初始化等一系列工作，被创建或被管理的对象在IoC容器中称为**Bean**



## DI

**定义**：**依赖注入**；在容器中建立bean与bean之间的依赖关系的整个过程，称为依赖注入







## IoC入门案例分析

1. 管理什么？（Service 与Dao）

2. 如何将被管理对象告知IoC容器？（配置）

3. 被管理的对象交给IoC容器，如何获取到IoC容器？（接口）

4. IoC容器得到后，如何从容器获取bean？（接口方法）



#### 实现步骤：

1. 使用Spring导入导入哪些坐标？（pom.xml）

   - ```xml
     <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context</artifactId>
       <version>5.2.10.RELEASE</version>
     </dependency>
     ```

2. 定义Spring管理的类或接口

3. 创建spring配置信息

4. 配置bean

   - id属性表示bean名字
   - class属性表示给bean定义类型
   - ```xml
     <bean id="" class=""></bean>
     ```

     

5. 初始化容器，通过容器获取bean

   - ```java
     {
       // get IoC container;     configuration should be a file of xml
       Application ctx = new ClassPathXmlApplicationContext(configuration);
     	// get bean
       ctx.getbean();
     }
     ```

     



## DI入门案例分析

1. 基于IoC管理bean
2. Service中使用new形式创建的Dao对象是否保留？（否）
3. Service中需要的Dao对象如何进入到SErvice中？（提供方法）
4. Service与Dao间的关系如何描述？（配置）



#### 步骤：



1. 删除使用new的形式创建对象的代码

2. 提供依赖对象对应的setter方法

   - ```java
      {
      	private UserDao userDao;
        
        public setUserDao(userDao);
      }
      ```

3. 在bean中配置Service

   - property标签表示配置当前bean属性
     - name属性表示配置哪一个具体的属性(setter的参数)
     - ref属性表示参照哪一个bean的id
     
   - ```xml
     <bean id="userDao" class="com.lucky.dao.impl.UserDaoImpl"/>
     <bean id="userService" class="com.lucky.service.impl.UserServiceImpl">
       <property name="userDao" ref="userDao"/>
     </bean>
     ```
     
     



