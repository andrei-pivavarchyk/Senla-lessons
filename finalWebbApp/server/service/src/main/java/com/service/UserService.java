package com.service;


import com.daoAPI.IAddressDAO;

import com.daoAPI.IUserDAO;
import com.daoAPI.IUserDataDAO;
import com.model.Address;
import com.model.User;

import com.model.UserData;
import com.serviceAPI.IObjectConverter;
import com.serviceAPI.IUserService;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    private SessionFactory sessionFactory;
    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private IAddressDAO userAddressDAO;

    @Autowired
    private IUserDataDAO userDataDAO;


    @Autowired
    private IObjectConverter objectConverter;

    public UserService() {
    }

    public void addUser(User user) {

        try {
            Long userID = this.userDAO.checkUser(user.getLogin(), user.getPassword());
            if (userID == null) {
                Session session = userDAO.getSession();
                Address userAddress = new Address();
                 session.save(user);
                 session.save(userAddress);

             UserData userData=new UserData(user,userAddress);
             session.save(userData);
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void updateUser(User entity) {
        try {
            userDAO.updateEntity(entity);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public Long checkUser(User user) {

        try {
            Long userId = userDAO.checkUser(user.getLogin(), user.getPassword());
            return userId;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    public void removeUser(User user) {
        try {
            UserData userData = this.userDataDAO.getDataByUser(user);
            Long userID = this.userDAO.checkUser(user.getLogin(), user.getPassword());
            this.userAddressDAO.deleteEntity(userData.getAddress().getId());
            this.userDataDAO.deleteEntity(userData.getId());
            this.userDAO.deleteEntity(userID);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





