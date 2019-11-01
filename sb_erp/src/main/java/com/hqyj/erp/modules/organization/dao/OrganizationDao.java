package com.hqyj.erp.modules.organization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.organization.entity.Department;

@Repository
@Mapper
public interface OrganizationDao {
	
	@Select("select * from department")
	List<Department> geDepartments();

	@Select("select * from department where depart_id = #{departId}")
	Department getDepartmentById(int departId);
	
	@Select("select * from department where depart_name = #{departName}")
	Department getDepartmentByName(String departName);
	
	@Insert("insert department(depart_name,depart_desc) values(#{departName},#{departDesc})")
	void insertDepartment(Department department);
	
	@Update("update department set depart_name=#{departName}, depart_desc=#{departDesc} "
			+ "where depart_id=#{departId}")
	void updateDepartment(Department department);
	
	@Delete("delete from department where depart_id=#{departId}")
	void deleteDepartment(int departId);
}
