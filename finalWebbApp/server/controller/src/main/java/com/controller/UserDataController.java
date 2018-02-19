package com.controller;

import com.model.UserData;

import com.serviceAPI.IUserDataService;
import com.serviceAPI.IUserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserDataController {
    @Autowired
    private IUserDataService userDataService;
    @Autowired
    private IUserHandler userHandler;

    @RequestMapping(
            value = {"api/profile"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    public UserData getUserData(HttpServletResponse response) {
        response.setContentType("application/json");
        UserData userData = new UserData();
        if (userData != null) {
            return userData;
        }
        response.setStatus(204);
        return new UserData();
    }
}