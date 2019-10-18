package com.hqyj.shiro.modules.test.dao;


import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hqyj.shiro.modules.test.entity.City;
import com.hqyj.shiro.modules.test.entity.Country;

@Repository
@Mapper
public interface TestDao {

	@Select("select * from m_city where country_id = #{countryId}")
	List<City> getcities(int countryId);
	
	@Select("select * from m_country where country_id = #{countryId}")
	@Results(id="countryResult", value={
			@Result(column="country_id", property="countryId"),
			@Result(property="cities",
					column="country_id",
					javaType=List.class,
					many=@Many(select="com.hqyj.shiro.modules.test.dao.TestDao.getcities"))
		})
	Country getCountry(int countryId);
	
	@Select("select * from m_country where country_name = #{countryName}")
	@ResultMap(value="countryResult")
	Country getCountryByName(String countryName);
}
