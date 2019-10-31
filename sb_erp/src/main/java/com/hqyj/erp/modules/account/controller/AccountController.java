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
import com.hqyj.erp.modules.account.vo.UserSearch;
import com.hqyj.erp.modules.common.vo.Result;

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
	public String userListPage() {
		return "account/userList";
	}
	
	@PostMapping(value="/searchUser", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<User> searchUser(@ModelAttribute UserSearch userSearch) {
		PageInfo<User> users = accountService.getUserList(userSearch);
		return users;
	}
	
	@RequestMapping("/userEdit")
	public String userEditPage(@RequestParam int userId, ModelMap modelMap) {
		User user = accountService.getUserById(userId);
		modelMap.addAttribute("user", user);
		return "account/userEdit";
	}
	
	@PostMapping(value="/doUserEdit",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doUserEdit(@ModelAttribute User user) {
		return accountService.updateUserById(user);
	}
}
