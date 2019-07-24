package com.etoak.BicycleManage.config;

import com.etoak.BicycleManage.user.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration //相当于<beans></bean>
@ComponentScan(basePackages="com.etoak",includeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,
			classes={Controller.class,RestController.class,ControllerAdvice.class,RestControllerAdvice.class,EnableWebMvc.class})},
		excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Service.class,Repository.class})})
@EnableWebMvc	//相当于<mvc:annotation-driven />
public class WebMvcConfig implements WebMvcConfigurer{
	/**
	 * 相当于<mvc:default-servlet-handler/>
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 相当于<mvc:resources location="" mapping=""/>
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/pics/**")//mapping属性
		.addResourceLocations("file:D:/Etoak/Month5/upload/");//location属性
		
		// js\css文件访问
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
	
	/**
	 * SpringResourceTemplateResolver
	 * SpringTempl;ateEngine
	 * ThymeleafViewResolver
	 * 方法名字默认就是bean的id属性
	 * 可以使用@Bean("id别名")进行id配置
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCharacterEncoding("UTF-8");
		//开发环境可以设置为false
		templateResolver.setCacheable(false);
		return templateResolver;
	}
	
	@Bean("engine")
	public SpringTemplateEngine templateEngine(){
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(this.templateResolver());
		return engine;
	}
		
	@Bean
	public ThymeleafViewResolver viewResolver(@Qualifier("engine")SpringTemplateEngine templateEngine){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//TODO  开发完成后记得删除/** 这条拦截白名单；
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/**")
		.excludePathPatterns("/user/to_login")
		.excludePathPatterns("/user/login")
		.excludePathPatterns("/js/**")
		.excludePathPatterns("/bootstrap/**");
		
	}
	//文件上传解析器
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1048760L);	//10MB
		return resolver;
	}

	//无需处理的请求url写在此处
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
	}

}




















