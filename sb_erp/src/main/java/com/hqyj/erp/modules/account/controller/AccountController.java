package com.hqyj.erp.modules.account.controller;

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
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
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

	@PostMapping(value="/doRegister", consumes="application/json")
	@ResponseBody
	public Result doRegister(@RequestBody User user) {
		return accountService.insertUser(user);
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
		return "account/userEdit";
	}
	
	@PostMapping(value="/doUserEdit",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doUserEdit(@ModelAttribute User user) {
		return accountService.updateUserById(user);
	}
	
	@RequestMapping("/userAdd")
	public String userAddPage() {
		return "account/userAdd";
	}
	
	@PostMapping(value="/doUserAdd",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doUserAdd(@ModelAttribute User user) {
		return accountService.insertUser(user);
	}
}
