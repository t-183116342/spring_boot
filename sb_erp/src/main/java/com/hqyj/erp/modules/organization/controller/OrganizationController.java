package com.hqyj.erp.modules.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.service.OrganizationService;
import com.hqyj.erp.modules.common.vo.Result;

/**
 * 公司组织控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;

	@RequestMapping("/structure")
	public String structure() {
		return "organization/structure";
	}
	
	@RequestMapping("/departmentList")
	public String departmentList(ModelMap modelMap) {
		modelMap.addAttribute("departments", organizationService.geDepartments());
		return "organization/departmentList";
	}
	
	@RequestMapping("/departmentAdd")
	public String departmentAdd() {
		return "organization/departmentAdd";
	}
	
	@PostMapping(value="/doDepartmentAdd",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doDepartmentAdd(@ModelAttribute Department department) {
		return organizationService.insertOrUpdateDepartment(department);
	}
	
	@RequestMapping("/departmentUpdate")
	public String departmentEdit(@RequestParam int departId, ModelMap modelMap) {
		modelMap.addAttribute("department", organizationService.getDepartmentById(departId));
		return "organization/departmentEdit";
	}
	
	@PostMapping(value="/doDepartmentUpdate",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doDepartmentUpdate(@ModelAttribute Department department) {
		return organizationService.insertOrUpdateDepartment(department);
	}
	
	@PostMapping(value="/doDepartmentDelete",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doDepartmentDelete(@ModelAttribute Department department) {
		return organizationService.deleteDepartment(department.getDepartId());
	}
	
	
}
