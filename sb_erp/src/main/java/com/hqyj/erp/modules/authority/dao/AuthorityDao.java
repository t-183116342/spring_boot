package com.hqyj.erp.modules.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.authority.entity.Resource;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.authority.entity.RoleResource;
import com.hqyj.erp.modules.authority.entity.UserRole;

@Repository
@Mapper
public interface AuthorityDao {

	@Select("select * from role")
	List<Role> getRoles();
	
	@Select("select * from role where role_id=#{roleId}")
	Role getRoleById(int roleId);
	
	@Select("select * from role where role_name=#{roleName}")
	Role getRoleByNmae(String roleName);
	
	@Insert("insert into role(role_name, role_desc) values(#{roleName}, #{roleDesc})")
	void insertRole(Role role);
	
	@Update("update role set role_name=#{roleName}, role_desc=#{roleDesc} where role_id=#{roleId}")
	void updateRole(Role role);
	
	@Delete("delete from role where role_id=#{roleId}")
	void deleteRole(int roleId);
	
	@Select("select * from role r "
			+ "left join role_resource rr on r.role_id = rr.role_id "
			+ "where rr.resource_id = #{resourceId}")
	List<Role> getRolesByResourceId(int resourceId);
	
	@Select("select * from resource")
	List<Resource> getResources();
	
	@Select("select * from resource where resource_id=#{resourceId}")
	@Results(id="resourceResult", value={
		@Result(column="resource_id", property="resourceId"),
		@Result(column="resource_id",property="roles",
				javaType=List.class,
				many=@Many(select="com.hqyj.erp.modules.authority.dao.AuthorityDao.getRolesByResourceId"))
	})
	Resource getResourceById(int resourceId);
	
	@Select("select * from resource where resource_name=#{resource_name}")
	@ResultMap(value="resourceResult")
	Resource getResourceByName(String resourceName);
	
	@Insert("insert into resource (resource_name, resource_url, resource_description) "
			+ "values (#{resourceName}, #{resourceUrl}, #{resourceDescription})")
	@Options(useGeneratedKeys=true, keyColumn="resource_id", keyProperty="resourceId")
	void insertResource(Resource resource);
	
	@Update("update resource set resource_name=#{resourceName}, "
			+ "resource_url=#{resourceUrl}, resource_description=#{resourceDescription} "
			+ "where resource_id=#{resourceId}")
	void updateResource(Resource resource);
	
	@Delete("delete from resource where resource_id=#{resource_id}")
	void deleteResource(int resourceId);
	
	@Delete("delete from role_resource where resource_id=#{resourceId}")
	void deleteRoleResource(int resourceId);
	
	@Insert("insert into role_resource(role_id, resource_id) values(#{roleId}, #{resourceId})")
	void insertRoleResource(RoleResource roleResource);
	
	@Delete("delete from user_role where user_id=#{userId}")
	void deleteUserRole(int userId);
	
	@Insert("insert into user_role(role_id, user_id) values(#{roleId}, #{userId})")
	void insertUserRole(UserRole userRole);
}
