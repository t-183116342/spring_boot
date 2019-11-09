package com.hqyj.erp.modules.property.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.constant.PropertyType;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;
import com.hqyj.erp.modules.property.entity.ScrapProperty;
import com.hqyj.erp.modules.property.service.PropertyService;

/**
 * 资产相关控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
@RequestMapping("/property")
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private AccountService accountService;

	@RequestMapping("/grantPropertyListPage")
	public String grantPropertyListPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		return "property/grantPropertyList";
	}
	
	@RequestMapping(value="/grantProperties",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<GrantProperty> grantProperties(@ModelAttribute SearchVo searchVo) {
		return propertyService.getGrantProperties(searchVo);
	}
	
	@RequestMapping("/scrapPropertyListPage")
	public String scrapPropertyListPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		return "property/scrapPropertyList";
	}
	
	@RequestMapping(value="/scrapProperties",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<ScrapProperty> scrapProperties(@ModelAttribute SearchVo searchVo) {
		return propertyService.getScrapProperties(searchVo);
	}
	
	@RequestMapping("/propertyListPage")
	public String propertyListPage(ModelMap modelMap) {
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		return "property/propertyList";
	}
	
	@RequestMapping(value="/properties",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Property> properties(@ModelAttribute SearchVo searchVo) {
		return propertyService.getProperties(searchVo);
	}
	
}
