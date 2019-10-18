package com.hqyj.shiro.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return testDao.getcities(countryId);
	}

	@Override
	public Country getCountry(int countryId) {
		return testDao.getCountry(countryId);
	}

	@Override
	public Country getCountryByName(String countryName) {
		return testDao.getCountryByName(countryName);
	}

}
