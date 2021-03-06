package com.hqyj.shiro.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义过滤器，过滤掉url查询参数中的某些字符
 * 实现步骤：继承Filter ---- 重写doFilter方法 ---- 在配置类中注册FilterRegistrationBean
 */
@WebFilter(filterName="urlFilter",urlPatterns="/**")
public class UrlFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("innit filter.------------------");
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		System.out.println("destroy filter.---------------------");
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
//		Map<String, String[]> paraMap = httpRequest.getParameterMap();
//		paraMap.put("key", new String[]{"***"});
		
		HttpServletRequestWrapper warpper = new HttpServletRequestWrapper(httpRequest) {
			@Override
			public String getParameter(String name) {
				String value = httpRequest.getParameter(name);
				if (null != value) {
					return value.replace("fuck", "***");
				}
				
				return super.getParameter(name);
			}

			/* 
			 * 过滤 @RequestParam
			 * HandlerMethodInvoker ---- resolveRequestParam
			 */
			@Override
			public String[] getParameterValues(String name) {
				String[] values = super.getParameterValues(name);
				if (values != null && values.length > 0) {
					values[0] = values[0].replace("fuck", "***");
					return values;
				}
				
				return super.getParameterValues(name);
			}

//			@Override
//			public Map<String, String[]> getParameterMap() {
//				Map<String, String[]> paraMap = httpRequest.getParameterMap();
//				if (!paraMap.isEmpty()) {
//					Iterator<String> iterator = paraMap.keySet().iterator();
//					while(iterator.hasNext()) {
//						String key = iterator.next();
//						String[] values = paraMap.get(key);
//						values[0] = values[0].replace("fuck", "***");
//					}
//				}
//				return paraMap;
//			}
		};
		
		chain.doFilter(warpper, response);
	}

}
