package com.hqyj.erp.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.vo.UserSearch;
import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.entity.Position;

@Repository
@Mapper
public interface AccountDao {
	
	@Insert("insert user(account, password) values(#{account}, #{password})")
	@Options(useGeneratedKeys=true,keyColumn="user_id",keyProperty="userId")
	void insertUser(User user);
	
	@Select("select * from position p "
			+ "left join user_position up on p.position_id = up.position_id "
			+ "where up.user_id = #{userId}")
	Position getPositionByUserId(int userId);
	
	@Select("select * from department d "
			+ "left join position p on d.depart_id = p.depart_id "
			+ "left join user_position up on p.position_id = up.position_id "
			+ "where up.user_id = #{userId}")
	Department getDepartmentByUserId(int userId);
	
	@Select("select * from user where account = #{account}")
	@Results(id="userResult", value={
		@Result(column="user_id", property="userId"),
		@Result(column="user_id",property="position",
			javaType=Position.class,
			one=@One(select="com.hqyj.erp.modules.account.dao.AccountDao.getPositionByUserId")),
		@Result(column="user_id",property="department",
			javaType=Department.class,
			one=@One(select="com.hqyj.erp.modules.account.dao.AccountDao.getDepartmentByUserId"))
	})
	User getUserByName(String account);
	
	@Select("select * from user where user_id = #{userId}")
	@ResultMap(value="userResult")
	User getUserById(int userId);
	
//	@Select("<script>" + 
//			"select * from user u "
//			+ "left join user_position up on u.user_id = up.user_id "
//			+ "left join position p on p.position_id = up.position_id "
//			+ "left join department d on d.depart_id = p.depart_id "
//			+ "<where> "
//				+ " 1=1 "
//				+ "<if test='userDepart != null and userDepart != '''>"
//				+ "and d.depart_name = #{userDepart} "
//				+ "</if>"
//				+ "<if test='entryStart!=null and entryStart!='''>"
//				+ "and u.user_entrytime >= #{entryEnd} "
//				+ "</if>"
//				+ "<if test='birthRange!=null and birthRange!='''>"
//				+ "AND DATE_FORMAT(`user`.user_birthday,'%m%d') "
//					+ "BETWEEN DATE_FORMAT(NOW(),'%m%d') AND "
//					+ "DATE_FORMAT(DATE_ADD(NOW(),INTERVAL #{birthRange,jdbcType=VARCHAR} DAY),'%m%d')"
//				+ "</if>"
//				+ "<if test='userName!=null and userName!='''>"
//				+ "and u..user_name LIKE '%${userName}% "
//				+ "</if>"
//			+ "</where>"
//			+ "</script>")
	@Select("select * from user")
	@ResultMap(value="userResult")
	List<User> getUserListBySearch(UserSearch userSearch);
	
	@Update("<script> " +
	        "select * from user " +
	        "<if test='password!=null'> password = #{password},</if>" +
	        "user_name=#{userName}," + 
	        "user_sex=#{userSex}," + 
	        "user_telephone=#{userTelephone}," + 
	        "user_email=#{userEmail}," + 
	        "user_address=#{userAddress}," + 
	        "user_birthday=#{userBirthday}," + 
	        "user_diploma=#{userDiploma}," + 
	        "user_entrytime=#{userEntrytime}," + 
	        "user_status=#{userStatus}," + 
	        "user_position=#{userPosition}," + 
	        "user_departement=#{userDepartement} " + 
	        "where user_id = #{userId} " +
	        "</script>")
	@ResultMap(value="userResult")
	List<User> getUserListBySearch1(UserSearch userSearch);
	
	@Update("<script> " +
        "update user set " +
        "<if test='password!=null'> password = #{password},</if>" +
        "user_name=#{userName}," + 
        "user_sex=#{userSex}," + 
        "user_telephone=#{userTelephone}," + 
        "user_email=#{userEmail}," + 
        "user_address=#{userAddress}," + 
        "user_birthday=#{userBirthday}," + 
        "user_diploma=#{userDiploma}," + 
        "user_entrytime=#{userEntrytime}," + 
        "user_status=#{userStatus}," + 
        "user_position=#{userPosition}," + 
        "user_departement=#{userDepartement} " + 
        "where user_id = #{userId} " +
        "</script>")
	void updateUserById(User user);

}
