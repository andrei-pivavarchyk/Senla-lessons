package com.serviceAPI;

import com.model.Role;
import com.model.User;

public interface IUserHandler {
    User getUser();

    void setUser(User user);

    Role getRole();

    void setRole(Role role);

    Integer getUserDataId();

    void setUserDataId(Integer userDataId);

}
