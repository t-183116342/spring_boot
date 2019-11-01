package com.hqyj.erp.modules.authority.service;

import java.util.List;

import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.organization.entity.Role;

public interface AuthorityService {

	List<Role> getRoles();
	
	Result insertRole(Role role);
}
