package com.service.api;

import com.model.User;

public interface IUserService {

     void addUser(User entity);

     void updateUser(User entity);

    Long checkUser(String login,String password);
}
