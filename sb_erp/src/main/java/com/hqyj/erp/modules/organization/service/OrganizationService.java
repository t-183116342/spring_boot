package com.hqyj.erp.modules.organization.service;

import java.util.List;

import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.organization.entity.Department;

public interface OrganizationService {

	List<Department> geDepartments();
	
	Department getDepartmentById(int departId);
	
	Department getDepartmentByName(String departName);
	
	Result insertOrUpdateDepartment(Department department);
	
	Result deleteDepartment(int departId);
}
