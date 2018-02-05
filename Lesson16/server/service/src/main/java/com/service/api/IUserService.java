package com.service.api;

import com.model.User;

public interface IUserService {


    public void addUser(User entity);

    public void updateUser(User entity);

    Integer checkUser(String login,String password);
}
