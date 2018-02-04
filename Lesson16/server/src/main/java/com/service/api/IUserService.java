package com.service.api;

import com.entity.User;
import org.hibernate.Session;

public interface IUserService {


    public void addUser(User entity);

    public void updateUser(User entity);
    Boolean checkUser(User user);
}
