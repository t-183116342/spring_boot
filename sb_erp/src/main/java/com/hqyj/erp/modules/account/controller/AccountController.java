package com.hqyj.erp.modules.account.controller;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.authority.service.AuthorityService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.service.OrganizationService;

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
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping("/userList")
	public String userListPage(ModelMap modelMap) {
		modelMap.addAttribute("departments", organizationService.getDepartments());
		return "account/userList";
	}
	
	@PostMapping(value="/getUserById", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public User getUserById(@ModelAttribute User user) {
		return accountService.getUserById(user.getUserId());
	}
	
	@PostMapping(value="/userListForPage", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<User> userListForPage(@ModelAttribute SearchVo userSearch) {
		PageInfo<User> users = accountService.getUserList(userSearch);
		return users;
	}
	
	@RequestMapping("/userEdit")
	public String userEditPage(@RequestParam int userId, ModelMap modelMap) {
		User user = accountService.getUserById(userId);
		List<Department> departments = Optional.ofNullable(
				organizationService.getDepartments()).orElse(Collections.emptyList());
		String departName = StringUtils.isBlank(user.getUserDepartement()) ? 
				departments.get(0).getDepartName() : user.getUserDepartement();
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("departments", departments);
		modelMap.addAttribute("positions", 
				organizationService.getPositionsByDepartName(departName));
		modelMap.addAttribute("roles", Role.composeRoleList(authorityService.getRoles(), user.getRoles()));
		return "account/userEdit";
	}
	
	@PostMapping(value="/doUserEdit",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doUserEdit(@ModelAttribute User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	@RequestMapping("/userAdd")
	public String userAddPage(ModelMap modelMap) {
		List<Department> departments = Optional.ofNullable(
				organizationService.getDepartments()).orElse(Collections.emptyList());
		modelMap.addAttribute("departments", departments);
		if (departments.size() > 0) {
			modelMap.addAttribute("positions", 
					organizationService.getPositionsByDepartName(departments.get(0).getDepartName()));
		}
		modelMap.addAttribute("roles", authorityService.getRoles());
		return "account/userAdd";
	}
	
	@PostMapping(value="/doUserAdd",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result doUserAdd(@ModelAttribute User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	@PostMapping(value="/doUserDelete",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	@RequiresPermissions("deleteUser")
	public Result doUserDelete(@ModelAttribute User user) {
		return accountService.deleteUserById(user.getUserId());
	}
	
	@PostMapping(value="/upload",consumes="multipart/form-data")
	@ResponseBody
	public Result uploadFile(@RequestParam MultipartFile file) {
		if (file.isEmpty()) {
			return new Result(500, "file is null.");
		}
		
		String destPath = "D:/upload/" + file.getOriginalFilename();
		try {
			File destFile = new File(destPath);
			file.transferTo(destFile);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Upload file fail.");
		}
		
		return new Result(200, "Upload file success.", "/upload/" + file.getOriginalFilename());
	}
}
