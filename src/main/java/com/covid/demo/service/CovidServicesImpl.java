package com.covid.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.demo.model.CountryEntity;
import com.covid.demo.repository.CovidRepository;
import com.covid.demo.util.GetURLData;

@Service
public class CovidServicesImpl implements CovidServices {
	@Autowired
	private CovidRepository covidRepository;
	@Override
	public CountryEntity getCountry(String code) {
		Map<String, CountryEntity> countries  = GetURLData.getUrlContents("https://api.covid19api.com/countries");  
		return countries.get(code);
	}

	@Override
	public CountryEntity saveCountry(CountryEntity country) {
		CountryEntity res = covidRepository.save(country);
		return res;
	}
}
