package com.hqyj.erp.modules.account.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.util.MD5Util;

/**
 * 用户表
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String account;
	private String password;
	private String userName;
	private String userSex;
	private String userTelephone;
	private String userEmail;
	private String userAddress;
	private Date userBirthday;
	// 学历
	private String userDiploma;
	// 入职时间
	private Date userEntrytime;
	private String userPosition;
	private String userDepartement;
	
	@Transient
	private List<Role> roles;
	@Transient
	private Integer[] userRoles;
	
	public void initUser(User user) {
		user.setPassword(MD5Util.getMD5(user.getPassword()));
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserDiploma() {
		return userDiploma;
	}

	public void setUserDiploma(String userDiploma) {
		this.userDiploma = userDiploma;
	}

	public Date getUserEntrytime() {
		return userEntrytime;
	}

	public void setUserEntrytime(Date userEntrytime) {
		this.userEntrytime = userEntrytime;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserDepartement() {
		return userDepartement;
	}

	public void setUserDepartement(String userDepartement) {
		this.userDepartement = userDepartement;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer[] getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Integer[] userRoles) {
		this.userRoles = userRoles;
	}
}
