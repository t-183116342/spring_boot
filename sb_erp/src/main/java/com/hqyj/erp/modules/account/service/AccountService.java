package com.hqyj.erp.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.vo.UserSearch;
import com.hqyj.erp.modules.common.vo.Result;

public interface AccountService {

	Result insertUser(User user);
	
	Result getUserResult(User user);
	
	User getUserBySession();
	
	User getUserByName(String account);
	
	User getUserById(int userId);
	
	PageInfo<User> getUserList(UserSearch userSearch);
	
	Result updateUserById(User user);
	
}
