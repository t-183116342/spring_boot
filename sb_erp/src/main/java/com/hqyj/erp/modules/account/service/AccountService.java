package com.hqyj.erp.modules.account.service;

import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.common.entity.Result;

public interface AccountService {

	Result insertUser(User user);
	
	Result getUserResult(User user);
}
