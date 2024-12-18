package com.learn.personApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.personApp.bean.Person;
import com.learn.personApp.dao.PersonDao;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public List<Person> getAllPerson() {

		return personDao.findAll();
	}

	public Person getPersonById(int id) {
		return personDao.findById(id);
	}

	public Person createPerson(Person person) {
		int insert = personDao.insert(person);

		if (insert > 0) {

			return person;

		} else {
			return null;
		}
	}

	/*
	 * public int deletePersonById(int id) { return personDao.deleteById(id);
	 * 
	 * }
	 * 
	 * public Person updatePersonById(Person person) { int update =
	 * personDao.insert(person);
	 * 
	 * if (update > 0) {
	 * 
	 * return person;
	 * 
	 * } else {
	 * 
	 * return null;} }
	 */

}