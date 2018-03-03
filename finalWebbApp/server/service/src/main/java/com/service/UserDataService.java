package com.service;


import com.daoAPI.IAddressDAO;
import com.daoAPI.IBookDAO;
import com.daoAPI.IUserDAO;
import com.daoAPI.IUserDataDAO;
import com.model.*;
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
    @Autowired
    private IBookDAO bookDAO;
    @Autowired
    IAddressDAO addressDAO;

    public void addUserData(UserData entity) {
        try {
            userDataDao.addEntity(entity);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public UserData updateUserData(UserData entity) {
        try {

            UserData userData = this.userDataDao.getEntityById(entity.getId());
            userData.setEmail(entity.getEmail());
            userData.setName(entity.getName());
            userData.setPatronymic(entity.getPatronymic());
            userData.setPhone(entity.getPhone());
            userData.setRole(entity.getRole());
            userData.setSurname(entity.getSurname());
            this.userDataDao.updateEntity(userData);
            Address address=entity.getAddress();
            this.addressDAO.updateEntity(address);
            return userData;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
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


    public UserData getUserDataWithFavorites(Integer userID) {

        try {
            User user = userDao.getEntityById(userID);
            UserData userData = userDataDao.getUserDatawithFavoritesBooks(user);

            return userData;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    public void addBookToCart(Integer userID, Book book) {

        try {
            Book book2 = this.bookDAO.getEntityById(book.getId());
            User user = userDao.getEntityById(userID);
            UserData userData = userDataDao.getDataByUser(user);
            List<Book> bookList = userData.getFavorites();
            if (!bookList.contains(book2) && book2 != null) {
                userData.getFavorites().add(book2);
                this.userDataDao.updateEntity(userData);
            }

        } catch (Exception e) {
            log.error(e.toString());
        }

    }

    public List<UserData> getAllUserData() {
        List<UserData> userDataList = null;
        try {
            userDataList = this.userDataDao.getAllEntities();
        } catch (Exception e) {

        }
        return userDataList;
    }


}
