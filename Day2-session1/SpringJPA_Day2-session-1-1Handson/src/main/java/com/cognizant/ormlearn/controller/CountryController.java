package com.cognizant.ormlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;

@Controller
public class CountryController {

	/*
	 * @Autowired private CountryService countryService;
	 */
	
	 @Autowired 
	 private CountryRepository countryRepository;

	 @RequestMapping(value="search", method=RequestMethod.GET) 
	 public String showSearchPage(@ModelAttribute("country") Country country) { 
		 return "search";
	  }
	 
	
	@RequestMapping(value="search", method=RequestMethod.POST)
	public String searchPage(ModelMap map, @ModelAttribute("country") Country country, @Param("name") String name) {
		
		// Possible with directly using countryRepo // 
		List<Country> countryName = countryRepository.findByNameContaining(name);

		//Find the country by name in ascending order 
		List<Country> countryNameAsc = countryRepository.findByNameContainingOrderByNameAsc(name);
		 
		/* Using service layer
		 * //Find the country by name List<Country> countryName =
		 * countryService.findCountryByName(name);
		 * 
		 * // Possible with directly using countryRepo // List<Country> countryName =
		 * countryRepo.findByNameContaining(name);
		 * 
		 * //Find the country by name in ascending order List<Country> countryNameAsc =
		 * countryService.findCountryByNameAsc(name);
		 */
		
		map.addAttribute("countryName", countryName);
		
		map.addAttribute("countryNameAsc", countryNameAsc);
		
		
		return "search";
	}
	
	@RequestMapping(value="searchWith", method=RequestMethod.POST)
	public String searchPageWith(ModelMap map, @ModelAttribute("country") Country country, @Param("nameAlpha") String name) {
		List<Country> countryName = countryRepository.findByNameStartsWith(name);
		
		map.addAttribute("countryNameStart", countryName);
		return "search";
		
	}
}
