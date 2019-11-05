package com.hqyj.erp.modules.property.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资产相关控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
@RequestMapping("/property")
public class PropertyController {

	@RequestMapping("/userProperty")
	public String userPropertyPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "property/userProperty");
		return "indexSimple";
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
	
	@RequestMapping("/propertyRecord")
	public String propertyRecordPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "property/propertyRecord");
		return "indexSimple";
	}
}
