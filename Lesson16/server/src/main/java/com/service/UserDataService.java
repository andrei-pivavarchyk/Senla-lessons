package com.service;

import com.dao.Factory;
import com.dao.api.IUserDAO;
import com.dao.api.IUserDataDAO;
import com.entity.User;
import com.entity.UserData;
import com.service.api.IUserDataService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDataService  implements IUserDataService{

    private Factory factory ;
    IUserDataDAO userDataDao =(IUserDataDAO)ContextUtil.getInstance().getContext().getBean("userDataDao");

    public void addUserData(UserData entity) {
        Transaction transaction = factory.getSession().beginTransaction();
        userDataDao.addEntity(entity);
        transaction.commit();
    }

    public void updateUserData(UserData entity) {
        Transaction transaction = getSession().beginTransaction();
        userDataDao.updateEntity(entity);
        transaction.commit();
    }
    public Session getSession() {
        return Factory.getSession();
    }
}
