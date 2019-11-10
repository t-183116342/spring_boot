package com.hqyj.erp.modules.authority.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.authority.entity.Resource;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.authority.service.AuthorityService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;

/**
 * 授权控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping("/roleListPage")
	public String roleListPage(ModelMap modelMap) {
		modelMap.addAttribute("roles", authorityService.getRoles());
		return "authority/roleList";
	}
	
	@RequestMapping("/addRolePage")
	public String addRolePage() {
		return "authority/roleAdd";
	}
	
	@PostMapping(value="/addRole",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addRole(@ModelAttribute Role role) {
		return authorityService.insertOrUpdateRole(role);
	}
	
	@RequestMapping("/editRolePage")
	public String editRolePage(@RequestParam int roleId, ModelMap modelMap) {
		modelMap.addAttribute("role", authorityService.getRoleById(roleId));
		return "authority/roleEdit";
	}
	
	@PostMapping(value="/editRole",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editRole(@ModelAttribute Role role) {
		return authorityService.insertOrUpdateRole(role);
	}
	
	@PostMapping(value="/deleteRole",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deleteRole(@ModelAttribute Role role) {
		return authorityService.deleteRole(role.getRoleId());
	}
	
	@RequestMapping("/resourceListPage")
	public String resourceListPage() {
		return "authority/resourceList";
	}
	
	@RequestMapping(value="/resources",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Resource> resources(@ModelAttribute SearchVo searchVo) {
		return authorityService.getResource(searchVo);
	}
	
	@RequestMapping("/addResourcePage")
	public String addResourcePage(ModelMap modelMap) {
		modelMap.addAttribute("roles", authorityService.getRoles());
		return "authority/resourceAdd";
	}
	
	@PostMapping(value="/addResource",consumes="application/json")
	@ResponseBody
	public Result addResource(@RequestBody Resource resource) {
		return authorityService.insertOrUpdateResource(resource);
	}
	
	@RequestMapping("/editResourcePage")
	public String editResourcePage(@RequestParam int resourceId, ModelMap modelMap) {
		Resource resource = authorityService.getResourceById(resourceId);
		modelMap.addAttribute("resource", resource);
		modelMap.addAttribute("roles", Role.composeRoleList(authorityService.getRoles(), resource.getRoles()));
		return "authority/resourceEdit";
	}
	
	@PostMapping(value="/editResource",consumes="application/json")
	@ResponseBody
	public Result editResource(@RequestBody Resource resource) {
		return authorityService.insertOrUpdateResource(resource);
	}
	
	@PostMapping(value="/deleteResource",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result deleteResource(@ModelAttribute Resource resource) {
		return authorityService.deleteResource(resource.getResourceId());
	}
}
