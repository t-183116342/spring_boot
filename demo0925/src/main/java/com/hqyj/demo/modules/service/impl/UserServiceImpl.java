package com.hqyj.demo.modules.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.demo.common.Result;
import com.hqyj.demo.modules.account.dao.UserDao;
import com.hqyj.demo.modules.account.entity.User;
import com.hqyj.demo.modules.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}

	@Override
	public Result getUserByNameAndPassword(User user) {
		User userTemp = userDao.getUserByNameAndPassword(user);
		if (userTemp == null) {
			return new Result(201, "User name or password error.");
		}
		
		return new Result(200, "success", userTemp);
	}

	@Override
	public Result addUser(User user) {
		if (user == null) {
			return new Result(201, "User info is null");
		}
		
		User userTemp = userDao.getUserByName(user.getUserName());
		if (userTemp != null) {
			return new Result(201, "User name exist.");
		}
		
		user.setCreateDate(new Date());
		userDao.addUser(user);
		
		return new Result(200, "success", user);
	}

}
