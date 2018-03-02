package com.serviceAPI;

import com.exception.UserRegistrationException;
import com.model.Role;
import com.model.User;
import com.model.UserData;

import java.util.Map;

public interface IUserService {

    void addUser(User entity);

    void updateUser(User entity);

    Integer loginUser(User user);

    UserData getUserDataByUser(User user);

    void removeUser(User user);

    Role getRoleByUser(User user);

    User getUserByID(Integer id);

    Map registrationUser(User user)throws UserRegistrationException;


}
