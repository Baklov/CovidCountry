package com.covid.demo.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.covid.demo.model.CountryEntity;
import com.covid.demo.service.CovidServices;

@RestController
public class CovidControl {
	@Autowired
	private CovidServices covidServices;
	
	@GetMapping(value="/country/{COUNTRYCODE}")
	public ResponseEntity<Map<String, Object>> getCovidInfoByCountry(@PathVariable String COUNTRYCODE){
		Map<String, Object> response= new HashMap<>();
		CountryEntity country = covidServices.getCountry(COUNTRYCODE);
		CountryEntity countrySaved = covidServices.saveCountry(country);
		 
		 response.put("data", countrySaved);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
}
