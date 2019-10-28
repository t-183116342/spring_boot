package com.hqyj.erp.modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@PostMapping(value="/account/doRegister", consumes="application/json")
	@ResponseBody
	public Result doRegister(@RequestBody User user) {
		return accountService.insertUser(user);
	}
}
