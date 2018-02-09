package com.liucl.test.core;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration  
public class DSConfig {
	@Bean  
    @ConfigurationProperties(prefix = "spring.datasource")  
	public DataSource druidDataSource() {  //自动装配 配置文件中指定的配置。
        DruidDataSource druidDataSource = new DruidDataSource();  
        return druidDataSource;  
    }  
	
	/////////  下面是druid 监控访问的设置  /////////////////  
	@Bean  
	public ServletRegistrationBean druidServlet() {  
	    ServletRegistrationBean reg = new ServletRegistrationBean();  
	    reg.setServlet(new StatViewServlet());  
	    reg.addUrlMappings("/druid/*");  //url 匹配  
	    reg.addInitParameter("allow", "192.168.16.110,127.0.0.1"); // IP白名单 (没有配置或者为空，则允许所有访问)  
	    reg.addInitParameter("deny", "192.168.16.111"); //IP黑名单 (存在共同时，deny优先于allow)  
	    reg.addInitParameter("loginUsername", "adm");//登录名  
	    reg.addInitParameter("loginPassword", "adm");//登录密码  
	    reg.addInitParameter("resetEnable", "false"); // 禁用HTML页面上的“Reset All”功能  
	    return reg;  
	}  
	
	@Bean(name="druidWebStatFilter")  
	public FilterRegistrationBean filterRegistrationBean() {  
	    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();  
	    filterRegistrationBean.setFilter(new WebStatFilter());  
	    filterRegistrationBean.addUrlPatterns("/*");  
	    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*"); //忽略资源  
	    filterRegistrationBean.addInitParameter("profileEnable", "true");  
	    filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");  
	    filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");  
	    return filterRegistrationBean;  
	}  
}
