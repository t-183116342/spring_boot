package com.hqyj.demo.modules.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.demo.modules.test.vo.ApplicationTestBean;

@Controller
public class TestController {
	
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
	private ApplicationTestBean applicationTestBean;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/test/log")
	@ResponseBody
	public String loggerTest() {
		LOGGER.trace("This is trace log");
		LOGGER.debug("This is debug log");
		LOGGER.info("This is info log");
		LOGGER.warn("This is warn log");
		LOGGER.error("This is error log");
		
		return "This is logger test.";
	}

	@RequestMapping("/test/config")
	@ResponseBody
	public String configTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("----").append("<br>")
			.append(name).append("----").append("<br>")
			.append(age).append("----").append("<br>")
			.append(description).append("----").append("<br>")
			.append(random).append("----").append("<br>");
		
		sb.append(applicationTestBean.getName()).append("----").append("<br>")
			.append(applicationTestBean.getAge()).append("----").append("<br>")
			.append(applicationTestBean.getDescription()).append("----").append("<br>")
			.append(applicationTestBean.getRandom()).append("----").append("<br>");
		return sb.toString();
	}
	
	@RequestMapping("/test/info")
	@ResponseBody
	public String testInfo() {
		return "This is spring boot app.";
	}
}
