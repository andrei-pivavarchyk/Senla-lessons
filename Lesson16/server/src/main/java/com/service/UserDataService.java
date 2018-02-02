package com.service;

import com.dao.Factory;
import com.dao.api.IUserDAO;
import com.dao.api.IUserDataDAO;
import com.entity.User;
import com.entity.UserData;
import com.service.api.IUserDataService;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDataService implements IUserDataService {

    private Factory factory;
    private static Logger log = Logger.getLogger(UserDataService.class);
    IUserDataDAO userDataDao = (IUserDataDAO) ContextUtil.getInstance().getContext().getBean("userDataDao");

    public void addUserData(UserData entity) {
        Transaction transaction = factory.getSession().beginTransaction();
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
