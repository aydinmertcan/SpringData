package com.in28minutes.database.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.database.entity.Person;

@Repository
@Transactional
//Repository
//Transaction: Ideally transactions have to be implemented around the business services. But for this example, we will define it in here.
public class PersonJpaRepository {

	// Connect to the database
	@PersistenceContext
	EntityManager entityManager;

	public Person findById(int id) {
		return entityManager.find(Person.class, id); // JPA
	}

}
