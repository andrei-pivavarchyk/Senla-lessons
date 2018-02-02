package com.service;

import com.dao.Factory;
import com.dao.UserDataDAO;
import com.dao.api.IUserDAO;
import com.dao.api.IUserDataDAO;
import com.entity.User;
import com.entity.UserData;
import com.service.api.IUserDataService;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDataService implements IUserDataService {
    @Autowired
    private SessionFactory sessionFactory;
    private Factory factory;
    private static Logger log = Logger.getLogger(UserDataService.class);
    @Autowired
    private UserDataDAO userDataDao ;

    @Transactional
    public void addUserData(UserData entity) {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        userDataDao.addEntity(entity);
        transaction.commit();
    }

    public void updateUserData(UserData entity) {
        try {
            Transaction transaction = getSession().beginTransaction();
            userDataDao.updateEntity(entity);
            transaction.commit();
        } catch (Exception e) {
            log.error(e.toString());
        }
    }


    public UserData getUserDataByUser(User user) {
        try {
            Transaction transaction = getSession().beginTransaction();
            UserData userData = userDataDao.getDataByUser(user);
            transaction.commit();
            return userData;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }


    public Session getSession() {
        return Factory.getSession();
    }
}
