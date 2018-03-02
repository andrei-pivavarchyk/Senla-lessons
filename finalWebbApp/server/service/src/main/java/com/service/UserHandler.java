package com.service;

import com.model.Role;
import com.model.User;
import com.serviceAPI.IUserHandler;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserHandler implements IUserHandler {

    private User user;

    private Role role;

    private Integer userDataId;

    public UserHandler() {
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public Integer getUserDataId() {
        return userDataId;
    }

    public void setUserDataId(Integer userDataId) {
        this.userDataId = userDataId;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
