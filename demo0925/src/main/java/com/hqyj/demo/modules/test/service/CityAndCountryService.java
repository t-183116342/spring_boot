package com.hqyj.demo.modules.test.service;

import java.util.List;

import com.hqyj.demo.modules.test.entity.City;
import com.hqyj.demo.modules.test.entity.Country;

public interface CityAndCountryService {

	List<City> getCitiesByCountryId(int countryId);
	
	Country getCountry(int countryId);
	
	Country getCountryByName(String countryName);
	
	void updateCity(City city);
}
