package com.controller;


import com.model.User;
import com.model.UserData;
import com.nimbusds.jwt.SignedJWT;

import com.service.ObjectConverterToJson;
import com.service.TokenHandler;
import com.service.UserDataService;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;


@Controller

public class UserDataServlet {
    private static Logger log = Logger.getLogger(UserDataServlet.class);

    private UserService userService = new UserService();
    private UserDataService userDataService=new UserDataService();


    @RequestMapping(
            value = {"api/profile"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    private UserData getUserData(@RequestHeader String login) {

Long id= TokenHandler.getInstance().getUserIdByToken(login);

userDataService.getUserDataByUser()



   return null;
    }

}