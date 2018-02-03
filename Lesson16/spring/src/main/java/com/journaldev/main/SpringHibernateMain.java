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

UserDAO userDAO=new UserDAO();

		UserService userService=new UserService();
		User user=new User("dsa","dsa");
		userDAO.addEntity(user);


		
	}

}
