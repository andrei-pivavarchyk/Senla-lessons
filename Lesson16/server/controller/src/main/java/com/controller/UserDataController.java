package com.controller;

import com.model.UserData;
import com.service.api.ITokenHandler;
import com.service.api.IUserDataService;
import com.service.api.IUserHandler;
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
    private ITokenHandler tokenHandler;
    @Autowired
    private IUserHandler userHandler;

    @RequestMapping(
            value = {"api/profile"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    private UserData getUserData(HttpServletResponse response) {

        UserData userData = userDataService.getUserDataByUserId(userHandler.getUserId());
        if (userData != null) {
            return userData;
        }
        response.setStatus(204);
        return new UserData();
    }
}