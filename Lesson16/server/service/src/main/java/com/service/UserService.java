package com.service;

import com.dao.api.IUserDAO;
import com.model.User;
import com.service.api.IUserService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

    private SessionFactory sessionFactory;
    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private IUserDAO userDAO;

    public UserService() {
    }

    @Transactional
    public void addUser(User entity) {
        try {
            userDAO.addEntity(entity);
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

    @Transactional
    public Long checkUser(String login, String password) {
        try {
            Long userId = userDAO.checkUser(login, password);
            return userId;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }
}
