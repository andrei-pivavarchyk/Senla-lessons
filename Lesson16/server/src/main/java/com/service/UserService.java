package com.service;

import com.dao.Factory;
import com.dao.api.IUserDAO;
import com.dao.api.IUserDataDAO;
import com.entity.User;
import com.service.api.IUserService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService implements IUserService{

    IUserDAO userDao =(IUserDAO)ContextUtil.getInstance().getContext().getBean("userDao");
    private Factory factory ;


    public void addUser(User entity) {
        Transaction transaction = factory.getSession().beginTransaction();
        userDao.addEntity(entity);
        transaction.commit();
    }

    public void updateUser(User entity) {
        Transaction transaction = getSession().beginTransaction();
        userDao.updateEntity(entity);
        transaction.commit();
    }
    public Session getSession() {
        return Factory.getSession();
    }
}
