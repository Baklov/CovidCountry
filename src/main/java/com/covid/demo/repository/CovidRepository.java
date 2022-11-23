package com.covid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.demo.model.CountryEntity;

public interface CovidRepository extends JpaRepository<CountryEntity, String> {
}
