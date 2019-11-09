package com.hqyj.erp.modules.property.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;
import com.hqyj.erp.modules.property.entity.ScrapProperty;

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
			+ "property_num=#{propertyNum}, unit_price=#{unitPrice}, total_price=#{totalPrice} "
			+ "where grant_property_id=#{grantPropertyId}")
	void updateGrantProperty(GrantProperty grantProperty);
	
	@Delete("delete from grant_property where grant_property_id=#{grantPropertyId}")
	void deleteGrantProperty(int grantPropertyId);

	@Select("<script>" + 
			"select * from property "
			+ "<where> "
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
			+ " order by property_id"
			+ "</script>")
	List<Property> getProperties(SearchVo searchVo);
	
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
	
	@Insert("insert into scrap_property (property_name, property_type, property_model, property_num) "
			+ "values (#{propertyName}, #{propertyType}, #{propertyModel}, #{propertyNum})")
	void insertScrapProperty(ScrapProperty scrapProperty);
	
	@Update("update scrap_property set property_name=#{propertyName}, property_type=#{propertyType}, "
			+ "property_model=#{propertyModel}, property_num=#{propertyNum} "
			+ "where scrap_property_id=#{scrapPropertyId}")
	void updateScrapProperty(ScrapProperty scrapProperty);
	
	@Select("select * from scrap_property where scrap_property_id=#{scrapPropertyId}")
	ScrapProperty getScrapPropertyById(int scrapPropertyId);
	
	@Select("select * from scrap_property " 
			+ "where property_name=#{propertyName} "
			+ "and property_type=#{propertyType} "
			+ "and property_model=#{propertyModel}")
	ScrapProperty getScrapPropertyByAttribute(ScrapProperty scrapProperty);
	
	@Select("<script>" + 
			"select * from scrap_property "
			+ "<where> "
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
			+ " order by scrap_property_id"
			+ "</script>")
	List<ScrapProperty> getScrapProperties(SearchVo searchVo);
}
