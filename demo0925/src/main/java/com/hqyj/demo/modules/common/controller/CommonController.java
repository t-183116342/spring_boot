package com.hqyj.demo.modules.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/error/403")
	public String authorizationErrorPage(ModelMap modelMap) {
		modelMap.put("template", "error/403");
		return "shiroIndex";
	}
}
