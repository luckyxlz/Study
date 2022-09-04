# SpringMVC



### SpringMVC概述

- `SpringMVC`技术与`Servlet`技术功能等同，均属于`web`层开发技术
- `SpringMVC`是一种基于`Java`实现`MVC`模型的轻量级`web`框架
- 优点
  - 使用简单，开发便捷
  - 灵活性强





### SpringMVC入门案例

1. 导入坐标

   - ```xml
       <dependencies>
         <dependency>
           <groupId>javax.servlet</groupId>
           <artifactId>javax.servlet-api</artifactId>
           <version>3.1.0</version>
           <scope>provided</scope>
         </dependency>
         <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-webmvc</artifactId>
           <version>5.2.10.RELEASE</version>
         </dependency>
       </dependencies>
       
     ```

2. 创建SpringMVC控制类（等同于Servlet功能）

   - ```java
     @Controller
     public class UserController {
     
         @RequestMapping(value = "/save")
         @ResponseBody
         public String save(){
             System.out.println("user save...");
             return '{"user":"save"}';
         }
     }
     ```

3. 初始化SpringMVC环境（同Spring环境），设定SpringMVC加载对应的bean

   - ```java
     @Configuration
     @ComponentScan("com.lucky.controller")
     public class SpringMvcConfig {
     }
     ```

4. 初始化Servlet容器，加载SpringMVC环境，并设置SpringMVC技术处理的请求

   - ```java
     public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
         @Override
         protected WebApplicationContext createServletApplicationContext() {
             AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
             ctx.register(SpringMvcConfig.class);
             return ctx;
         }
     
         @Override
         protected String[] getServletMappings() {
             return new String[]{"/"};
         }
     
         @Override
         protected WebApplicationContext createRootApplicationContext() {
             return null;
         }
     }
     
     ```

   - 改进方法
     
     - ```java
       public class ServletContainersInitConfig extends AbstractAnnotionConfigDispatcherServletInitializer{
           
           protected Class<?>[] getRootConfigClasses(){
               return new Class[]{SpringConfig.class};
           }
           
           protected CLass<?>[] getServletConfigClasses(){
               return new Class[]{SpringMvcConfig.class};
           }
           
           protected String[] getServletMappings(){
               return new String[]{"/"}
           }
       }
       ```
     
       

- SpringMVC用到的注解
  1. `Controller`
     - 名称：`@Controller`
     - 类型：类注解
     - 位置：SpringMVC控制器类定义上方
     - 作用：设定`SpringMVC`的核心控制器`bean`
  2. `ResponseBody`
     - 名称：`@ResponseBody`
     - 类型：方法注解
     - 位置：`SpringMVC`控制器方法定义上方
     - 作用：设置当前控制器方法响应内容为当前返回值，`无需解析`







### 流程分析

- 启动服务器初始化过程
	1. 服务器启动，执行`ServletContainersInitConfig`类，初始化web容器
	2. 执行`CreateServletApplicationContext`方法，创建了`WebApplicationContext`类
	3. 加载`SpringMvcConfig`
	4. 执行`@ComponentScan`加载对应的`bean`
	5. 加载`UserController`，每个`@RequestMapping`的名称对应一个具体的方法
	6. 执行`getServletMappings`方法，定义所有的请求都通过`SpringMVC`
- 单次请求过程
	1. 发送请求`localhost/save`
	2. web容器发现所有请都经过`SpringMVC`，将请求交给`SpringMVC`处理
	3. 解析请求路径`/save`
	4. 由`/save`匹配执行对应的方法`save()`
	5. 执行`save()`
	6. 检测到有`@ResponseBody`直接将`save()`方法的返回值作为响应体返回给请求方



### Controller加载控制与业务bean加载控制

- `SpringMVC`相关`bean`

- `Spring`控制的`bean`

	- 业务bean（`service`）
	- 功能bean（`DataSource`）

- SpringMVC相关bean加载控制

	- SpringMVC加载的bean对应的包均在com.lucky.controller包内

- sSpring相关bean加载控制

	- **方式一**：Spring加载的bean设定扫描范围为com.lucky,排除掉controller包内的bean
	- **方式二**：Spring加载的bean设定扫描范围为精准范围，例如service包，dao包
	- **方式三**：不区分Spring与SpringMVC的环境，加载到同一个环境中

- **ComponentScan**

	- 类型：类注解

	- 属性：

		- excludeFilters：排除扫面路径中加载的bean，需要指定类别与具体项

		- includeFilters：加载指定的bean，需要指定类别与具体项

		- 例子

			- ```java
				@Configuration
				@ComponentScan(value="com.lucky",
					excludeFilters = @Component.Filter(
				        type = FilterType.ANNOTATION,
				        classes = Controller.class
				    )              
				)
				public class SpringConfig{
				    
				}
				```

- `RequestMapping`

	- 类型：方法注解 类注解

	- 位置：SpringMVC控制器方法定义上方

	- 作用：**设置当前控制器方法请求访问路径，如果设置在类上统一设置当前控制器方法请求访问路径前缀**

	- ```java
		@Controller
		@RequestMapping("/user")
		public class UserController{
		    
		    @RequestMapping("/save")
		    @ResponseBody
		    public String save(){
		        // 执行的语句
		    }
		}
		```





### 请求与响应

#### 请求参数

- 参数种类

	- 普通参数

		- url地址传参，地址参数名与行参变量名相同，定义形参即可接收参数

		- ```java
			@RequestMapping("/commonParam")
			@ResponseBody
			public String Commonparam(String name,int age){
			    System.out.println("age ==>"+ age);
			    System.out.println("name ==>" name);
			    return "";
			}
			
			// 此函数可以接收带name和age参数的数据
			```

	- POJO类型参数

		- 请求参数名与形参对象属性名相同，定义POJO类型形参即可接收参数

		- ```java
			class User{
			    protected String name;
			    protected String age;
			}
			
			
			@RequestMapping("/commonParam")
			@ResponseBody
			public String Commonparam(User user){
			    System.out.pringln("user"+user);
			    return "";
			}
			
			// 此函数可以接收带name和age参数的数据
			```

	- 嵌套POJO类型参数

		- 请求参数名与形参对象属性名相同，**按照对象层次结构关系即可接收嵌套POJO属性参数**

		- > 请求地址例子：localhost/pojoContainerPojoParam?name=lucky&address.city=shantou

	- 数组类型参数

		- 请求参数名与形参对象属性名相同且请求参数为多个，**定义数组类型形参即可接收参数**

		- > Localhost/array?likes=swim&likes=computer

	- 集合类型参数

		- 请求参数名与形参集合对象名相同且请求参数为多个，需要使用@RequestParam绑定参数关系

- `@RequestParam`

	- 类型：形参注解
	- 位置：`SpringMVC`控制器方法行参定义前面
	- 作用：绑定请求参数与处理器方法形参间的关系


> 使用过滤器对乱码数据进行处理
>
> ```java
> @Override
> protected Filter[] getServletFilters(){
>     CharacterEncodingFilter filter = new CharacterEncondingFilter();
>     filter.setEncoding("utf-8");
>     return new Filter[]{filter};
> }
> ```



#### Json数据传递参数

三种参数：

- json数组
- json对象（pojo）
- json数组（pojo）

步骤：

- 导入Json坐标

	- ```xml
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactedId>jackson-databind</artifactedId>
		    <version>2.9.0</version>
		</dependency>
		```

- 开启自动转化json数据的支持(使用**@EnableWebMvc**)

	- ```java
		@Configuration
		@ComponentScan("com.lucky.controller")
		@EnableWebMvc
		public class SpringMvcConfig {
		}
		```

	- > @EnableWebMvc注解功能强大，该注解整合了多个功能，此处仅使用其中一部分功能，即json数据进行自动类型转换

- 设置接收json数据

	- ```java
		public String listParamForJson(@RequestBody List<String> likes){
		    System.out.println(likes);
		    return '';
		}
		```

	- @RequestBody

		- 类型：形参注解
		- 位置：SpringMVC控制器方法形参定义前面
		- 作用：将请求中请求体包含的数据传递给请求参数，此注解一个处理器方法只能使用一次



#### 日期型参数传递

- 日期类型数据基于系统不同格式也不尽相同
	- 2088-08-18
	- 2088/08/18
	- 08/18/2088
- 接收形参时，根据不同的日期格式设置不同的接收方法
	- @DateTimeFormate
		- 类型：形参注解
		- 位置：SpringMVC控制器方法形参前面
		- 作用：设定日期时间型数据格式
		- 属性：pattern：日期时间格式字符串



#### 响应

- 响应页面
- 响应数据
	- 文本数据
	- json数据(需要引入转化为json对象的jar包)
	
		- ```java
			public List<User> toJsonList(){
			    User user1 = new User();
			    user1.setName("赵云");
			    user1.setAge(19);
			    User user2 = new User();
			    user2.setName("张飞");
			    user2.setAge(20);
			    
			    List<User> users = new ArrayList<User>();
			    users.add(user1);
			    users.add(user2);
			    
			    return users;
			}
			```
	
		- @ResponseBody
	
			- 类型：方法注解
			- 位置：SpringMVC控制器方法定义在上方
			- 作用：设置当前控制器返回值作为响应体