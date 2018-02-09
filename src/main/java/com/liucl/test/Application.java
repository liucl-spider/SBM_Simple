package com.liucl.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 简单springBoot整合mybatis
 *
 */
@SpringBootApplication
@MapperScan("com.liucl.test.dao")  //扫描的是mapper.xml中namespace指向值的包位置
public class Application 
{
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
