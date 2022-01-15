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
import com.in28minutes.database.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringDataDemoApplication.class);

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("Inserting 10004 -> {}", repository.save(new Person("Mert Can", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}", repository.save(new Person(10003, "Ayca", "Amsterdam", new Date())));
		repository.deleteById(10002);
		logger.info("All users -> {}", repository.findAll());

	}
}
