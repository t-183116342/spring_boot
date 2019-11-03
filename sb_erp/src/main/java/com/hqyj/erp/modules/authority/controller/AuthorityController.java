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

	@RequestMapping("/roleAuthPage")
	public String rolePage(ModelMap modelMap) {
		modelMap.addAttribute("template", "authority/roleAuthPage");
		return "indexSimple";
	}
	
	@RequestMapping("/departmentAuthPage")
	public String departmentPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "authority/departmentAuthPage");
		return "indexSimple";
	}
	
	@RequestMapping("/roleList")
	public String roleListPage(ModelMap modelMap) {
		modelMap.addAttribute("roles", authorityService.getRoles());
		return "authority/roleList";
	}
	
	@RequestMapping("/roleAdd")
	public String roleAddPage() {
		return "authority/roleAdd";
	}
	
	@PostMapping(value="/doRoleAdd",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doRoleAdd(@ModelAttribute Role role) {
		return authorityService.insertOrUpdateRole(role);
	}
	
	@RequestMapping("/roleEdit")
	public String roleEditPage(@RequestParam int roleId, ModelMap modelMap) {
		modelMap.addAttribute("role", authorityService.getRoleById(roleId));
		return "authority/roleEdit";
	}
	
	@PostMapping(value="/doRoleEdit",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doRoleEdit(@ModelAttribute Role role) {
		return authorityService.insertOrUpdateRole(role);
	}
	
	@PostMapping(value="/doRoleDelete",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doRoleDelete(@ModelAttribute Role role) {
		return authorityService.deleteRole(role.getRoleId());
	}
	
	@RequestMapping("/resourceList")
	public String resourceListPage() {
		return "authority/resourceList";
	}
	
	@RequestMapping(value="/resourcesByPage",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<Resource> resourcesByPage(@ModelAttribute SearchVo searchVo) {
		return authorityService.getResource(searchVo);
	}
	
	@RequestMapping("/resourceAdd")
	public String resourceAddPage(ModelMap modelMap) {
		modelMap.addAttribute("roles", authorityService.getRoles());
		return "authority/resourceAdd";
	}
	
	@PostMapping(value="/doPositionAdd",consumes="application/json")
	@ResponseBody
	public Result doPositionAdd(@RequestBody Resource resource) {
		return authorityService.insertOrUpdateResource(resource);
	}
	
	@RequestMapping("/resourceEdit")
	public String resourceEditPage(@RequestParam int resourceId, ModelMap modelMap) {
		Resource resource = authorityService.getResourceById(resourceId);
		modelMap.addAttribute("resource", resource);
		modelMap.addAttribute("roles", Role.composeRoleList(authorityService.getRoles(), resource.getRoles()));
		return "authority/resourceEdit";
	}
	
	@PostMapping(value="/doResourceEdit",consumes="application/json")
	@ResponseBody
	public Result doResourceEdit(@RequestBody Resource resource) {
		return authorityService.insertOrUpdateResource(resource);
	}
	
	@PostMapping(value="/doResourceDelete",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doResourceDelete(@ModelAttribute Resource resource) {
		return authorityService.deleteResource(resource.getResourceId());
	}
}
