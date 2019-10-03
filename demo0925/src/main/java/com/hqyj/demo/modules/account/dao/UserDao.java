package com.hqyj.demo.modules.account.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hqyj.demo.modules.account.entity.User;

@Repository
@Mapper
public interface UserDao {

	@Select("select * from m_user where user_name = #{userName}")
	User getUserByName(String userName);
	
	@Select("select * from m_user where user_name = #{userName} and password = #{password}")
	User getUserByNameAndPassword(User user);
	
	@Insert("insert m_user(user_name, password, create_date) "
			+ "value(#{userName}, #{password}, #{createDate})")
	@Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
	void addUser(User user);
}
