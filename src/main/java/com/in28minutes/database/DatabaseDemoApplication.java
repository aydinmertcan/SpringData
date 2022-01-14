package com.in28minutes.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.entity.Person;
import com.in28minutes.database.jdbc.PersonJdbcDao;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(DatabaseDemoApplication.class);

	@Autowired
	private PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("Deleting 10002 -> {}", dao.deleteById(10002));
		logger.info("Inserting 10004 -> {}", dao.insert(new Person(10004, "Mert Can", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}", dao.update(new Person(10003, "Ayca", "Amsterdam", new Date())));
		
		/*
		 * All users -> [Person [id=10001, name=Ranga, location=Hyderabad, birthDate=2022-01-14 00:00:00.0], 
				Person [id=10002, name=James, location=New York, birthDate=2022-01-14 00:00:00.0], 
				Person [id=10003, name=Pieter, location=Amsterdam, birthDate=2022-01-14 00:00:00.0]]
				
				2022-01-14 11:16:12.734  INFO 25987 --- [           main] c.i.database.DatabaseDemoApplication     : User id 10001 -> Person [id=10001, name=Ranga, location=Hyderabad, birthDate=2022-01-14 00:00:00.0]
				
				2022-01-14 11:16:12.736  INFO 25987 --- [           main] c.i.database.DatabaseDemoApplication     : Deleting 10002 -> 1
				2022-01-14 11:16:12.737  INFO 25987 --- [           main] c.i.database.DatabaseDemoApplication     : Inserting 10004 -> 1
				2022-01-14 11:16:12.738  INFO 25987 --- [           main] c.i.database.DatabaseDemoApplication     : Updating 10003 -> 1
		 */
	}
}
