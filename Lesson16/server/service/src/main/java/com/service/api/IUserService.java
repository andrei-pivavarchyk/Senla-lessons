package com.service.api;

import com.model.User;

public interface IUserService {


    public void addUser(User entity);

    public void updateUser(User entity);

    Long checkUser(String login,String password);
}
