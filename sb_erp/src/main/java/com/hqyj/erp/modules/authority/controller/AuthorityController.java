package com.hqyj.erp.modules.authority.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.erp.modules.authority.service.AuthorityService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.entity.Role;

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
		return authorityService.insertRole(role);
	}
	
	@RequestMapping("/roleUpdate")
	public String roleUpdatePage() {
		return "authority/roleUpdate";
	}
	
}
