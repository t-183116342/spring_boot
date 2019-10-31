package com.hqyj.erp.modules.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.dao.AccountDao;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.account.vo.UserSearch;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SystemConstant;
import com.hqyj.erp.util.MD5Util;

@Service
public class AccountServiceImpl implements AccountService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public Result insertUser(User user) {
		if (user == null || StringUtils.isBlank(user.getAccount()) 
				|| StringUtils.isBlank(user.getPassword())) {
			return new Result(500, "User name or password is null.");
		}
		
		User existUser = accountDao.getUserByName(user.getAccount());
		if (existUser != null) {
			return new Result(500, "User is exist.");
		}
		
		try {
			user.setPassword(MD5Util.getMD5(user.getPassword()));
			accountDao.insertUser(user);
			return new Result(200, "insert User success.", user);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
			return new Result(500, "insert User fail.");
		}
	}

	@Override
	public Result getUserResult(User user) {
		Subject subject = SecurityUtils.getSubject();
		try {
			// 登录验证，调用MyRealm中doGetAuthenticationInfo方法
			subject.login(new UsernamePasswordToken(user.getAccount(), MD5Util.getMD5(user.getPassword())));
			
			// 授权，调用MyRealm中doGetAuthorizationInfo方法
//			subject.checkRoles();
			
			subject.getSession().setAttribute(SystemConstant.USER_KEY, user);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, e.getMessage());
		}
		
		return new Result(200, "success");
	}

	@Override
	public User getUserBySession() {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession().getAttribute(SystemConstant.USER_KEY);
		return user;
	}

	@Override
	public User getUserByName(String account) {
		return accountDao.getUserByName(account);
	}

	@Override
	public User getUserById(int userId) {
		return accountDao.getUserById(userId);
	}

	@Override
	public PageInfo<User> getUserList(UserSearch userSearch) {
		List<User> users = new ArrayList<>();
		
		if (userSearch == null) {
			User user = getUserBySession();
			users.add(user);
		} else {
			userSearch.setCurrentPage(userSearch.getCurrentPage() > 0 ? userSearch.getCurrentPage() : SystemConstant.DEFAULT_CURRENT_PAGE);
			userSearch.setPageSize(SystemConstant.DEFAULT_PAGE_SIZE);
			PageHelper.startPage(userSearch.getCurrentPage(), userSearch.getPageSize());
			users = accountDao.getUserListBySearch(userSearch);
		}
		
		return new PageInfo<>(users);
	}

	@Override
	public Result updateUserById(User user) {
		if (StringUtils.isNoneBlank(user.getPassword())) {
			user.setPassword(MD5Util.getMD5(user.getPassword()));
		}
		
		try {
			accountDao.updateUserById(user);
			return new Result(200, "修改成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "修改失败。");
		}
	}

}
