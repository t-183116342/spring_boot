package com.hqyj.erp.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;

public interface AccountService {

	Result inserOrUpdatetUser(User user);
	
	Result getUserResult(User user);
	
	User getUserBySubject();
	
	User getUserByName(String account);
	
	User getUserById(int userId);
	
	PageInfo<User> getUserList(SearchVo userSearch);
	
	Result deleteUserById(int userId);
	
}
