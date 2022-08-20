## 整合Mybatis和Junit



### 整合Mybatis

1. **导入坐标**

   - ```xml
     <dependencies>
     <!-- 添加spring框架依赖 -->
         <dependency>
             <groupId>org.springframework</groupId>
             <artifactId>spring-context</artifactId>
             <version>5.3.18</version>
         </dependency>
     
     <!-- 添加druid依赖 -->
         <dependency>
             <groupId>com.alibaba</groupId>
             <artifactId>druid</artifactId>
             <version>1.1.16</version>
         </dependency>
     
         <!-- 添加mybatis依赖  -->
         <dependency>
             <groupId>org.mybatis</groupId>
             <artifactId>mybatis</artifactId>
             <version>3.5.5</version>
         </dependency>
     
         <!-- 添加mysql依赖 -->
         <dependency>
             <groupId>mysql</groupId>
             <artifactId>mysql-connector-java</artifactId>
             <version>5.1.46</version>
         </dependency>
     
         <!-- spring-jdbc 依赖 -->
             <dependency>
             <groupId>org.springframework</groupId>
             <artifactId>spring-jdbc</artifactId>
             <version>5.3.18</version>
         </dependency>
     
         <!-- mybatis-spring依赖 -->
             <dependency>
             <groupId>org.mybatis</groupId>
             <artifactId>mybatis-spring</artifactId>
             <version>1.3.0</version>
         </dependency>
     ```

2. 创建`MybatisConfig`

   1. ```java
      public class MybatisConfig(){
          
          // 创建SqlSessionFactory对象
          @Bean
          public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
              SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
              ssfb.setDataSource(dataSource);
              ssfb.setTypeAliasesPackage("com.lucky.domain");
              return ssfb;
          }
          
          // 创建Mapper扫描
          @Bean
          public MapperScanerConfigurer mapperScannerConfigurer(){
              MapperScannerConfigurer msc = new MapperScannerConfigurer();
              msc.setBasePackage("com.lucky.dao");
              return msc;
          }
      }
      ```

      

3. 配置`SpringConfig`

   1. 导入`MybatisConfig`，`JdbcConfig`
   1. 导入`Properties`文件







### 整合Junit

- 导入坐标

	- ```xml
		<!-- 导入Junit -->
		<dependency>
		     <groupId>junit</groupId>
		     <artifactId>junit</artifactId>
		     <version>4.12</version>
		     <scope>test</scope>
		</dependency>
		
		<!-- 导入spring-test -->
		 <dependency>
		     <groupId>org.springframework</groupId>
		     <artifactId>spring-test</artifactId>
		     <version>5.2.20.RELEASE</version>
		</dependency>	
		```

		

- 使用Spring整合Junit专用的类加载器

	- ```java
		@RunWith(SpringJUnit4ClassRuuner.class)
		@ContextConfiguration(classes = SpringConfig.class)
		public class BookserviceTest{
		    
		    @AutoWired
		    private BookService bookService;
		    
		    @Test
		    public void testSave(){
		        bookService.save();
		    }
		}
		```

		