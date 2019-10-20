package com.hqyj.shiro.modules.test.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.github.pagehelper.PageInfo;
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
	
	/**
	 * thymeleaf 
	 */
	@RequestMapping("/index")
	public String testIndex(ModelMap modelMap) {
		int countryId = 522;
		Country country = testService.getCountry(countryId);
		List<City> cities = testService.getCities(countryId);
		cities = cities.stream().limit(10).collect(Collectors.toList());
		
		modelMap.addAttribute("thymeleafTitle", "wellcome thymeleaf");
		modelMap.addAttribute("checked", true);
		modelMap.addAttribute("currentNumber", 111);
		modelMap.addAttribute("changeType", "checkbox");
		modelMap.addAttribute("baiduUrl", "www.baidu.com");
//		modelMap.addAttribute("shopLogo", "https://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
		modelMap.addAttribute("country", country);
		modelMap.addAttribute("cities", cities);
		modelMap.addAttribute("city", cities.get(0));
		modelMap.addAttribute("updateCityUri", "/test/city2");
		modelMap.addAttribute("template", "test/index");
		
		return "index";
	}
	
	@DeleteMapping("/city/{cityId}")
	@ResponseBody
	public int deleteCity(@PathVariable int cityId) {
		return testService.deleteCity(cityId);
	}
	
	@PutMapping(value="/city2",consumes="application/x-www-form-urlencoded")
	public String updateCity2(@ModelAttribute City city) {
		testService.updateCity(city);
		return "redirect:/test/index";
	}
	
	@PutMapping(value="/city",consumes="application/json")
	@ResponseBody
	public City updateCity(@RequestBody City city) {
		testService.updateCity(city);
		return city;
	}
	
	/**
	 * @RequestBody ---- 接受 form 数据
	 */
	@PostMapping(value="/city2",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public City insertCity2(@ModelAttribute City city) {
		testService.insertCity(city);
		return city;
	}
	
	/**
	 * consumes ---- 进入方法的数据类型
	 * produces ---- 方法返回数据类型
	 * 常见类型（application/json、application/x-www-form-urlencoded）
	 * @RequestBody ---- 接受 json 数据
	 */
	@PostMapping(value="/city",consumes="application/json")
	@ResponseBody
	public City insertCity(@RequestBody City city) {
		testService.insertCity(city);
		return city;
	}
	
	@RequestMapping("/page/cities")
	@ResponseBody
	PageInfo<City> getCitiesByPage(@RequestParam int currentPage, @RequestParam int pageSize) {
		return testService.getCitiesByPage(currentPage, pageSize);
	}
	
	/**
	 * @RequestParam：URL查询参数
	 */
	@RequestMapping(value="/country")
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
