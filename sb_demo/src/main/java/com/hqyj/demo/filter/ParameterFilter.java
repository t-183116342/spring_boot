package com.hqyj.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 参数过滤器，过滤参数中的敏感字符串
 * @author: HymanHu
 * @date: 2019年11月29日
 */
@WebFilter(filterName="parameterFilter", urlPatterns="/**")
public class ParameterFilter implements Filter {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ParameterFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.debug("This is parameter filter init.");
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		LOGGER.debug("This is parameter filter destroy.");
		Filter.super.destroy();
	}

	/* 
	 * 修改request请求中的参数
	 * HttpServletRequest中的请求信息是locked状态，我们无法直接操作
	 * 我们使用HttpServletRequestWrapper对请求信息做处理
	 * 继续优化，自定义wrapper类，继承HttpServletRequestWrapper，重写实现方法……
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		Map<String, String[]> maps = httpRequest.getParameterMap();
//		maps.put("key", new String[]{"*******"});
		
		HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpRequest) {

			@Override
			public String getParameter(String name) {
				String value = httpRequest.getParameter(name);
				if (StringUtils.isNotBlank(value)) {
					return value.replace("fuck", "****");
				}
				return super.getParameter(name);
			}

			@Override
			public String[] getParameterValues(String name) {
				String[] values = httpRequest.getParameterValues(name);
				if (values != null && values.length > 0) {
					values[0] = values[0].replace("fuck", "*****");
					return values;
				}
				return super.getParameterValues(name);
			}
			
		};
		
		chain.doFilter(wrapper, response);
	}

}
