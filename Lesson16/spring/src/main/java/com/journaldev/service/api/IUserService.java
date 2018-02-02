package com.journaldev.service.api;


import com.journaldev.model.User;

public interface IUserService {


    public void addUser(User entity);

    public void updateUser(User entity);

    Boolean checkUser(User user);
}
