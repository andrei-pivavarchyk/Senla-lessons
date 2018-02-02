package com.journaldev.service;


import com.journaldev.dao.UserDAO;
import com.journaldev.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    private SessionFactory sessionFactory;
    private static Logger log = Logger.getLogger(UserService.class);

@Autowired
    private UserDAO userDAO ;

public UserService(){

}
    @Transactional
    public void addUser(User entity) {
        Session session = this.sessionFactory.getCurrentSession();

       userDAO.addEntity(entity);


    }
/*
    public void updateUser(User entity) {
        try {
            Transaction transaction = getSession().beginTransaction();
            userDao.updateEntity(entity);
            transaction.commit();
        } catch (Exception e) {
            log.error(e.toString());

        }
    }


    public User getUserByLoginPassword(String login, String password) {
        try {
            Transaction transaction = getSession().beginTransaction();
            User user = userDao.getUserByLoginPassword(login, password);
            transaction.commit();
            return user;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }

    }


    public Boolean checkUser(User user) {
        try {
            Transaction transaction = getSession().beginTransaction();
           Boolean userExist=userDao.checkUser(user);
           transaction.commit();
            return userExist;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }


    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public UserDAO getUserDao() {
        return userDao;
    }*/

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
