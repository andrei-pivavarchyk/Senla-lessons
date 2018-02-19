package com.service;


import com.daoAPI.IUserAddressDAO;
import com.daoAPI.IUserContactDAO;
import com.daoAPI.IUserDAO;
import com.daoAPI.IUserDataDAO;
import com.model.User;

import com.model.UserAddress;
import com.model.UserContact;
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
    private IUserAddressDAO userAddressDAO;
    @Autowired
    private IUserContactDAO userContactDAO;
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
                UserContact userContact = new UserContact();
                UserAddress userAddress = new UserAddress();
                UserData userData=new UserData();

                 session.save(user);
                session.save(userData);
                session.save(userContact);
                session.save(userAddress);


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

            this.userDataDAO.deleteEntity(userData.getId());
            this.userDAO.deleteEntity(userID);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
