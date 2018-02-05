package com.dao.api;


import com.model.User;

public interface IUserDAO extends IBaseDAO<User> {
    Integer checkUser(String login,String password)throws Exception;
    User getUserByLoginPassword(String login,String password)throws Exception;
}
