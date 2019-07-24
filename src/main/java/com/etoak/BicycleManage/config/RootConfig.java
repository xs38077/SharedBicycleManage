package com.etoak.BicycleManage.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;

@Configuration //相当于<beans></bean>
@ComponentScan(basePackages="com.etoak",excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,
classes={Controller.class,RestController.class,ControllerAdvice.class,RestControllerAdvice.class,EnableWebMvc.class})},
includeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Service.class,Repository.class})})
@PropertySource(value={"classpath:jdbc.properties","classpath:mybatis.properties"})
@MapperScan(basePackages={"com.etoak.BicycleManage.user.mapper","com.etoak.BicycleManage.rental.mapper","com.etoak.BicycleManage.bicycle.mapper"})	//mapperScannerConfigurer
@EnableTransactionManagement	//事务
public class RootConfig {
	/**
	 * 数据源
	 * SqlSessionFactoryBean 
	 * 
	 */
	@Value("${jdbc.driverClassName}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${mapperLocations}")
	private String mapperLocations;
	@Value("${typeAliasesPackage}")
	private String typeAliasesPackage;
	
	
	@Bean
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sessionFactoryBean(){
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] resources = resolver.getResources(mapperLocations);
			sessionFactoryBean.setMapperLocations(resources);
			sessionFactoryBean.setPlugins(new Interceptor[] {pageInterceptor()});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sessionFactoryBean;
	}
	
	@Bean
	public PageInterceptor pageInterceptor(){
		PageInterceptor interceptor = new PageInterceptor();
		Properties props = new Properties();
		props.setProperty("reasonable", "true");
		interceptor.setProperties(props);
		return interceptor;
	}
	
	
}
