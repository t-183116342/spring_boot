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
import com.hqyj.erp.modules.organization.vo.ZtreeModel;

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
	
	@RequestMapping("/departmentListPage")
	public String departmentListPage(ModelMap modelMap) {
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "organization/departmentList";
	}
	
	@RequestMapping("/addDepartmentPage")
	public String addDepartmentPage() {
		return "organization/departmentAdd";
	}
	
	@PostMapping(value="/addDepartment",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addDepartment(@ModelAttribute Department department) {
		return organizationService.insertOrUpdateDepartment(department);
	}
	
	@RequestMapping("/updateDepartmentPage")
	public String updateDepartmentPage(@RequestParam int departId, ModelMap modelMap) {
		modelMap.addAttribute("department", organizationService.getDepartmentById(departId));
		return "organization/departmentEdit";
	}
	
	@PostMapping(value="/updateDepartment",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result updateDepartment(@ModelAttribute Department department) {
		return organizationService.insertOrUpdateDepartment(department);
	}
	
	@PostMapping(value="/deleteDepartment",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deleteDepartment(@ModelAttribute Department department) {
		return organizationService.deleteDepartment(department.getDepartId());
	}
	
	@RequestMapping("/positionListPage")
	public String positionListPage(ModelMap modelMap) {
		modelMap.addAttribute("positions", organizationService.getPositions());
		return "organization/positionList";
	}
	
	@PostMapping(value="/positions", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Position> positions(@ModelAttribute SearchVo userSearch) {
		return organizationService.getPositionsByPage(userSearch);
	}
	
	@RequestMapping("/editPositionPage")
	public String editPositionPage(@RequestParam int positionId, ModelMap modelMap) {
		modelMap.addAttribute("position", organizationService.getPositionById(positionId));
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "organization/positionEdit";
	}
	
	@PostMapping(value="/editPosition",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editPosition(@ModelAttribute Position position) {
		return organizationService.insertOrUpdatePosition(position);
	}
	
	@RequestMapping("/addPositionPage")
	public String addPositionPage(ModelMap modelMap) {
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "organization/positionAdd";
	}
	
	@PostMapping(value="/addPosition",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addPosition(@ModelAttribute Position position) {
		return organizationService.insertOrUpdatePosition(position);
	}
	
	@PostMapping(value="/deletePosition",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deletePosition(@ModelAttribute Position position) {
		return organizationService.deletePosition(position.getPositionId());
	}
	
	@RequestMapping(value="/positionsByDepart", consumes="application/json")
	@ResponseBody
	public List<Position> positionsByDepart(@RequestParam int departId) {
		return organizationService.getPositionsByDepartId(departId);
	}
	
	@PostMapping(value="/getOrgTree")
	@ResponseBody
	public List<ZtreeModel> getOrgTree(@ModelAttribute Position position) {
		return organizationService.getOrgTree();
	}
	
}
