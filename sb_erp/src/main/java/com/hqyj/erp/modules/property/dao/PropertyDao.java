package com.hqyj.erp.modules.property.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.entity.Apply;
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
		+ " order by grant_property_id"
		+ "</script>")
	List<GrantProperty> getGrantProperties(SearchVo searchVo);
	
	@Select("select * from grant_property "
			+ "where property_name=#{propertyName} "
			+ "and property_type=#{propertyType} "
			+ "and property_model=#{propertyModel}")
	GrantProperty getGrantPropertyByAttribute(GrantProperty grantProperty);
	
	@Insert("insert into grant_property (user_id, property_name, property_type,"
			+ "property_model, property_num, unit_price, total_price) "
			+ "values (#{userId}, #{propertyName}, #{propertyType}, #{propertyModel}, "
			+ "#{propertyNum}, #{unitPrice}, #{totalPrice})")
	void insertGrantProperty(GrantProperty grantProperty);
	
	@Update("update grant_property set user_id=#{userId}, property_name=#{propertyName}, "
			+ "property_type=#{propertyType}, property_model=#{propertyModel}, "
			+ "property_num=#{propertyNum}, unit_price=#{unitPrice}, total_price=#{total_price} "
			+ "where grant_property_id=#{grantPropertyId}")
	void updateGrantProperty(GrantProperty grantProperty);
	
	@Delete("delete from grant_property where grant_property_id=#{grantPropertyId}")
	void deleteGrantProperty(int grantPropertyId);

	@Select("select * from property")
	List<Property> getProperties();
	
	@Select("select * from property where propery_id=#{propertyId}")
	Property getPropertyById(int propertyId);
	
	@Select("select * from property "
			+ "where property_name=#{propertyName} "
			+ "and property_type=#{propertyType} "
			+ "and property_model=#{propertyModel}")
	Property getPropertyByAttribute(Property property);
	
	@Insert("insert into property(property_name, property_type, property_model, "
			+ "property_num, unit_price, total_price) "
			+ "values(#{propertyName}, #{propertyType}, #{propertyModel}, #{propertyNum}, "
			+ "#{unitPrice}, #{totalPrice})")
	void insertProperty(Property property);
	
	@Update("update property set property_name=#{propertyName}, property_type=#{propertyType}, "
			+ "property_model=#{propertyModel}, property_num=#{propertyNum}, unit_price=#{unitPrice}, "
			+ "total_price=#{totalPrice} where property_id=#{propertyId}")
	void updateProperty(Property property);
	
	@Insert("insert into apply (apply_type, apply_status, property_name, property_type, property_model, "
			+ "property_num, unit_price, total_price, apply_user_id, approve_user_id, "
			+ "apply_date, approve_date) "
			+ "values(#{applyType}, #{applyStatus}, #{propertyName}, #{propertyType}, #{propertyModel}, "
			+ "#{propertyNum}, #{unitPrice}, #{totalPrice}, #{applyUserId}, "
			+ "#{approveUserId}, #{applyDate}, #{approveDate})")
	void insertApply(Apply apply);
	
	@Select("<script>" + 
		"select *, ua.user_name as applyUserName, up.user_name as approveUserName from apply a "
		+ "left join user ua on a.apply_user_id = ua.user_id "
		+ "left join user up on a.approve_user_id = up.user_id "
		+ "<where> "
		+ "<if test='userId > 0'>"
		+ "and a.apply_user_id = #{userId} "
		+ "</if>"
		+ "<if test='applyType != \"\" and applyType != null'>"
		+ "and a.apply_type = #{applyType} "
		+ "</if>"
		+ "<if test='propertyType != \"\" and propertyType != null'>"
		+ "and a.property_type = #{propertyType} "
		+ "</if>"
		+ "<if test='propertyModel != \"\" and propertyModel != null'>"
		+ "and a.property_model = #{propertyModel} "
		+ "</if>"
		+ "<if test='propertyName != \"\" and propertyName != null'>"
		+ "and a.property_name = #{propertyName} "
		+ "</if>"
		+ "</where>"
		+ " order by apply_date desc"
		+ "</script>")
	List<Apply> getApplies(SearchVo searchVo);
	
	@Select("select *, ua.user_name as applyUserName, up.user_name as approveUserName from apply a "
		+ "left join user ua on a.apply_user_id = ua.user_id "
		+ "left join user up on a.approve_user_id = up.user_id "
		+ "where a.apply_id = #{applyId}")
	Apply getApplyById(int applyId);
	
	@Update("update apply set apply_type=#{applyType}, apply_status=#{applyStatus}, "
			+ "property_name=#{propertyName}, property_type=#{propertyType}, "
			+ "property_model=#{propertyModel}, property_num=#{propertyNum}, "
			+ "unit_price=#{unitPrice}, total_price=#{totalPrice}, "
			+ "apply_user_id=#{applyUserId}, approve_user_id=#{approveUserId}, "
			+ "apply_date=#{applyDate}, approve_date=#{approveDate}, "
			+ "approve_desc=#{approveDesc} where apply_id = #{applyId}")
	void updateApply(Apply apply);
	
	@Delete("delete from apply where apply_id = #{applyId}")
	void deleteApply(int applyId);
}
