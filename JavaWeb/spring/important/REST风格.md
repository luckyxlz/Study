# REST风格

#### REST简介

- REST，**表现形式状态转换**

- 优点：

  - 隐藏资源的访问行为，无法通过地址得知对资源是何种操作
  - 书写简化

- 按照REST风格访问资源时使用**行为动作**区分对资源进行了何种操作

- > 上述行为是约定方式，约定不是规范，可以打破，所以称为REST风格，而不是REST规范。
  >
  > **描述模块的名称通常使用复数，也就是加s的格式描述，表示此类资源，而非单个资源**



#### @RequestBody @RequestParam @PathVariable

- 请求参数的注解
- 区别
  
  - `@RequestParam`用于接受**url地址传参或表单传参**
  - `@RequestBody`用于**接收json数据**
  - `@PathVariable`
  	- 类型：形参注解
  	- 位置：SpringMVC控制器方法形参定义前面
  	- 作用：**用于接受路径参数**，使用{参数名称}描述路径参数
- 例子

	- ```java
		@RequestMapping(value="/users", method = RequestMethod.POST)
		@ResponseBody
		public String save(){
		    // 执行的语句
		}
		
		
		@RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
		@ResponseBody
		public String delete(@PathVariable Integer id){
		    // 执行的语句
		}
		```

	- ```java
		// REST快速开发
		@RestController
		@RequestMapping("/users")
		public class UserController{
		    // @RequestMapping(method = RequestMethod.POST)
		    @PostMapping
		    public String save(){
		        // 执行的语句
		    }
		    // @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
			@DeleteMapping("/{id}")
		    public String delete(@PathVariable Integer id){
		        // 执行的语句
		    }
		}
		```

		

- 应用
  - 后期开发中，发送请求参数超过1个时，以json格式为主，@RequestBody应用较广
  - 如果发送非json格式数据，选用@RequestParam接受请求参数
  - 采用RESTful进行开发，当参数数量较少时，例如一个，可以采用@PathVariable接受请求路径变量，通常用于传递id值





#### 设置对静态资源的访问放行

```java
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport{
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry){
        
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        
    }
    
}
```

