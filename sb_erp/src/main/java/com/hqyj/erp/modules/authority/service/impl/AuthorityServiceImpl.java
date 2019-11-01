package com.hqyj.erp.modules.authority.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.erp.modules.authority.dao.AuthorityDao;
import com.hqyj.erp.modules.authority.service.AuthorityService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.organization.entity.Role;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityDao authorityDao;

	@Override
	public List<Role> getRoles() {
		return authorityDao.getRoles();
	}

	@Override
	public Result insertRole(Role role) {
		try {
			authorityDao.insertRole(role);
			return new Result(200, "Insert Role success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Insert Role failed.");
		}
	}

}
