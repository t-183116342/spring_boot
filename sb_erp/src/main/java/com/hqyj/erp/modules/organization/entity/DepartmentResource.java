package com.hqyj.erp.modules.organization.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门资源表
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "department_resource")
public class DepartmentResource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentResourceId;
	private int departId;
	private int resourceId;

	public int getDepartmentResourceId() {
		return departmentResourceId;
	}

	public void setDepartmentResourceId(int departmentResourceId) {
		this.departmentResourceId = departmentResourceId;
	}

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
}
