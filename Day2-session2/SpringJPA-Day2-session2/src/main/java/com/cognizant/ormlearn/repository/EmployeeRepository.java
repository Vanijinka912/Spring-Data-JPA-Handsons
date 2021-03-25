package com.cognizant.ormlearn.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	//@Query(value="SELECT e FROM Employee e WHERE e.permanent = 1") //day2 session2 handson2 query1

	//@Query(value="SELECT e FROM Employee e left join e.department d left join e.skillList WHERE e.permanent = 1") //day2 session2 handson2 query2
	
	@Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();

	// NOTE: HQL looks like SQL, instead of table, Java classes and it's

	// instance variables are addressed here
	/*
	 * NOTE: HQL looks like SQL, instead of table, Java classes and it's instance variables are addressed here
	 * 
	 * Query 1 has two issues when removed eager fetch
	 * 		a. We did not get the skill details
	 * 		b. Still the query is not optimal as we have 3 queries executed
	 * 
	 * The above query still fails to get skill details. Include fetch after each join. 
	 * Wherever data is required we can include fetch, which will populate the respective data
	 */
	
	/*
	 * IMPORTANT TAKEAWAY: Join keyword links the table, but does not populate the beans. 
	 * Fetch ensures that the beans are populated. Based on our need wherever we need data, we can define fetch. 
	 * When joining table data is not needed the fetch can be ignored.
	 */
	
	/*@Query(value="SELECT AVG(e.salary) FROM Employee e")
	double getAverageSalary();*/
	
	
	
	//:: Query does not filter the result based on department id
	

	//Get average salary using HQL- Day2 session2 hands on 4
	@Query(value="SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
	double getAverageSalary(@Param("id") int id);
	
	
	/*
	 * Observe how department id is referred from 'e'
	 * Make note of the colon (:) used to define a parameter within a query
	 * @Param annotation helps in binding the input department id with the query parameter
	 */
	
	/*
	 * Native queries are direct SQL queries to the database instead of using HQL	
	 * Try to avoid Native Queries and make it minimal.
	 * Avoiding native queries helps in easier portability of database
	 * To be able to use native query we have to use :: nativeQuery = true
	 */
	
	//Get all employees using Native Query - Day 2 session 2 hands on 5
	
	@Query(value="SELECT * FROM employee", nativeQuery = true)
	List<Employee> getAllEmployeesNative();
	
}
