package com.cognizant.ormlearn.service.exception;

public class CountryNotFoundException extends Exception{

	
	public CountryNotFoundException() {
		
	}
	
	public CountryNotFoundException(String msg) {
		super(msg);
	}
}
