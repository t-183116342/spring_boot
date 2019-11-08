package com.hqyj.erp.modules.property.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.exception.ErpException;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.constant.ApplyStatus;
import com.hqyj.erp.modules.property.constant.ApplyType;
import com.hqyj.erp.modules.property.constant.PropertyType;
import com.hqyj.erp.modules.property.entity.Apply;
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
	
	@RequestMapping("/applyListPage")
	public String applyListPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "property/applyList";
	}
	
	@RequestMapping(value="/applies",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Apply> getApplies(@ModelAttribute SearchVo searchVo) {
		return propertyService.getApplies(searchVo);
	}
	
	@RequestMapping("/addApplyPage")
	public String addApplyPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "property/applyAdd";
	}
	
	@RequestMapping(value="/addApply", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addApply(@ModelAttribute Apply apply) {
		return propertyService.insertOrUpdateApply(apply);
	}
	
	@RequestMapping("/editApplyPage")
	public String editApplyPage(@RequestParam int applyId, ModelMap modelMap) {
		modelMap.addAttribute("apply", propertyService.getApplyById(applyId));
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "property/applyEdit";
	}
	
	@RequestMapping(value="/editApply", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editApply(@ModelAttribute Apply apply) {
		return propertyService.insertOrUpdateApply(apply);
	}
	
	@RequestMapping(value="/deleteApply", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deleteApply(@ModelAttribute Apply apply) {
		return propertyService.deleteApply(apply.getApplyId());
	}
	
	@RequestMapping("/flowListPage")
	public String purchaseFlowPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "property/flowList";
	}
	
	@RequestMapping("/editFlowPage")
	public String editFlowPage(@RequestParam int applyId, ModelMap modelMap) {
		modelMap.addAttribute("apply", propertyService.getApplyById(applyId));
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		modelMap.addAttribute("applyStatus", ApplyStatus.applyStatus);
		return "property/flowEdit";
	}
	
	@RequestMapping(value="/editFlow", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editFlow(@ModelAttribute Apply apply) {
		try {
			return propertyService.updateApplyFlow(apply);
		} catch (ErpException e) {
			e.printStackTrace();
			return new Result(e.getStatus(), e.getReason());
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "操作失败。");
		}
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
