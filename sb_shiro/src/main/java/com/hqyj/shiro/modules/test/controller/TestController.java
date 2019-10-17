package com.hqyj.shiro.modules.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.shiro.modules.test.vo.ApplicationTest;

@Controller
public class TestController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@Value("${server.port}")
	private int port;
	@Value("${com.hqyj.name}")
	private String name;
	@Value("${com.hqyj.age}")
	private int age;
	@Value("${com.hqyj.description}")
	private String description;
	@Value("${com.hqyj.random}")
	private String random;
	
	@Autowired
	private ApplicationTest applicationTest;
	
	@RequestMapping("/test/log")
	@ResponseBody
	public String logInfo() {
		LOGGER.trace("This is trace log.");
		LOGGER.debug("This is debug log.");
		LOGGER.info("This is info log.");
		LOGGER.warn("This is warn log.");
		LOGGER.error("This is error log.");
		
		return "This is log test.";
	}
	
	@RequestMapping("/test/config")
	@ResponseBody
	public String configInfo() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("----")
			.append(name).append("----")
			.append(age).append("----")
			.append(description).append("----")
			.append(random).append("<br/>");
		sb.append(applicationTest.getName()).append("----")
			.append(applicationTest.getAge()).append("----")
			.append(applicationTest.getDescription()).append("----")
			.append(applicationTest.getRandom());
		
		return sb.toString();
	}

	@RequestMapping("/test/info")
	@ResponseBody
	public String appInfo() {
		return "This is spring boot shiro demo.";
	}
}
