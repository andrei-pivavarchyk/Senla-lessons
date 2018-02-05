package com.service;

import com.dao.UserDataDAO;
import com.model.User;
import com.model.UserData;
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
    private static Logger log = Logger.getLogger(UserDataService.class);
    @Autowired
    private UserDataDAO userDataDao ;

    @Transactional
    public void addUserData(UserData entity) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        userDataDao.addEntity(entity);
        tr.commit();
    }

    public void updateUserData(UserData entity) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Transaction tr = session.beginTransaction();
            userDataDao.updateEntity(entity);
            tr.commit();
        } catch (Exception e) {
            log.error(e.toString());
        }
    }


    public UserData getUserDataByUser(User user) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Transaction tr = session.beginTransaction();
            UserData userData = userDataDao.getDataByUser(user);
            tr.commit();
            return userData;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

}
