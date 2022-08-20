# AOP

## AOP简介

- **AOP面向切面编程**，**一种编程范式**，指导开发者如何组织程序结构

> OOP面向对象编程

- **作用**：在**不改变原始设计的基础**上为其进行功能增强（**不侵入式**）
- **核心概念**
  - **连接点**：程序执行过程中的任意位置，粒度为执行方法，抛出异常，设置变量
    - 在`SpringAOP`中，理解为方法的执行
  - **切入点**：匹配连接点的式子
    - 在`SpringAOP`中，一个切入点可以只描述一个具体方法，以可以匹配多个方法
      - 一个具体的方法：`com.lucky.dao`包下的`BookDao`接口中的无形参返回值的`save`方法
      - 匹配多个方法：所有的`save`方法，所有的`get`开头的方法，所有以`Dao`结尾的接口中的任意方法，所有带有一个参数的方法
  - **通知**：在切入点处执行的操作，也就是共性功能
    - 在SpringAOP中，功能最终以方法的形式呈现
  - **通知类**：定义通知的类
  - **切面**：描述通知与切入点的对应关系



### 案例：

- 案例设定：测定接口执行速率

- 简化设定：在接口执行前输出当前系统时间

- 开发模式：XML or **注解**

- 思路分析：
  1. 导入坐标
  
  	1. ```xml
  		<!-- 导入Spring-->
  		<dependency>
  		    <groupId>org.springframework</groupId>
  		    <artifactId>spring-context</artifactId>
  		    <version>5.2.10.RELEASE</version>
  		</dependency>
  		
  		<!-- 导入aspectjweaver -->
  		<dependency>
  		    <groupId>org.aspectj</groupId>
  		    <artifactId>aspectjweaver</artifactId>
  		    <version>1.9.4</version>
  		</dependency>
  		```
  
  		
  
  2. 制作连接点方法
  
  3. 制作共性功能，定义切入点，绑定切入点与通知的关系
  
  	1. ```java
  		// 创建通知类
  		@Component//告知 spring加载该bean
  		@Aspect// 告知 spring该bean作为用来做AOP
  		public class MyAdvice{
  		    
  		    
  		    // 创建切入点，一个私有的方法，并且不包含方法体，无参数，无返回值，并且设置设置切入点
  		    @Pointcut("execution(void com.lucky.dao.BookDao.update()")
  		    private void pt();
  		    
  		    
  		    // 制作共性办法
  		    @Before
  		    public void method(){
  		        // 共性代码
  		    }
  		}
  		```
  
  		
  
  4. 在SpringConfig配置通知类信息
  
  	1. ```java
  		@Configuration
  		@ComponentScan("com.lucky")
  		@EnableAspectJAutoProxyer
  		public class SpringConfig(){
  		    
  		}
  		```
  
  		







#### AOP工作流程

1. `Spring`容器启动
2. 读取所有切面配置中切入点
	1. 这里的意思是有被使用的切入点才进去读取，如果只定义切入点，没有连接切面则不进行加载

3. 初始化bean，判定bean对应的类中的方法是否匹配到任意切入点
	- 匹配失败，创建对象
	- **匹配成功**，创建原始对象（**目标对象**）的**代理**对象
4. 获取bean执行方法
	- 获取`bean`，调用方法并执行，完成操作
	- 获取的`bean`是代理对象时，根据代理对象的运行模式运行原始方法与增强的内容，完成操作

#### 核心概念

- 目标对象：原始功能去掉共性功能对应的类产生的对象，这种对象是无法直接完成最终工作
- 代理：目标对象无法直接完成，需要对其进行功能回填，通过原始对象的代理对象



#### APP切入点表达式

- 切入点：要进行增强的方法
- 切入点表达式：要进行增强的方法的描述方式
- 描述方法
	- 执行com.lucky.dao.BookDao.update()
	- 执行com.lucky.dao.impl.BookDaoImpl.update()
- 切入点表达式标准格式：动作关键字(访问修饰符 返回值 包名.类/接口名.方法名(参数)异常名)
	- 动作关键字：描述切入点的行为动作，例如`execution`表示执行到指定切入点
	- 访问修饰符：public，private等，**可以省略**
	- 返回值
	- 包名
	- 类/接口名
	- 方法名
	- 参数
	- 异常名：方法定义中抛出指定异常，**可以省略**
- **可以使用通配符描述切入点，快速描述**
	- `*`：单个独立的任意符号，可以独立出现，也可以作为前缀或者后缀的匹配符出现
	- `.`.：多个连续的任意符号，可以独立出现，常用于简化包名与参数的书写
	- `+`：专用于匹配子类类型
- **书写技巧**
	- **所有代码按照标准规范开发，否则一下技巧全部失效**
	- 描述切入点**通常描述接口**，而不描述实现类（降低耦合）
	- 访问控制修饰符针对接口开发均采用public描述
	- 返回值类型对于**增删改类使用精准类型加速匹配**，**对于查询列使用*通配快速描述**
	- 包名书写尽量不使用..匹配，效率过低，常用“做单个包描述匹配，或精准匹配
	- 接口名/类名书写名称与模块相关的采用*匹配，例如UserService书写成\*Service，绑定业务层接口名
	- 方法名书写以动词进行精准匹配，名次采用*匹配，例如getById书写成getBy\*，
	- 参数规则比较复杂，根据业务方法灵活调整
	- 通常不使用异常作为匹配规则



#### AOP通知类型

- AOP通知描述了类抽取的共性功能，根据共性功能抽取的位置不同，最终运行代码时要将其加入到合理的位置

- AOP通知共分为5种类型

	- 前置通知
		- 使用`@Before`注解

	- 后置通知
		- 使用`@After`注解

	- 环绕通知（重点）
		- 使用`@Around`

	- 返回后通知（了解）
		- 使用`@AfterReturning`

	- 抛出异常后通知（了解）
		- 使用`@AfterThrowing`

- 环绕通知

	- 名称：`@Around`

	- 类型：方法注解

	- 位置：通知方法定义上方

	- 作用：设置当前通知方法与切入点之间的绑定关系，当前通知方法在原始切入点方法前后运行

	- 注意事项：

		- 环绕通知必须依赖行参`ProceedingJoinPoint`才能实现对原始方法的调用，进而实现原始方法调用前后同时添加通知
			- 使用`ProceddingJoinPonit`创建的对象并调用`proceed`方法(这个可以接受到原始对象的返回数据)；
		- 通知中如果未使用`ProceedingJoinPoint`对原始方法进行调用将跳过原始方法的执行
		- 对原始方法的调用可以不接受返回值，通知方法设置成void即可，如果接受返回值，**必须设定Obiect类型**
		- **原始方法的返回值如果是void类型，通知方法的返回值类型可以设置成void，也可以设置成Obiect**
		- **由于无法预知原始方法运行后是否会抛出异常，因此环绕通知方法必须抛出Throwable对象**

	- ```java
		@Around("pt()")
		public Object around(ProceedingJoinPoint pjp) throws Throwable{
		    System.out.println("around brfore advice");
		    Object ret = pjp.proceed();
		    System.out.println("around after advice");
		    return ret;
		}
		```

	- `ProceedingJoinPoint`类中的`getSignature`可以获得原始对象的数据

		- 返回类型为`Signature`;
		- `Signature`中的`getDeclaringTypeName`方法可以获得类名，`getName`方法可以获得方法名

#### AOP通知获取数据

- 获取切入点方法的参数

	- `JoinPoint`：适用于前置，后置，返回后，排出异常后通知

		- ```java
			public void before(JoinPoint jp){
			    Object[] args = jp.getArgs();// 获取参数数组
			}
			```

	- `ProceedJoinPoint`：用于环绕通知

		- ```java
			public void before(ProceedingJoinPoint pjp){
			    Object[] args = pjp.getArgs();// 获取参数数组
			}
			```

	- 可以在`AOP`中修改`args`参数的数据，进行参数校验

- 获取切入点方法返回值

	- 返回后通知

		- ```java
			@AfterReturnning(value = "pt()", returning="obj")
			public void afterReturning(Object obj){// 与注解的返回名应该一致
			    System.out.pringln(ret);
			}
			```

	- 环绕通知

- 获取切入点方法运行异常信息

	- 抛出异常后通知
	- 环绕通知

