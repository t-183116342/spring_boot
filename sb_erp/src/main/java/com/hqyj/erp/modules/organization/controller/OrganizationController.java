package com.hqyj.erp.modules.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.entity.Position;
import com.hqyj.erp.modules.organization.service.OrganizationService;

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
		modelMap.addAttribute("departments", organizationService.getDepartments());
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
	
	@RequestMapping("/positionList")
	public String positionList(ModelMap modelMap) {
		modelMap.addAttribute("positions", organizationService.getPositions());
		return "organization/positionList";
	}
	
	@PostMapping(value="/positionsByPage", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Position> positionsByPage(@ModelAttribute SearchVo userSearch) {
		return organizationService.getPositionsByPage(userSearch);
	}
	
	@RequestMapping("/positionAdd")
	public String positionAdd(ModelMap modelMap) {
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "organization/positionAdd";
	}
	
	@PostMapping(value="/doPositionAdd",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doPositionAdd(@ModelAttribute Position position) {
		return organizationService.insertOrUpdatePosition(position);
	}
	
	@PostMapping(value="/doPositionDelete",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doPositionDelete(@ModelAttribute Position position) {
		return organizationService.deletePosition(position.getPositionId());
	}
	
	@RequestMapping(value="/positionsByDepart", consumes="application/json")
	@ResponseBody
	public List<Position> getPositionsByDepartName(@RequestParam String departName) {
		return organizationService.getPositionsByDepartName(departName);
	}
	
}
