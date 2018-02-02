package com.journaldev.dao.api;

import java.util.List;

import com.journaldev.model.Person;

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
