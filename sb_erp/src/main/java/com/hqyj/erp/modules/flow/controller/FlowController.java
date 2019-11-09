package com.hqyj.erp.modules.flow.controller;

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
import com.hqyj.erp.modules.flow.entity.Apply;
import com.hqyj.erp.modules.flow.service.FlowService;
import com.hqyj.erp.modules.property.constant.ApplyStatus;
import com.hqyj.erp.modules.property.constant.ApplyType;
import com.hqyj.erp.modules.property.constant.PropertyType;

@Controller
@RequestMapping("/flow")
public class FlowController {
	
	@Autowired
	private FlowService flowService;
	@Autowired
	private AccountService accountService;

	@RequestMapping("/applyListPage")
	public String applyListPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "flow/applyList";
	}
	
	@RequestMapping(value="/applies",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Apply> getApplies(@ModelAttribute SearchVo searchVo) {
		return flowService.getApplies(searchVo);
	}
	
	@RequestMapping("/addApplyPage")
	public String addApplyPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "flow/applyAdd";
	}
	
	@RequestMapping(value="/addApply", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addApply(@ModelAttribute Apply apply) {
		return flowService.insertOrUpdateApply(apply);
	}
	
	@RequestMapping("/editApplyPage")
	public String editApplyPage(@RequestParam int applyId, ModelMap modelMap) {
		modelMap.addAttribute("apply", flowService.getApplyById(applyId));
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "flow/applyEdit";
	}
	
	@RequestMapping(value="/editApply", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editApply(@ModelAttribute Apply apply) {
		return flowService.insertOrUpdateApply(apply);
	}
	
	@RequestMapping(value="/deleteApply", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deleteApply(@ModelAttribute Apply apply) {
		return flowService.deleteApply(apply.getApplyId());
	}
	
	@RequestMapping("/flowListPage")
	public String purchaseFlowPage(ModelMap modelMap) {
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		return "flow/flowList";
	}
	
	@RequestMapping("/editFlowPage")
	public String editFlowPage(@RequestParam int applyId, ModelMap modelMap) {
		modelMap.addAttribute("apply", flowService.getApplyById(applyId));
		modelMap.addAttribute("user", accountService.getUserBySubject());
		modelMap.addAttribute("propertyTypes", PropertyType.propertyTypes);
		modelMap.addAttribute("applyTypes", ApplyType.applyTypes);
		modelMap.addAttribute("applyStatus", ApplyStatus.applyStatus);
		return "flow/flowEdit";
	}
	
	@RequestMapping(value="/editFlow", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editFlow(@ModelAttribute Apply apply) {
		try {
			return flowService.updateApplyFlow(apply);
		} catch (ErpException e) {
			e.printStackTrace();
			return new Result(e.getStatus(), e.getReason());
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "操作失败。");
		}
	}
}
