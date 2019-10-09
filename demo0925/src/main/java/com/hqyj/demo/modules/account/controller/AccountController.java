package com.hqyj.demo.modules.account.controller;

import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.demo.common.Result;
import com.hqyj.demo.common.gifCaptcha.GifCaptcha;
import com.hqyj.demo.modules.account.entity.Resource;
import com.hqyj.demo.modules.account.entity.Role;
import com.hqyj.demo.modules.account.entity.User;
import com.hqyj.demo.modules.account.service.AccountService;

@Controller
@RequestMapping("/shiro")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	/**
	 * 跳转logoin页面
	 */
	@RequestMapping("/login")
	public String loginPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "shiro/login");
		return "shiroIndexSimple";
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value="/doLogin", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public Result doLogin(HttpServletRequest request, @RequestBody User user) {
		Result result = new Result(200, "success.");
		
		Subject subject = SecurityUtils.getSubject();
		try {
			// 登录验证，调用MyRealm中doGetAuthenticationInfo方法
			subject.login(new UsernamePasswordToken(user.getUserName(), user.getPassword()));
			// 授权，调用MyRealm中doGetAuthorizationInfo方法
			subject.checkRoles();
		} catch (Exception e) {
			result = new Result(500, e.getMessage());
			return result;
		}
		
		//存入Session
    	HttpSession session = request.getSession(true);
    	session.setAttribute("user", user);
		
		return result;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, ModelMap modelMap) {
    	SecurityUtils.getSubject().logout();
    	
		return "redirect:/shiro/login";
	}
	
	/**
	 * 跳转注册页面
	 */
	@RequestMapping("/register")
	public String registerPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "shiro/register");
		return "shiroIndexSimple";
	}
	
	/**
	 * 新增用户
	 */
	@RequestMapping(value="/doRegister", 
			method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public Result doRegister(HttpServletRequest request, @RequestBody User user) {
		Result result = accountService.addUser(user);
		
		//存入Session
    	HttpSession session = request.getSession(true);
    	session.setAttribute("user", user);
    	
		return result;
	}
	
	/**
	 * 跳转dashboard页面
	 */
	@RequestMapping("/dashboard")
	public String dashboardPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "shiro/dashboard");
		return "shiroIndex";
	}
	
	/**
	 * 跳转user页面
	 */
	@RequestMapping("/users")
	@RequiresRoles(value={"admin", "manager"}, logical=Logical.OR)
	public String usersPage(ModelMap modelMap) {
		
		modelMap.put("roles", accountService.getRoles());
		modelMap.put("users", accountService.getUsers());
		modelMap.put("template", "shiro/users");
		return "shiroIndex";
	}
	
	/**
	 * 编辑user
	 */
	@RequestMapping(value="/editUser", 
			method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public Result editUser(@RequestBody User user) {
		return accountService.editUser(user);
	}
	
	/**
	 * 删除user
	 * shiro常见注解
	 * @RequiresAuthentication : 表示当前 Subject 已经认证登录的用户才能调用的代码块。
	 * @RequiresUser : 表示当前 Subject 已经身份验证或通过记住我登录的。
	 * @RequiresGuest : 表示当前 Subject 没有身份验证，即是游客身份。
	 * @RequiresRoles(value={"admin", "user"}, logical=Logical.AND)
	 * @RequiresPermissions (value={"***","***"}, logical= Logical.OR) 
	 */
	@RequestMapping("/deleteUser/{userId}")
	@RequiresPermissions("user:delete")
	public String deleteUser(@PathVariable("userId") int userId) {
		accountService.deleteUser(userId);
		return "redirect:/shiro/users";
	}
	
	/**
	 * 跳转roles页面
	 */
	@RequestMapping("/roles")
	public String rolesPage(ModelMap modelMap) {
		modelMap.put("roles", accountService.getRoles());
		modelMap.put("template", "shiro/roles");
		return "shiroIndex";
	}
	
	/**
	 * 根据userId获取role list
	 */
	@RequestMapping("/roles/user/{userId}")
	@ResponseBody
	public List<Role> getRolesByUserId(@PathVariable("userId") int userId) {
		return accountService.getRolesByUserId(userId);
	}
	
	/**
	 * 根据resourceId获取role list
	 */
	@RequestMapping("/roles/resource/{resourceId}")
	@ResponseBody
	public List<Role> getRolesByResourceId(@PathVariable("resourceId") int resourceId) {
		return accountService.getRolesByResourceId(resourceId);
	}
	
	/**
	 * 新增或修改role
	 */
	@RequestMapping(value="/editRole", 
			method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public Result editRole(@RequestBody Role role) {
		return accountService.editRole(role);
	}
	
	/**
	 * 删除role
	 */
	@RequestMapping("/deleteRole/{roleId}")
	public String deleteRole(@PathVariable("roleId") int roleId) {
		accountService.deleteRole(roleId);;
		return "redirect:/shiro/roles";
	}
	
	/**
	 * 跳转resources页面
	 */
	@RequestMapping("/resources")
	public String resourcesPage(ModelMap modelMap) {
		modelMap.put("roles", accountService.getRoles());
		modelMap.put("resources", accountService.getResources());
		modelMap.put("template", "shiro/resources");
		return "shiroIndex";
	}
	
	/**
	 * 新增或编辑resource
	 */
	@RequestMapping(value="/editResource", 
			method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public Result editResource(@RequestBody Resource resource) {
		return accountService.editResource(resource);
	}
	
	/**
	 * 删除resource
	 */
	@RequestMapping("/deleteResource/{resourceId}")
	public String deleteResource(@PathVariable("resourceId") int resourceId) {
		accountService.deleteResource(resourceId);
		return "redirect:/shiro/resources";
	}
	
	/**
	 * 生成动态验证码
	 * $("#codePic").bind("click", function() {
	 * 	$("#codePic").attr("src", "/getGifCode?flag=" + Math.random());
	 * });
	 */
	@RequestMapping(value="/getGifCode",method=RequestMethod.GET)
	public void getGifCode(HttpServletResponse response, HttpServletRequest request){
		// 设定response相关信息
		response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        
        GifCaptcha gifCaptcha = new GifCaptcha(146, 33, new Font("宋体", Font.BOLD, 20), 100);
        try {
        	//存入Session
        	HttpSession session = request.getSession(true);
        	session.setAttribute("captchaWord", gifCaptcha.getWord());
        	
        	// 输出gif图片
            gifCaptcha.out(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
