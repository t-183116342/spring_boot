package com.hqyj.demo.modules.account.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hqyj.demo.modules.account.entity.User;

@Repository
public interface UserDao {

	@Select("select * from m_user where user_name = #{userName}")
	User getUserByName(String userName);
	
	@Insert("insert m_user(user_name, password)")
	User addUser();
}
