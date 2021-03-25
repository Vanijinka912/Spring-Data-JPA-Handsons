package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	public static EmployeeService employeeService;
	public static DepartmentService departmentService;
	public static SkillService skillService;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		
		/*testGetEmployee();
		testAddEmployee();
		testUpdateEmployee();
		testGetDepartment();
		testAddSkillToEmployee();*/
		LOGGER.info("Inside main");
		testGetAllPermanentEmployees();
		testGetAverageSalary();
		testGetAllEmployeesUsingNativeQuery();
		
	}
	
	//Get all permanent employees using HQL - day2 session2 hands on 2
	public static void testGetAllPermanentEmployees() {

		LOGGER.info("Start");

		List<Employee> employees = employeeService.getAllPermanentEmployees();

		LOGGER.debug("Permanent Employees:{}", employees);

		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));

		LOGGER.info("End");

	}
	
	//Get average salary using HQL- Day2 session2 hands on 4
	public static void testGetAverageSalary() {

		LOGGER.info("Start Get average salary");
		double averageSalary = employeeService.getAverageSalary();
		LOGGER.debug("Average Salary: {}", averageSalary);			
		LOGGER.info("End Get average salary");

	}
	
	//Get all employees using Native Query - Day 2 session 2 hands on 5
	public static void testGetAllEmployeesUsingNativeQuery() {

		LOGGER.info("Start Get all employees");
		List<Employee> employees = employeeService.getAllEmployeesNative();
		LOGGER.debug("All Employees: {}", employees);
		LOGGER.info("End Get all employees");

	}
	private static void testGetEmployee() {

		LOGGER.info("Start");

		Employee employee = employeeService.get(101);

		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
		
		LOGGER.debug("Skills:{}", employee.getSkillList());

		LOGGER.info("End");

		}
	
	private static void testAddEmployee() {
		
		Employee employee = new Employee();
		employee.setId(105);
		employee.setName("Neelima");
		employee.setSalary(25000.00);
		String s="1997-08-22";
		try {
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		
			Date date=sd.parse(s);
			employee.setDateOfBirth(date);
		
		}catch(ParseException ep) { 
			ep.printStackTrace();
		}
		
		employee.setPermanent(true);
		
		Department dept= departmentService.get(1);
		employee.setDepartment(dept);
		employeeService.save(employee);
		
		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");

		Employee employee = employeeService.get(11);
		Department dept= departmentService.get(8);
		employee.setDepartment(dept);
		employeeService.save(employee);
		
		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());

		LOGGER.info("End");
	}
	
	private static void testGetDepartment() {
		LOGGER.info("Start");

		 Department dept= departmentService.get(1);

		LOGGER.debug("Department:{}", dept);

		LOGGER.debug("Department:{}", dept.getEmployeeList());

		LOGGER.info("End");

	}
	
	private static void testAddSkillToEmployee() {
		
		Employee employee = employeeService.get(9);
		Skill skill = skillService.get(5);
		
		Set<Skill> set=employee.getSkillList();
		set.add(skill);
		
		employee.setSkillList(set);
		
		employeeService.save(employee);
	}
}