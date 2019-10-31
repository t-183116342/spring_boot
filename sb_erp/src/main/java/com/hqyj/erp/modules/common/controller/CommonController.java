package com.hqyj.erp.modules.common.controller;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;

/**
 * 公共页面控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
public class CommonController {
	
	@Autowired
	private AccountService accountService;

	@RequestMapping("/login")
	public String loginPage() {
		return "common/login";
	}
	
	@RequestMapping("/register")
	public String registerPage() {
		return "common/register";
	}
	
	@RequestMapping("/index")
	public String indexPage(HttpServletRequest request, ModelMap modelMap) {
		User user = accountService.getUserBySession();
		if (user == null) {
			return "common/login";
		}
		
		String ipAddress = null;
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			ipAddress = inetAddress.getHostAddress();
		} catch (Exception e) {
			ipAddress = "无法获取ip";
		}
		
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("userIp", ipAddress);
		modelMap.addAttribute("localIp", ipAddress);
		modelMap.addAttribute("template", "common/wellcome");
		
		return "index";
	}
}
