package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;


@SpringBootApplication
public class OrmLearnApplication {

	
	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	
	public static void main(String[] args) throws CountryNotFoundException {
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		
	}

	
	
	private static void testGetAllCountries() {

		LOGGER.info("Start of testGetAllCountries()");

		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End of testGetAllCountries()");

	}
	
	private static void getAllCountriesTest() throws CountryNotFoundException {

		LOGGER.info("Start of getAllCountriesTest()");
		Country country = countryService.findCountryByCode("IN");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End of getAllCountriesTest()");

		}
	
	public static void testAddCountry() throws CountryNotFoundException {
		
		LOGGER.info("Start of testAddCountry()");
		Country country = new Country("LK","Sri Lanka");
		countryService.addCountry(country);
		Country countryadd=countryService.findCountryByCode("LK");
		LOGGER.debug("Country:{}", countryadd);

		LOGGER.info("End of testAddCountry()");

	}
	
	private static void testUpdateCountry() throws CountryNotFoundException {
		
		LOGGER.info("Start of testUpdateCountry()");
		countryService.updateCountry("CH", "Switzerland");
		Country countryupdate = countryService.findCountryByCode("CH");
		LOGGER.debug("Country:{}", countryupdate);
		LOGGER.info("End of testUpdateCountry()");

	}	
	
	private static void testDeleteCountry() throws CountryNotFoundException {
		
		LOGGER.info("Start of testDeleteCountry()");
		Country countrydelete = countryService.findCountryByCode("LK");
		LOGGER.debug("Country:{}", countrydelete);
		countryService.deleteCountry("LK");
		testGetAllCountries();
		LOGGER.info("End of testDeleteCountry()");

	}
	
}
	
	
	
	
	
	
	
	
	
	
	

