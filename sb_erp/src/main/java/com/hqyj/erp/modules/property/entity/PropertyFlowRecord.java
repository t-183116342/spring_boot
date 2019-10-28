package com.hqyj.erp.modules.property.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 资产流动记录
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "property_flow_record")
public class PropertyFlowRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyFlowRecordId;
	private String propertyName;
	private String propertyModel;
	private Integer propertyNum;
	private String applyName;
	private String purchaseName;
	private Date applyTime;
	private Date purchaseTime;

	public int getPropertyFlowRecordId() {
		return propertyFlowRecordId;
	}

	public void setPropertyFlowRecordId(int propertyFlowRecordId) {
		this.propertyFlowRecordId = propertyFlowRecordId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyModel() {
		return propertyModel;
	}

	public void setPropertyModel(String propertyModel) {
		this.propertyModel = propertyModel;
	}

	public Integer getPropertyNum() {
		return propertyNum;
	}

	public void setPropertyNum(Integer propertyNum) {
		this.propertyNum = propertyNum;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getPurchaseName() {
		return purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
}
