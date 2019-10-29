package com.hqyj.erp.modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.common.entity.Result;

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
	public String userList(ModelMap modelMap) {
		modelMap.addAttribute("template", "account/userList");
		return "indexSimple";
	}
}
