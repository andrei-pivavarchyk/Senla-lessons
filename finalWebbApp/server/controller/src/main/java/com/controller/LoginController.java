package com.controller;

import com.model.User;
import com.service.UserDataService;
import com.serviceAPI.ITokenHandler;
import com.serviceAPI.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ITokenHandler tokenHandler;
    private static Logger log = Logger.getLogger(LoginController.class);

    public LoginController() {
    }

    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Token login(HttpServletResponse response, @RequestBody User user) {

        try {
            Integer id = userService.checkUser(user);
            if (id != null) {
                String token = tokenHandler.createToken(id);
                response.addHeader("Authorization", token);
                Token userToken = new Token();
                userToken.setToken(token);
                return userToken;
            } else {
                response.setStatus(401);
                return null;
            }

        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }
}
