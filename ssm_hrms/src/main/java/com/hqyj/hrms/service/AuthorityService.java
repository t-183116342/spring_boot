package com.hqyj.hrms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hqyj.hrms.entity.Resource;
import com.hqyj.hrms.entity.Role;
import com.hqyj.hrms.vo.Result;
import com.hqyj.hrms.vo.SearchVo;

/**
 * Authority Service
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public interface AuthorityService {

	List<Role> getRoles();
	
	PageInfo<Role> getRoles(SearchVo resarchVo);
	
	Result insertOrUpdateRole(Role role);
	
	Role getRoleById(int roleId);
	
	Result deleteRole(int roleId);
	
	List<Resource> getResourcesByRoleId(int roleId);
	
	PageInfo<Resource> getResources(SearchVo resarchVo);
	
	Resource getResourceById(int resourceId);
	
	Result insertOrUpdateResource(Resource resource);
	
	Result deleteResource(int resourceId);
	
	List<Role> getRolesByUserId(int userId);
}
