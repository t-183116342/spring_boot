package com.hqyj.demo.modules.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.demo.modules.test.entity.City;
import com.hqyj.demo.modules.test.entity.Country;
import com.hqyj.demo.modules.test.service.CityAndCountryService;
import com.hqyj.demo.modules.test.vo.ApplicationConfigTest;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@Value("${server.port}")
	private int port;
	@Value("${com.hqyj.name}")
	private String name;
	
	@Autowired
	private ApplicationConfigTest configTest;
	@Autowired
	private CityAndCountryService cityAndCountryService;
	
	/**
	 * thymeleaf 测试页面，数据处理
	 */
	@RequestMapping("/testPage")
	public String testPage(ModelMap modelMap) {
		int countryId = 522;
		Country country = cityAndCountryService.getCountry(countryId);
		List<City> cities = cityAndCountryService.getCitiesByCountryId(countryId);
		cities = cities.stream().limit(10).collect(Collectors.toList());
		
		modelMap.addAttribute("checked", true);
		modelMap.addAttribute("currentNumber", 99);
		modelMap.addAttribute("changeType", "checkbox");
		modelMap.addAttribute("baiduUrl", "/test/config");
//		modelMap.addAttribute("shopLogo", "http://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
		modelMap.addAttribute("country", country);
		modelMap.addAttribute("cities", cities);
		modelMap.addAttribute("updateCityUri", "/test/updateCityByForm");
		modelMap.addAttribute("city", cities.get(0));
		
		modelMap.addAttribute("thymeleafTitle", "This is thymeleaf page.");
		
		modelMap.addAttribute("template", "test");
		return "index";
	}
	
	/**
	 * 通过form表单更新city对象
	 */
	@RequestMapping(value="/updateCityByForm", 
			method=RequestMethod.POST, consumes="application/x-www-form-urlencoded")
	public String updateCityByForm(@ModelAttribute("city") City city) {
		cityAndCountryService.updateCity(city);
		return "redirect:/test/testPage";
	}
	
	/**
	 * 通过json字符串更新city对象
	 */
	@RequestMapping(value="/city", method=RequestMethod.PUT, consumes="application/json")
	@ResponseBody
	public void updateCityByJoson(@RequestBody City city) {
		cityAndCountryService.updateCity(city);
	}
	
	/**
	 * countryName 作为 URL查询参数，方法参数使用 @RequestParam注解
	 */
	@RequestMapping("/country")
	@ResponseBody
	public Country getCountryByName(@RequestParam("countryName") String countryName) {
		return cityAndCountryService.getCountryByName(countryName);
	}
	
	/**
	 * id 作为 uri 一部分，方法参数使用 @PathVariable 注解
	 */
	@RequestMapping("/country/{countryId}")
	@ResponseBody
	public Country getCountry(@PathVariable("countryId") int countryId) {
		return cityAndCountryService.getCountry(countryId);
	}
	
	@RequestMapping("/cities/{countryId}")
	@ResponseBody
	public List<City> getCitiesByCountryId(@PathVariable("countryId") int countryId) {
		return cityAndCountryService.getCitiesByCountryId(countryId);
	}
	
	/**
	 * log测试
	 */
	@RequestMapping("/logInfo")
	@ResponseBody
	public String getLogInfo() {
		LOGGER.trace("This is trace log.");
		LOGGER.debug("This is debug log.");
		LOGGER.info("This is info log.");
		LOGGER.warn("This is warn log.");
		LOGGER.error("This is error log.");
		
		return "log test.";
	}
	
	/**
	 * post测试
	 */
	@RequestMapping(value="/bean", method=RequestMethod.POST)
	@ResponseBody
	public void updateBean() {
		System.out.println("This is post test.");
	}
	
	/**
	 * 配置文件测试
	 */
	@RequestMapping("/config")
	@ResponseBody
	public String getConfig() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("--").append(name).append("<br/>");
		
		sb.append(configTest.getName())
			.append("--").append(configTest.getAge())
			.append("--").append(configTest.getRandom());
		
		sb.append("333-------------------------");
		return sb.toString();
	}

	/**
	 * 普通接口测试
	 */
	@RequestMapping("/info")
	@ResponseBody
	public String getInfo(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("This is spring boot demo app.")
			.append(request.getParameter("keyWord"));
		
		return sb.toString();
	}
}
