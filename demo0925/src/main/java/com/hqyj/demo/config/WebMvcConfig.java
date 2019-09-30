package com.hqyj.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hqyj.demo.filter.ParameterFilter;
import com.hqyj.demo.interceptor.MyInterceptor;

/**
 * web mvc相关配置类
 */
@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private MyInterceptor myInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor).addPathPatterns("/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	/**
	 * 注册过滤器
	 */
	@Bean
	public FilterRegistrationBean<ParameterFilter> filterRegist() {
		FilterRegistrationBean<ParameterFilter> filterRegist = new FilterRegistrationBean<ParameterFilter>();
		filterRegist.setFilter(new ParameterFilter());
		return filterRegist;
	}
}
