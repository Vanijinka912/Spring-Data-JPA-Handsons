package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.StockService;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory; 
@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static StockService stockService;
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main"); 
		stockService = context.getBean(StockService.class);
		
		System.out.println("all stock details of Facebook in the month of September 2019");
		List<Stock> list=stockService.getByCodeAndDate();
		for(Stock stock1: list) {
			System.out.println(stock1.toString());
		}
		
		System.out.println("all google stock details where the stock price was greater than 1250");
		List<Stock> list1=stockService.getByCodeAndStockPrice();
		for(Stock s: list1) {
			System.out.println(s.toString());
		}
		System.out.println("the top 3 dates which had highest volume of transactions");
		List<Stock> list2=stockService.getTop3ByVolume();
		for(Stock s: list2) {
			System.out.println(s.toString());
		}
		System.out.println("three dates when Netflix stocks were the lowest");
		
		List<Stock> list3=stockService.getTop3ByCode();
		for(Stock s: list3) {
			System.out.println(s.toString());
		}
		
		
		
		
		
	}

}