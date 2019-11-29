package com.hqyj.demo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hqyj.demo.filter.ParameterFilter;

/**
 * web mvc相关配置类
 * @author: HymanHu
 * @date: 2019年11月29日
 */
@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig {

	/**
	 * 注册“参数过滤器”
	 */
	@Bean
	public FilterRegistrationBean<ParameterFilter> parameterFilter() {
		FilterRegistrationBean<ParameterFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new ParameterFilter());
		return filterRegistrationBean;
	}
}
