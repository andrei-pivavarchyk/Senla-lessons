package com.service;


import com.daoAPI.IUserDAO;
import com.daoAPI.IUserDataDAO;
import com.model.Book;
import com.model.Order;
import com.model.User;
import com.model.UserData;
import com.serviceAPI.IUserDataService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserDataService implements IUserDataService {

    private static Logger log = Logger.getLogger(UserDataService.class);
    @Autowired
    private IUserDataDAO userDataDao;
    @Autowired
    private IUserDAO userDao;

    public void addUserData(UserData entity) {
        try {
            userDataDao.addEntity(entity);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void updateUserData(UserData entity) {
        try {
            userDataDao.updateEntity(entity);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public UserData getUserDataByUserId(Integer id) {
        try {
            User user = userDao.getEntityById(id);
            UserData userData = userDataDao.getDataByUser(user);
            return userData;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    public UserData getUserDataWithFavorites(Integer id) {

        try {
            User user = userDao.getEntityById(id);
           UserData userData= userDataDao.getUserDatawithFavoritesBooks(user);

            return userData;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    public List<UserData> getAllUserData(){
        List<UserData> userDataList = null;
        try {
            userDataList = this.userDataDao.getAllEntities();
        } catch (Exception e) {

        }
        return userDataList;
    }


}
