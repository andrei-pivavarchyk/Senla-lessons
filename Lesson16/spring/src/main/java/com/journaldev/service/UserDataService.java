package com.journaldev.service;

import com.journaldev.dao.UserDataDAO;
import com.journaldev.model.UserData;
import com.journaldev.service.api.IUserDataService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDataService implements IUserDataService {
    @Autowired
    private SessionFactory sessionFactory;
    private static Logger log = Logger.getLogger(UserDataService.class);
    @Autowired
    private UserDataDAO userDataDao ;

    @Transactional
    public void addUserData(UserData entity) {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        userDataDao.addEntity(entity);
        transaction.commit();
    }
/*
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

*/

}
