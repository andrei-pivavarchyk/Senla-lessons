package com.daoAPI;

import com.daoAPI.IBaseDAO;
import com.model.User;
import org.hibernate.Session;

public interface IUserDAO extends IBaseDAO<User> {
    Long checkUser(String login,String password)throws Exception;
    User getUserByLoginPassword(String login,String password)throws Exception;
    Session getSession();
}