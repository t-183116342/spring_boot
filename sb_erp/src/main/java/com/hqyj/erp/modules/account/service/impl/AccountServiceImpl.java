package com.hqyj.erp.modules.account.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.erp.common.Result;
import com.hqyj.erp.modules.account.dao.AccountDao;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public Result insertUser(User user) {
		Result result;
		user.setUserStatus(1);
		try {
			accountDao.insertUser(user);
			result = new Result(200, "insert User success.", user);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
			result = new Result(500, "insert User fail.");
		}
		
		return result;
	}

}
