package com.service;


import com.serviceAPI.IUserHandler;
import org.springframework.stereotype.Component;

@Component
public class UserHandler implements IUserHandler {
    private Long userId;

    public UserHandler() {
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
