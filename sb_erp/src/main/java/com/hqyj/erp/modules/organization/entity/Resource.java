package com.hqyj.erp.modules.organization.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 资源表
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "resource")
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resourceId;
	private String resourceName;
	private String resourceDescription;
	private String resourceUrl;

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
}
