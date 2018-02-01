package com.service;

import com.dao.Factory;
import com.dao.UserDAO;
import com.dao.api.IUserDAO;
import com.dao.api.IUserDataDAO;
import com.entity.User;
import com.service.api.IUserService;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService implements IUserService {

    private static Logger log = Logger.getLogger(UserService.class);

    IUserDAO userDao = (IUserDAO) ContextUtil.getInstance().getContext().getBean("userDao");
    private Factory factory;

    public void addUser(User entity) {
        Transaction transaction = factory.getSession().beginTransaction();
        userDao.addEntity(entity);
        transaction.commit();
    }

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



    public Session getSession() {
        return Factory.getSession();
    }
}
