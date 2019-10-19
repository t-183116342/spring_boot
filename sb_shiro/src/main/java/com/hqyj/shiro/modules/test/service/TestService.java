package com.hqyj.shiro.modules.test.service;

import java.util.List;

import com.hqyj.shiro.modules.test.entity.City;
import com.hqyj.shiro.modules.test.entity.Country;

public interface TestService {

	List<City> getCities(int countryId);
	
	Country getCountry(int countryId);
	
	Country getCountryByName(String countryName);
	
	void insertCity(City city);
	
	void updateCity(City city);
	
	int deleteCity(int cityId);
}
