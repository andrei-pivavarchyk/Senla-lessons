package com.service;


import com.daoAPI.IAddressDAO;

import com.daoAPI.IUserDAO;
import com.daoAPI.IUserDataDAO;
import com.exception.NoSuchUserException;
import com.exception.UserRegistrationException;
import com.model.Address;
import com.model.Role;
import com.model.User;

import com.model.UserData;
import com.serviceAPI.IObjectConverter;
import com.serviceAPI.IUserService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private IAddressDAO addressDAO;

    public UserService() {
    }

    public void addUser(User user) {

        try {
            Integer userID = this.userDAO.checkUser(user.getLogin());
            if (userID == null) {
                userDAO.addEntity(user);
                Address userAddress = new Address();
                addressDAO.addEntity(userAddress);
                UserData userData = new UserData(user, userAddress);
                userDataDAO.addEntity(userData);
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

    public Integer loginUser(User user) {

        try {
            Integer userId = userDAO.loginUser(user.getLogin(), user.getPassword());
            return userId;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    public Map registrationUser(User user) throws UserRegistrationException {
        Map result = new HashMap();
        Boolean userExist = this.checkUser(user);
        Boolean userValid = this.userValidator(user);
        if (userExist.equals(true)) {
            throw new UserRegistrationException("User already exist");
        } else if (userValid.equals(false)) {
            throw new UserRegistrationException("Invalid Login or Password");
        } else {
            try {
                this.userDAO.addEntity(user);
            } catch (Exception e) {
                log.error(e.toString());
                throw new UserRegistrationException("Exception during registration");
            }
            result.put("success", true);
            result.put("message", "Registration success");
            return result;
        }

    }


    public UserData getUserDataByUser(User user) {
        try {
            UserData userData = this.userDataDAO.getDataByUser(user);
            return userData;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    public void removeUser(User user) {
        try {
            this.userDAO.removeUser(user);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public Role getRoleByUser(User user) {
        Role role = this.getUserDataByUser(user).getRole();
        Role roleDTO = role;
        return roleDTO;
    }

    public User getUserByID(Integer id) {
        try {
            User user = this.userDAO.getEntityById(id);
            return user;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    private Boolean userValidator(User user) {
        if (user.getLogin() != null
                && user.getPassword() != null
                && user.getLogin().length() < 20
                && user.getPassword().length() < 20) {
            return true;
        }
        return false;
    }

    private Boolean checkUser(User user) {

        Integer userId = null;
        try {
            userId = userDAO.checkUser(user.getLogin());
            if (userId != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error(e.toString());
            return false;
        }
    }


}





