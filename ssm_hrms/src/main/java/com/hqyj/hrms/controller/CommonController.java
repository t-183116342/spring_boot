package com.hqyj.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/login")
	public String login() {
		return "common/login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "common/register";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/wellcome")
	public String wellcome() {
		return "common/wellcome";
	}
}