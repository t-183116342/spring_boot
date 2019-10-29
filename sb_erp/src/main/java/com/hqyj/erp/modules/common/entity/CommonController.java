package com.hqyj.erp.modules.common.entity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共页面控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
public class CommonController {

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
}
