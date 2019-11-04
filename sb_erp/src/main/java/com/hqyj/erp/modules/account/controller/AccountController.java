package com.hqyj.erp.modules.account.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.authority.service.AuthorityService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.service.OrganizationService;

/**
 * 账户相关控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private AuthorityService authorityService;

	@PostMapping(value="/doRegister", consumes="application/json")
	@ResponseBody
	public Result doRegister(@RequestBody User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	@PostMapping(value="/doLogin", consumes="application/json")
	@ResponseBody
	public Result doLogin(@RequestBody User user) {
		return accountService.getUserResult(user);
	}
	
	@RequestMapping("/userList")
	public String userListPage(ModelMap modelMap) {
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "account/userList";
	}
	
	@PostMapping(value="/userListForPage", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<User> userListForPage(@ModelAttribute SearchVo userSearch) {
		PageInfo<User> users = accountService.getUserList(userSearch);
		return users;
	}
	
	@RequestMapping("/userEdit")
	public String userEditPage(@RequestParam int userId, ModelMap modelMap) {
		User user = accountService.getUserById(userId);
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("departments", organizationService.getDepartments());
		modelMap.addAttribute("positions", 
				organizationService.getPositionsByDepartName(user.getUserDepartement()));
		modelMap.addAttribute("roles", Role.composeRoleList(authorityService.getRoles(), user.getRoles()));
		return "account/userEdit";
	}
	
	@PostMapping(value="/doUserEdit",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doUserEdit(@ModelAttribute User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	@RequestMapping("/userAdd")
	public String userAddPage(ModelMap modelMap) {
		List<Department> departments = Optional.ofNullable(
				organizationService.getDepartments()).orElse(Collections.emptyList());
		modelMap.addAttribute("departments", departments);
		if (departments.size() > 0) {
			modelMap.addAttribute("positions", 
					organizationService.getPositionsByDepartName(departments.get(0).getDepartName()));
		}
		modelMap.addAttribute("roles", authorityService.getRoles());
		return "account/userAdd";
	}
	
	@PostMapping(value="/doUserAdd",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doUserAdd(@ModelAttribute User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	@PostMapping(value="/doUserDelete",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doUserDelete(@ModelAttribute User user) {
		return accountService.deleteUserById(user.getUserId());
	}
}
