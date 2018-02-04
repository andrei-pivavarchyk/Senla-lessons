package com.service;

import com.dao.UserDAO;
import com.entity.User;
import com.service.api.IUserService;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private SessionFactory sessionFactory;
    private static Logger log = Logger.getLogger(UserService.class);
    @Autowired
    private UserDAO userDao ;


    @Transactional
    public void addUser(User entity) {
        System.out.println(userDao);
        userDao.addEntity(entity);
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
}
