package com.hqyj.demo.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.demo.modules.test.entity.City;
import com.hqyj.demo.modules.test.entity.Country;

@Repository
@Mapper
public interface CityAndCountryDao {

	/**
	 * #{countryId} ---- prepared statement, select * from m_city where country_id = ?
	 * '${countryId}' ---- statement, select * from m_city where country_id = 'some id'
	 */
	@Select("select * from m_city where country_id=#{countryId}")
	List<City> getCitiesByCountryId(int countryId);
	
	/**
	 * @Results ---- 封装结果集，对于联表查询的字段，可调用已有的方法getCitiesByCountryId
	 * property ---- 对应 country 的 cities 属性
	 * column ---- 对应 select 查询后的某个字段名，作为调用方法的参数
	 */
	@Select("select * from m_country where country_id = #{countryId}")
	@Results(id="countryResult", value={
		@Result(column="country_id", property="countryId"),
		@Result(property="cities",
				column="country_id",
				javaType=List.class,
				many=@Many(select="com.hqyj.demo.modules.test.dao.CityAndCountryDao.getCitiesByCountryId"))
	})
	Country getCountry(int countryId);
	
	/**
	 * @ResultMap ---- 引用公共 @Results 的 id 属性，可以共享结果集
	 */
	@Select("select * from m_country where country_name = #{countryName}")
//	@ResultMap(value="countryResult")
	Country getCountryByName(String countryName);
	
	@Update("update m_city set local_city_name = #{localCityName} where city_id = #{cityId}")
	void updateCity(City city);
	
}
