package com.hqyj.hrms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门表
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="depart_id")
	private int departId;
	@Column(name="depart_name")
	private String departName;
	@Column(name="depart_desc")
	private String departDesc;

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartDesc() {
		return departDesc;
	}

	public void setDepartDesc(String departDesc) {
		this.departDesc = departDesc;
	}
}
