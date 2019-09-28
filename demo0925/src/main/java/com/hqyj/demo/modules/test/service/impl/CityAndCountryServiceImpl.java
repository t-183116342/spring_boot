package com.hqyj.demo.modules.test.service.impl;

import java.util.List;

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
	
	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		return cityAndCountryDao.getCitiesByCountryId(countryId);
	}

	@Override
	public Country getCountry(int countryId) {
		return cityAndCountryDao.getCountry(countryId);
	}

	@Override
	public Country getCountryByName(String countryName) {
		return cityAndCountryDao.getCountryByName(countryName);
	}

	@Override
	@Transactional
	public void updateCity(City city) {
		cityAndCountryDao.updateCity(city);
	}

}
