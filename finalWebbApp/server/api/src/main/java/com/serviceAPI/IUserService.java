package com.serviceAPI;

import com.model.User;

public interface IUserService {

     void addUser(User entity);

     void updateUser(User entity);

    Long checkUser(User user);
}
