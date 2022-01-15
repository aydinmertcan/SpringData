package com.in28minutes.database;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.entity.Person;
import com.in28minutes.database.jpa.PersonJpaRepository;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"com.in28minutes.database.*"})
//@EntityScan({"com.in28minutes.database.entity.*"})
//@EnableJpaRepositories(basePackages = {"com.in28minutes.database.jpa.*"})
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(JpaDemoApplication.class);

	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("Inserting 10004 -> {}", repository.insert(new Person("Mert Can", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}", repository.update(new Person(10003, "Ayca", "Amsterdam", new Date())));
		
		
		/*
		logger.info("All users -> {}", repository.findAll());
		logger.info("Deleting 10002 -> {}", repository.deleteById(10002));
		 */
		
		
		
	}
}
