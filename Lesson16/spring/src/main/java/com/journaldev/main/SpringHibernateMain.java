package com.journaldev.main;

import java.util.List;

import com.journaldev.dao.BaseDAO;
import com.journaldev.dao.UserDAO;
import com.journaldev.model.User;
import com.journaldev.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.dao.api.PersonDAO;
import com.journaldev.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);

		UserService userService=context.getBean(UserService.class);
		User user=new User("dsa","dsa");
		userService.addUser(user);

		Person person = new Person();
		person.setName("Pankaj"); person.setCountry("India");
		
		personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		
		context.close();
		
	}

}
