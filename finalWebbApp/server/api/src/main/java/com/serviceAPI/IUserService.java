package com.serviceAPI;

import com.model.Role;
import com.model.User;
import com.model.UserData;

public interface IUserService {

    void addUser(User entity);

    void updateUser(User entity);

    Long checkUser(User user);

    UserData getUserDataByUser(User user);

    void removeUser(User user);

    Role getRoleByUser(User user);
    User getUserByID(Long id);

}
