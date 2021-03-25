package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
	
	
	/* @Query("SELECT c FROM Country c WHERE c.name LIKE %:name%") 
	 * List<Country> findByName(@Param("name") String name);
	 * 
	 * OR
	 * 
	 * */
	
	List<Country> findByNameContaining(@Param("name") String name);
	
	List<Country> findByNameContainingOrderByNameAsc(@Param("name") String name);
	
	List<Country> findByNameStartsWith(@Param("nameAlpha") String name);
}
