package com.in28minutes.database.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.database.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{
	
}
