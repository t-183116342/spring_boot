package com.hqyj.demo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hqyj.demo.filter.UrlFilter;

@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig {

	@Bean
	public FilterRegistrationBean<UrlFilter> filterRegist() {
		FilterRegistrationBean<UrlFilter> filterRegist = new FilterRegistrationBean<UrlFilter>();
		filterRegist.setFilter(new UrlFilter());
		return filterRegist;
	}
}
