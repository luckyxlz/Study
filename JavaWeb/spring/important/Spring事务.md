## Spring事务

### Spring事务简介

- **事务作用**：在数据层保障的一系列的数据库操作同成功同失败
- **Spring事务作用**：在数据层或**业务层**保障一系列的数据库操作同成功同失败







#### Spring事务使用流程

- 在业务层接口上添加Spring事务管理

	- ```java
		public interface AccountService{
		    @Transactional
		    public void transfer(String out,String in, Double money);
		}
		```

	- > Spring注解式事务通常**添加在业务层接口**中而不会添加到业务层实现类中，**降低耦合**
		>
		> 注解式事务可以添加到业务方法上表示当前方法开启业务，也**可以添加到接口上表示当前接口所有方法开启事务**

- 设置事务管理器

	- ```java
		@Bean
		public PlatformTransactionManager transactionManager(DataSource dataSource){
		    DataSourceTransactionManager ptm = new DataSourceTransactionManager();
		    ptm.setDataSource(dataSource);
		    return ptm;
		}
		```

	- > 事务管理器要根据实现技术进行选择
		>
		> Mybatis框架使用JDBC事务

- 开启注解式事务驱动

	- ```java
		@Configuration
		@ComponentScan("com.itheima")
		@PropertySource("classpath:jdbc.properties")
		@Import({JdbcConfig.class, MybatisConfig.class})
		@EnableTransactionManagement
		public class SpringConfig(){
		}
		```









### Spring事务角色

- 事务角色
  - 事务管理员：发起事务方，在Spring种通常指带业务层开启事务的方法
  - 事务协调员：加入事务方，在Spring中通常指代数据层方法，也可以是业务层方法

### 事务相关配置

![](./images/事务相关属性.jpg)

#### 事务传播行为

- 事务协调员对事务管理员所携带事务的处理态度
- ```java
	public class LogServiceImpl implement LogService{
	    
	    @Autowired
	    private LogDao logDao;
	    
	    @Transactional(propagation = Propagation.REQUIRES_NEW)
	    public void log(String out, String in, Double money){
	        logDao.log("转账操作由"+out+"到"+in+"金额："+money);
	    }
	    
	}
	```

	
- ![](./images/事务传播行为属性.jpg)