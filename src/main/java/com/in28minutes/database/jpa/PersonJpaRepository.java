package com.in28minutes.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	//JPQL Java Persistance Query Language
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery =  entityManager.createNamedQuery("find_all_people",Person.class);
		return namedQuery.getResultList();
	}

}
