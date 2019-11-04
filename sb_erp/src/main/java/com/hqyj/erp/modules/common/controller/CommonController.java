package com.hqyj.erp.modules.common.controller;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.common.vo.Result;

/**
 * 公共页面控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
public class CommonController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);
	
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
	
	@PostMapping(value="/doRegister", consumes="application/json")
	@ResponseBody
	public Result doRegister(@RequestBody User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	@PostMapping(value="/doLogin", consumes="application/json")
	@ResponseBody
	public Result doLogin(@RequestBody User user) {
		return accountService.getUserResult(user);
	}
	
	@RequestMapping("/loginOut")
	public String loginOut() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "common/login";
	}
	
	@RequestMapping("/index")
	public String indexPage(HttpServletRequest request, ModelMap modelMap) {
		
	    Subject subject = SecurityUtils.getSubject();
	    LOGGER.debug("------------------" + SecurityUtils.getSubject().isRemembered());
	    LOGGER.debug("------------------" + SecurityUtils.getSubject().isAuthenticated());
	    
		User user = accountService.getUserByName((String)subject.getPrincipal());
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
