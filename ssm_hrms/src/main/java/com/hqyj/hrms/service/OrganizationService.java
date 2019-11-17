package com.hqyj.hrms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hqyj.hrms.entity.Department;
import com.hqyj.hrms.entity.Position;
import com.hqyj.hrms.vo.Result;
import com.hqyj.hrms.vo.SearchVo;
import com.hqyj.hrms.vo.ZtreeModel;

/**
 * Organization Service
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public interface OrganizationService {

	List<Department> getDepartments();
	
	Department getDepartmentById(int departId);
	
	Department getDepartmentByName(String departName);
	
	Result insertOrUpdateDepartment(Department department);
	
	Result deleteDepartment(int departId);
	
	List<Position> getPositions();
	
	Position getPositionById(int positionId);
	
	Result insertOrUpdatePosition(Position position);
	
	PageInfo<Position> getPositionsByPage(SearchVo searchVo);
	
	Result deletePosition(int positionId);
	
	List<Position> getPositionsByDepartId(int departId);
	
	List<ZtreeModel> getOrgTree();
}
