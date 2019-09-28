package com.hqyj.demo.modules.test.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hqyj.demo.modules.test.dao.CityAndCountryDao;
import com.hqyj.demo.modules.test.entity.City;
import com.hqyj.demo.modules.test.entity.Country;
import com.hqyj.demo.modules.test.service.CityAndCountryService;

@Service
public class CityAndCountryServiceImpl implements CityAndCountryService {

	@Autowired
	private CityAndCountryDao cityAndCountryDao;
	
	/* 
	 * 根据country id 查询 cities，返回10条数据
	 */
	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		List<City> cities = cityAndCountryDao.getCitiesByCountryId(countryId);
		return cities.stream().limit(10).collect(Collectors.toList());
	}

	/*
	 * 根据country id查询coutry；
	 */
	@Override
	public Country getCountry(int countryId) {
		return cityAndCountryDao.getCountry(countryId);
	}

	/* 
	 * 根据country name 查询 country
	 */
	@Override
	public Country getCountryByName(String countryName) {
		return cityAndCountryDao.getCountryByName(countryName);
	}

	/* 
	 * 更新 city的local city name 属性
	 */
	@Override
	@Transactional
	public void updateCity(City city) {
		cityAndCountryDao.updateCity(city);
	}

}
