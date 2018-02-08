package com.service;

import com.dao.api.IUserDAO;
import com.dao.api.IUserDataDAO;
import com.model.User;
import com.model.UserData;
import com.service.api.IUserDataService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDataService implements IUserDataService {
    @Autowired
    private SessionFactory sessionFactory;
    private static Logger log = Logger.getLogger(UserDataService.class);
    @Autowired
    private IUserDataDAO userDataDao;
    @Autowired
    private IUserDAO userDao;


    public void addUserData(UserData entity) {
        userDataDao.addEntity(entity);
    }


    public void updateUserData(UserData entity) {
        try {
            userDataDao.updateEntity(entity);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }


    public UserData getUserDataByUserId(Long id) {
        try {
            User user = userDao.getEntityById(id);
            UserData userData = userDataDao.getDataByUser(user);
            return userData;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

}
