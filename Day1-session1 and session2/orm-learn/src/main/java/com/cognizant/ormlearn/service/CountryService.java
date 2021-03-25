package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	
	@Autowired
	private CountryRepository countryRepository;
	
	//method to get all countries
	@Transactional
	public List<Country> getAllCountries() 
	{
		List<Country> countryList=(List<Country>)countryRepository.findAll();
		return countryList;
	}
	
	//method to find a country based on code
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException
	{
		
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country not found!!");
		}
		else {
			Country country = result.get();
			return country;
		}
	}
	
	//method to add records into Country database
	@Transactional
	public void addCountry(Country country) 
	{
		
		countryRepository.save(country);
	}
	
	//method to update a record based on country code
	@Transactional
	public void updateCountry(String countryCode,String name) 
	{
		Optional<Country> countryid = countryRepository.findById(countryCode);
		if (countryid.isPresent()) {

			Country country=countryid.get();
			country.setName(name);
			countryRepository.save(country);
		}
		
		
	}
	
	//method to delete a record based on country code
	@Transactional
	public void deleteCountry(String countryCode)
	{
		countryRepository.deleteById(countryCode);
	}
	
	
	
	
	
	
	
	
	

}
