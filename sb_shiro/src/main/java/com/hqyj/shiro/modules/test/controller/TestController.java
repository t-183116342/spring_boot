package com.hqyj.shiro.modules.test.controller;

import java.awt.MediaTracker;
import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.shiro.modules.test.entity.City;
import com.hqyj.shiro.modules.test.entity.Country;
import com.hqyj.shiro.modules.test.service.TestService;
import com.hqyj.shiro.modules.test.vo.ApplicationTest;

import junit.framework.Test;

@Controller
@RequestMapping("/test")
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
	@Autowired
	private TestService testService;
	
	@RequestMapping("/country")
	@ResponseBody
	public Country getCountryByName(@RequestParam String countryName) {
		return testService.getCountryByName(countryName);
	}
	
	@RequestMapping("/country/{countryId}")
	@ResponseBody
	public Country getCountry(@PathVariable int countryId) {
		return testService.getCountry(countryId);
	}
	
	@RequestMapping("/cities/{countryId}")
	@ResponseBody
	public List<City> getCities(@PathVariable int countryId){
		return testService.getCities(countryId);
	}
	
	@PostMapping("/post")
	@ResponseBody
	public String postTest() {
		return "This is post test.";
	}
	
	@RequestMapping("/log")
	@ResponseBody
	public String logInfo() {
		LOGGER.trace("This is trace log.");
		LOGGER.debug("This is debug log.");
		LOGGER.info("This is info log.");
		LOGGER.warn("This is warn log.");
		LOGGER.error("This is error log.");
		
		return "This is log test1111111.";
	}
	
	@RequestMapping("/config")
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

	@RequestMapping("/info")
	@ResponseBody
	public String appInfo() {
		return "This is spring boot shiro demo.aaaaaaaaaaaa";
	}
}
