package com.hqyj.erp.modules.account.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户职位表
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "user_position")
public class UserPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userPositionId;
	private int userId;
	private int positionId;

	public int getUserPositionId() {
		return userPositionId;
	}

	public void setUserPositionId(int userPositionId) {
		this.userPositionId = userPositionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
}
