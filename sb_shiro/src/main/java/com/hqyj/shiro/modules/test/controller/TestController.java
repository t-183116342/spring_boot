package com.hqyj.shiro.modules.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.shiro.modules.test.entity.City;
import com.hqyj.shiro.modules.test.entity.Country;
import com.hqyj.shiro.modules.test.service.TestService;
import com.hqyj.shiro.modules.test.vo.ApplicationTest;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	// 针对 application.properties文件，直接使用@Value注解获得属性值
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
	
	// 针对其他配置文件，注入其对应的配置类
	@Autowired
	private ApplicationTest applicationTest;
	@Autowired
	private TestService testService;
	
	@RequestMapping("/testPage")
	public String testPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "test/index");
		return "index";
	}
	
	@DeleteMapping("/city/{cityId}")
	@ResponseBody
	public int deleteCity(@PathVariable int cityId) {
		return testService.deleteCity(cityId);
	}
	
	/**
	 * @RequestBody ---- 接受 json 数据
	 */
	@PutMapping(value="/city",consumes="application/json")
	@ResponseBody
	public City updateCity(@RequestBody City city) {
		testService.updateCity(city);
		return city;
	}
	
	/**
	 * @ModelAttribute ---- 接受 form数据
	 */
	@PutMapping(value="/city2",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public City updateCity2(@ModelAttribute City city) {
		testService.updateCity(city);
		return city;
	}
	
	/**
	 * consumes ---- 进入方法的数据类型
	 * produces ---- 方法返回数据类型
	 * 常见类型（application/json、application/x-www-form-urlencoded）
	 * @RequestBody ---- 接受 json 数据
	 * 
	 */
	@PostMapping("/city")
	@ResponseBody
	public City insertCity(@RequestBody City city) {
		testService.insertCity(city);
		return city;
	}
	
	/**
	 * @RequestParam：URL查询参数
	 */
	@RequestMapping(value="/country",consumes="application/json")
	@ResponseBody
	public Country getCountryByName(@RequestParam String countryName) {
		return testService.getCountryByName(countryName);
	}
	
	/**
	 * @PathVariable：URL path参数
	 */
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
