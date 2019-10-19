package com.hqyj.shiro.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hqyj.shiro.modules.test.dao.TestDao;
import com.hqyj.shiro.modules.test.entity.City;
import com.hqyj.shiro.modules.test.entity.Country;
import com.hqyj.shiro.modules.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao testDao;
	
	@Override
	public List<City> getCities(int countryId) {
//		return testDao.getcities(countryId);
		return testDao.getcities2(countryId);
	}

	@Override
	public Country getCountry(int countryId) {
		Country country = testDao.getCountry(countryId);
		List<City> cities = testDao.getcities(country.getCountryId());
		country.setCities(cities);
		return country;
	}

	@Override
	public Country getCountryByName(String countryName) {
		return testDao.getCountryByName(countryName);
	}

	@Override
	public void insertCity(City city) {
		testDao.insertCity(city);
	}

	/* 
	 * 添加事务，并设置其属性
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateCity(City city) {
		testDao.updateCity(city);
//		int i = 1/0;
	}

	@Override
	public int deleteCity(int cityId) {
		return testDao.deleteCity(cityId);
	}
}
