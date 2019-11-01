package com.hqyj.erp.modules.organization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.service.OrganizationService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.organization.dao.OrganizationDao;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public List<Department> geDepartments() {
		return organizationDao.geDepartments();
	}

	@Override
	public Department getDepartmentById(int departId) {
		return organizationDao.getDepartmentById(departId);
	}

	@Override
	public Department getDepartmentByName(String departName) {
		return organizationDao.getDepartmentByName(departName);
	}

	@Override
	public Result insertOrUpdateDepartment(Department department) {
		Department departmentTemp = organizationDao.getDepartmentByName(department.getDepartName());
		
		try {
			if (department.getDepartId() > 0) {
				if (departmentTemp != null && departmentTemp.getDepartId() != department.getDepartId()) {
					return new Result(500, "部门名称已经存在。");
				}
				organizationDao.updateDepartment(department);
			} else {
				if (departmentTemp != null) {
					return new Result(500, "部门名称已经存在。");
				}
				organizationDao.insertDepartment(department);
			}
			return new Result(200, "Edit success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Edit failed.");
		}
	}

	@Override
	public Result deleteDepartment(int departId) {
		try {
			organizationDao.deleteDepartment(departId);
			return new Result(200, "Delete success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Delete failed.");
		}
	}

}
