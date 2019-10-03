package com.hqyj.demo.modules.service;

import com.hqyj.demo.common.Result;
import com.hqyj.demo.modules.account.entity.User;

public interface UserService {

	User getUserByName(String userName);
	
	Result getUserByNameAndPassword(User user);
	
	Result addUser(User user);
}
