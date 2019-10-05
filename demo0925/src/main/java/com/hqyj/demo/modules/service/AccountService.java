package com.hqyj.demo.modules.service;

import java.util.List;

import com.hqyj.demo.common.Result;
import com.hqyj.demo.modules.account.entity.Resource;
import com.hqyj.demo.modules.account.entity.Role;
import com.hqyj.demo.modules.account.entity.User;

public interface AccountService {

	// 根据userName查询user
	User getUserByName(String userName);
	
	// 根据userName和password查询user
	Result getUserByNameAndPassword(User user);
	
	// 添加user
	Result addUser(User user);
	
	// 编辑user
	Result editUser(User user);
	
	// 删除user
	void deleteUser(int userId);
	
	// 获取user列表
	List<User> getUsers();
	
	// 新增或修改role
	Result editRole(Role role);
	
	// 删除role
	void deleteRole(int roleId);
	
	// 获取role list
	List<Role> getRoles();
	
	// 根据userId获取role list
	List<Role> getRolesByUserId(int userId);
	
	// 新增或修改resource
	Result editResource(Resource resource);
	
	// 删除资源
	void deleteResource(int resourceId);
	
	// 获取资源列表
	List<Resource> getResources();
	
}
