package com.hqyj.erp.modules.organization.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.dao.AccountDao;
import com.hqyj.erp.modules.common.constant.SystemConstant;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.organization.dao.OrganizationDao;
import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.entity.Position;
import com.hqyj.erp.modules.organization.service.OrganizationService;
import com.hqyj.erp.modules.organization.vo.ZtreeModel;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private AccountDao accountDao;

	@Override
	public List<Department> getDepartments() {
		return organizationDao.getDepartments();
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
		if (departmentTemp != null && 
				(departmentTemp.getDepartId() != department.getDepartId() 
				|| department.getDepartId() <= 0)) {
			return new Result(500, "部门名称已经存在。");
		}
		
		try {
			if (department.getDepartId() > 0) {
				organizationDao.updateDepartment(department);
			} else {
				organizationDao.insertDepartment(department);
			}
			return new Result(200, "Insert or update success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Insert or update failed.");
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

	@Override
	public List<Position> getPositions() {
		return organizationDao.getPositions();
	}

	@Override
	public Position getPositionById(int positionId) {
		return organizationDao.getPositionById(positionId);
	}

	@Override
	public Result insertOrUpdatePosition(Position position) {
		Position positionTemp = organizationDao.getPositionByName(position.getPositionName());
		if (positionTemp != null && 
				(position.getPositionId() <=0 
				|| position.getPositionId() != positionTemp.getPositionId())) {
			return new Result(500, "职位名称已经存在。");
		}
		
		try {
			if (position.getPositionId() > 0) {
				organizationDao.updatePosition(position);
			} else {
				organizationDao.insertPosition(position);
			}
			return new Result(200, "操作成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "操作失败。");
		}
	}

	@Override
	public PageInfo<Position> getPositionsByPage(SearchVo searchVo) {
		searchVo.setCurrentPage(searchVo.getCurrentPage() > 0 ? 
				searchVo.getCurrentPage() : SystemConstant.DEFAULT_CURRENT_PAGE);
		searchVo.setPageSize(SystemConstant.DEFAULT_PAGE_SIZE);
		PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
		return new PageInfo<>(Optional.ofNullable(organizationDao.getPositions()).orElse(Collections.emptyList()));
	}

	@Override
	public Result deletePosition(int positionId) {
		try {
			organizationDao.deletePosition(positionId);
			return new Result(200, "Delete success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Delete failed.");
		}
	}

	@Override
	public List<Position> getPositionsByDepartId(int departId) {
		return organizationDao.getPositionsByDepartId(departId);
	}

	@Override
	public List<ZtreeModel> getOrgTree() {
		List<ZtreeModel> zTreeModel = accountDao.getOrgTree();
		zTreeModel.addAll(organizationDao.getOrgTree());
		return zTreeModel;
	}
}
