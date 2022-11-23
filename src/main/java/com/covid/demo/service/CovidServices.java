package com.covid.demo.service;

import com.covid.demo.model.CountryEntity;

public interface CovidServices {

	CountryEntity getCountry(String code);

	CountryEntity saveCountry(CountryEntity country);

}
