package com.hqyj.erp.modules.property.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.authority.entity.Resource;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.constant.PropertyType;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;
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

	@RequestMapping("/grantProperty")
	public String grantPropertyPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		return "property/grantProperty";
	}
	
	@RequestMapping(value="/grantProperties",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<GrantProperty> grantProperties(@ModelAttribute SearchVo searchVo) {
		return propertyService.getGrantProperties(searchVo);
	}
	
	@RequestMapping("/propertyApply")
	public String propertyApplyPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "property/propertyApply");
		return "indexSimple";
	}
	
	@RequestMapping("/propertyPurchase")
	public String propertyPurchasePage(ModelMap modelMap) {
		modelMap.addAttribute("template", "property/propertyPurchase");
		return "indexSimple";
	}
	
	@RequestMapping("/propertyDiscard")
	public String propertyDiscardPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "property/propertyDiscard");
		return "indexSimple";
	}
	
	@RequestMapping("/purchaseFlow")
	public String purchaseFlowPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "property/purchaseFlow");
		return "indexSimple";
	}
	
	@RequestMapping("/applyFlow")
	public String applyFlowPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "property/applyFlow");
		return "indexSimple";
	}
	
	@RequestMapping("/discardFlow")
	public String discardFlowPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "property/discardFlow");
		return "indexSimple";
	}
	
	@RequestMapping("/propertyList")
	public String propertyListPage(ModelMap modelMap) {
		return "property/propertyList";
	}
	
	@RequestMapping("/propertyAdd")
	public String propertyAddPage(ModelMap modelMap) {
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		return "property/propertyAdd";
	}
	
	@RequestMapping(value="/doPropertyAdd", consumes="application/x-www-form-urlencoded")
	public Result addProperty(@ModelAttribute Property property) {
		return new Result();
	}
	
	@RequestMapping("/propertyRecord")
	public String propertyRecordPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "property/propertyRecord");
		return "indexSimple";
	}
}
