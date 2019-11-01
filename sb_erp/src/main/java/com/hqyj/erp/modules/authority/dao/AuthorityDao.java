package com.hqyj.erp.modules.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.organization.entity.Role;

@Repository
@Mapper
public interface AuthorityDao {

	@Select("select * from role")
	List<Role> getRoles();
	
	@Insert("insert into role(role_name, role_desc) values(#{roleName}, #{roleDesc})")
	void insertRole(Role role);
}
