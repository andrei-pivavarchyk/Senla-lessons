package com.dao;

import com.entity.User;

public interface IUserDAO extends IBaseDAO<User> {
    Boolean checkUser(User user);
}
