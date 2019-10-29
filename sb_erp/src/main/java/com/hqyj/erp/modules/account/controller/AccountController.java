package com.hqyj.erp.modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.erp.common.Result;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@RequestMapping("/login")
	public String loginPage() {
		return "account/login";
	}
	
	@RequestMapping("/register")
	public String registerPage() {
		return "account/register";
	}
	
	@RequestMapping("/index")
	public String indexPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "common/wellcome");
		return "index";
	}
	
	@PostMapping(value="/account/doRegister", consumes="application/json")
	@ResponseBody
	public Result doRegister(@RequestBody User user) {
		return accountService.insertUser(user);
	}
	
	@PostMapping(value="/account/doLogin", consumes="application/json")
	@ResponseBody
	public Result doLogin(@RequestBody User user) {
		return accountService.getUserResult(user);
	}
	
	@RequestMapping("/account/userList")
	public String userList(ModelMap modelMap) {
		modelMap.addAttribute("template", "account/userList");
		return "indexSimple";
	}
}
