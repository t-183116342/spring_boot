package com.hqyj.erp.modules.authority.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.authority.dao.AuthorityDao;
import com.hqyj.erp.modules.authority.entity.Resource;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.authority.entity.RoleResource;
import com.hqyj.erp.modules.authority.service.AuthorityService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityDao authorityDao;

	@Override
	public List<Role> getRoles() {
		return authorityDao.getRoles();
	}

	@Override
	public Result insertOrUpdateRole(Role role) {
		Role roleTemp = authorityDao.getRoleByNmae(role.getRoleName());
		if (roleTemp != null && (role.getRoleId() <= 0 || roleTemp.getRoleId() != role.getRoleId())) {
			return new Result(500, "角色已经存在。");
		}
		
		try {
			if (role.getRoleId() > 0) {
				authorityDao.updateRole(role);
			} else {
				authorityDao.insertRole(role);
			}
			return new Result(200, "Insert or Update Role success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Insert or Update Role failed.");
		}
	}

	@Override
	public Role getRoleById(int roleId) {
		return authorityDao.getRoleById(roleId);
	}

	@Override
	public Result deleteRole(int roleId) {
		try {
			authorityDao.deleteRole(roleId);
			return new Result(200, "Delete success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Delete failed.");
		}
	}

	@Override
	public PageInfo<Resource> getResource(SearchVo resarchVo) {
		try {
			SearchVo.initSearchVo(resarchVo);
			PageHelper.startPage(resarchVo.getCurrentPage(), resarchVo.getPageSize());
			
			List<Resource> resources = Optional.ofNullable(
					authorityDao.getResources()).orElse(Collections.emptyList());
			return new PageInfo<>(resources);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>();
	}

	@Override
	public Resource getResourceById(int resourceId) {
		return authorityDao.getResourceById(resourceId);
	}

	@Override
	@Transactional
	public Result insertOrUpdateResource(Resource resource) {
		Resource resourceTemp = authorityDao.getResourceByName(resource.getResourceName());
		if (resourceTemp != null && 
				(resource.getResourceId() <= 0 || 
				(resource.getResourceId() != resourceTemp.getResourceId()))) {
			return Result.getResult(-1);
		}
		
		try {
			if (resource.getResourceId() > 0) {
				authorityDao.updateResource(resource);
			} else {
				authorityDao.insertResource(resource);
			}
			
			authorityDao.deleteRoleResource(resource.getResourceId());
			List<Role> roles = Optional.ofNullable(resource.getRoles()).orElse(Collections.emptyList());
			for (Role role : roles) {
				authorityDao.insertRoleResource(new RoleResource(role.getRoleId(), resource.getResourceId()));
			}
			return Result.getResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.getResult(0);
		}
	}

	@Override
	public Result deleteResource(int resourceId) {
		try {
			authorityDao.deleteResource(resourceId);
			authorityDao.deleteRoleResource(resourceId);
			return Result.getResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.getResult(0);
		}
	}

}
