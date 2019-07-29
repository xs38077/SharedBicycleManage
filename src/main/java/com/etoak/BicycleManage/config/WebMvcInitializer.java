package com.etoak.BicycleManage.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * root容器
	 * 
	 */
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebMvcConfig.class};
	}

	/**
	 * DispatcherServlet
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		// POST编码过滤器
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);

		//<!-- 可以将POST请求转成PUT、DELETE... -->
		HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();

		return new Filter[]{encodingFilter,methodFilter};
	}


}
