package com.hqyj.erp.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.common.vo.SearchVo;

@Repository
@Mapper
public interface AccountDao {
	
	@Insert("insert user(account, password, user_name, user_sex, "
			+ "user_telephone, user_email, user_address, user_birthday, "
			+ "user_diploma, user_entrytime, user_position, user_departement, user_status) "
			+ "values(#{account}, #{password}, #{userName}, #{userSex}, "
			+ "#{userTelephone}, #{userEmail}, #{userAddress}, #{userBirthday}, #{userDiploma}, "
			+ "#{userEntrytime}, #{userPosition}, #{userDepartement}, #{userStatus})")
	@Options(useGeneratedKeys=true,keyColumn="user_id",keyProperty="userId")
	void insertUser(User user);
	
	@Select("select * from user where account = #{account}")
	User getUserByName(String account);
	
	@Select("select * from user where user_id = #{userId}")
	User getUserById(int userId);
	
	@Select("<script>" + 
			"select * from user u "
			+ "<where> "
			+ "<if test='userDepart != \"\" and userDepart != null'>"
			+ "and u.user_departement = #{userDepart} "
			+ "</if>"
			+ "<if test='entryStart!=\"\" and entryStart!=null'>"
			+ "and u.user_entrytime >= #{entryEnd} "
			+ "</if>"
			+ "<if test='birthRange!=\"\" and birthRange!=null'>"
			+ "AND DATE_FORMAT(`user`.user_birthday,'%m%d') "
				+ "BETWEEN DATE_FORMAT(NOW(),'%m%d') AND "
				+ "DATE_FORMAT(DATE_ADD(NOW(),INTERVAL #{birthRange,jdbcType=VARCHAR} DAY),'%m%d')"
			+ "</if>"
			+ "<if test='userName!=\"\" and userName!=null'>"
			+ "and u.user_name LIKE '%${userName}%' "
			+ "</if>"
			+ "</where>"
			+ "</script>")
	List<User> getUserListBySearch(SearchVo userSearch);
	
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
