package com.hqyj.shiro.modules.test.dao;


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

import com.hqyj.shiro.modules.test.entity.City;
import com.hqyj.shiro.modules.test.entity.Country;

@Repository
@Mapper
public interface TestDao {
	
	/**
	 * 方式一：配置文件方式
	 * application.properties
	 * mybatis.type-aliases-package= com.hqyj.shiro.modules.*.entity
	 * mybatis.mapper-locations=classpath:config/*Mapper.xml
	 * 读取cityMapper.xml，方法名和mapper中设置的id一致
	 */
	List<City> getcities2(int countryId);
	
	// 方式二：采用纯注解方式
	
	@Delete("delete from m_city where city_id=#{cityId}")
	int deleteCity(int cityId);
	
	@Update("update m_city set local_city_name=#{localCityName} where city_id=#{cityId}")
	void updateCity(City city);
	
	/**
	 * useGeneratedKeys：包装插入id
	 */
	@Insert("insert m_city(city_name,country_id,date_created) values(#{cityName},#{countryId},#{dateCreated})")
	@Options(useGeneratedKeys=true, keyColumn="city_id", keyProperty="cityId")
	void insertCity(City city);

	/**
	 * #{countryId} ---- prepared statement, select * from m_city where country_id = ?
	 * '${countryId}' ---- statement, select * from m_city where country_id = 'some id'
	 */
	@Select("select * from m_city where country_id = #{countryId}")
	List<City> getcities(int countryId);
	
	/**
	 * @Results ---- 封装结果集，对于联表查询的字段，可调用已有的方法getCitiesByCountryId
	 * column ---- 对应 select 查询后的某个字段名，作为调用方法的参数
	 * property ---- 对应 country 的 cities 属性
	 * 1、country_id封装了两次，分别对应countryId和cities，而cities属性通过getcities方法来实现，country_id作为参数
	 * 2、结果集共享，设置id属性，调用是使用@ResultMap(value="countryResult")
	 */
	@Select("select * from m_country where country_id = #{countryId}")
	@Results(id="countryResult", value={
			@Result(column="country_id", property="countryId"),
			@Result(column="country_name", property="countryName"),
			@Result(column="country_id",property="cities",
					javaType=List.class,
					many=@Many(select="com.hqyj.shiro.modules.test.dao.TestDao.getcities"))
		})
	Country getCountry(int countryId);
	
	@Select("select * from m_country where country_name = #{countryName}")
	@ResultMap(value="countryResult")
	Country getCountryByName(String countryName);
}
