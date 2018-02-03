package com.journaldev.controller;


import com.journaldev.model.User;
import com.journaldev.model.UserData;
import com.journaldev.service.ObjectConverterToJson;
import com.journaldev.service.UserDataService;
import com.journaldev.service.UserService;
import com.nimbusds.jwt.SignedJWT;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;


@Controller
@RequestMapping("/userdata")
public class UserDataServlet {
    private static Logger log = Logger.getLogger(UserDataServlet.class);

    private UserService userService = new UserService();
    private UserDataService userDataService=new UserDataService();

    @RequestMapping(method = RequestMethod.GET)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userData = this.getUserData(request);
        response.addHeader("userdata", userData);
    }


    private String getUserData(HttpServletRequest request) {


        String token = request.getHeader("token");
        String login = null;
        String password = null;

        try {
            login = (String) SignedJWT.parse(token).getJWTClaimsSet().getClaim("login");
            password = (String) SignedJWT.parse(token).getJWTClaimsSet().getClaim("password");

        } catch (ParseException e) {
            log.error(e.toString());
        }

        User user = userService.getUserByLoginPassword(login, password);
        UserData userData = userDataService.getUserDataByUser(user);
        String userDataJson = ObjectConverterToJson.convertObject(userData);
        return userDataJson;
    }

}