package com.journaldev.dao.api;

import com.journaldev.model.User;

public interface IUserDAO extends IBaseDAO<User> {
    Boolean checkUser(User user);
    User getUserByLoginPassword(String login,String password);
}
