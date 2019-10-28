package com.hqyj.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hrms")
public class AccountController {

	@RequestMapping("/login")
	public String login() {
		return "/main";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "/register";
	}
}
