package com.hqyj.erp.modules.property.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * （资产、采购、报废）申请
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "apply")
public class Apply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applyId;
	// 申请类别，1-资产申请；2-采购申请；3-报废申请
	private int applyType;
	private String propertyName;
	private String propertyModel;
	private int propertyNum;
	private double propertyPrice;
	private double propertyTotalPrice;
	private String approveState;
	// 申请人
	private int applyUser;
	// 批准人
	private int purchaseUser;
	private Date applyTime;
	private Date purchaseTime;

	public int getApplyId() {
		return applyId;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public int getApplyType() {
		return applyType;
	}

	public void setApplyType(int applyType) {
		this.applyType = applyType;
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

	public int getPropertyNum() {
		return propertyNum;
	}

	public void setPropertyNum(int propertyNum) {
		this.propertyNum = propertyNum;
	}

	public double getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public double getPropertyTotalPrice() {
		return propertyTotalPrice;
	}

	public void setPropertyTotalPrice(double propertyTotalPrice) {
		this.propertyTotalPrice = propertyTotalPrice;
	}

	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}

	public int getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(int applyUser) {
		this.applyUser = applyUser;
	}

	public int getPurchaseUser() {
		return purchaseUser;
	}

	public void setPurchaseUser(int purchaseUser) {
		this.purchaseUser = purchaseUser;
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
