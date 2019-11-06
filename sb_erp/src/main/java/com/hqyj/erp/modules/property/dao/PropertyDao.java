package com.hqyj.erp.modules.property.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;

@Repository
@Mapper
public interface PropertyDao {
	
	@Select("<script>" + 
		"select * from grant_property "
		+ "<where> "
		+ "<if test='userId > 0'>"
		+ "and user_id = #{userId} "
		+ "</if>"
		+ "<if test='propertyType != \"\"'>"
		+ "and property_type = #{propertyType} "
		+ "</if>"
		+ "<if test='propertyModel != \"\"'>"
		+ "and property_model = #{propertyModel} "
		+ "</if>"
		+ "<if test='propertyName != \"\"'>"
		+ "and property_name = #{propertyName} "
		+ "</if>"
		+ "</where>"
		+ "</script>")
	List<GrantProperty> getGrantProperties(SearchVo searchVo);

	@Select("select * from property")
	List<Property> getProperties();
	
	@Select("select * from property where propery_id=#{propertyId}")
	Property getPropertyById(int propertyId);
	
	@Select("select * from property "
			+ "where property_name=#{propertyName} "
			+ "and property_type=#{propertyType} "
			+ "and property_model=#{propertyModel}")
	Property getPropertyByAttribute(Property property);
}
