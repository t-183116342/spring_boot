package com.hqyj.demo.modules.test.service;

import java.util.List;

import com.hqyj.demo.modules.test.entity.City;
import com.hqyj.demo.modules.test.entity.Country;

/**
 * test service
 * @author: HymanHu
 * @date: 2019年11月27日
 */
public interface TestService {

	/**
	 * 根据国家id查询所有城市
	 */
	List<City> getCitiesByCountryId(int countryId);
	
	/**
	 * 根据国家id查询国家信息
	 */
	Country getcountryByCountryId(int countryId);
	
	/**
	 * 根据country name 查询国家信息
	 */
	Country getCountryByCountryName(String countryName);
}
