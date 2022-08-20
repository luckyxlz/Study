package com.lucky.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.lucky")
@PropertySource("classpath:jdbc.properties")
@Import({MybatisConfig.class,JdbcConfig.class})
public class SpringConfig {
}
