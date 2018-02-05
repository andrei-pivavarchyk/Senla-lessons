package com.service;

import com.dao.UserDAO;
import com.model.User;
import com.service.api.IUserService;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService implements IUserService {

    private SessionFactory sessionFactory;
    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;

    public UserService() {

    }

    @Transactional
    public void addUser(User entity) {
        userDAO.addEntity(entity);
    }

    public void updateUser(User entity) {
        try {

            userDAO.updateEntity(entity);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }


    public User getUserByLoginPassword(String login, String password) {
        try {
            User user = userDAO.getUserByLoginPassword(login, password);
            return user;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }

    }


    public Boolean checkUser(User user) {
        try {
           Boolean userExist=userDAO.checkUser(user);
            return userExist;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }


    public void setUserDao(UserDAO userDao) {
        this.userDAO = userDao;
    }

    public UserDAO getUserDao() {
        return userDAO;
    }

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
