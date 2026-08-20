package com.countryService.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.countryService.demo.Beans.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>{
	
}
