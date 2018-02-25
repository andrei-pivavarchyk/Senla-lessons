package com.controller;

import com.model.UserData;

import com.serviceAPI.ITokenHandler;
import com.serviceAPI.IUserDataService;
import com.serviceAPI.IUserHandler;
import com.serviceAPI.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserDataController {
    @Autowired
    private IUserDataService userDataService;
    @Autowired
    private IUserHandler userHandler;

    @Autowired
    private ITokenHandler tokenHandler;

    @Autowired
    private IUserService userService;

    @RequestMapping(
            value = {"api/profile"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    public UserData getUserData(HttpServletResponse response,HttpServletRequest request) {
        String token= request.getHeader("authorization");
        Integer userID=this.tokenHandler.getUserIdByToken(token);
        if(userID!=null) {
            UserData userData = this.userDataService.getUserDataByUserId(userID);
            response.setContentType("application/json");
            if (userData != null) {
                return userData;
            }
        }
        response.setStatus(204);
        return new UserData();
    }
}