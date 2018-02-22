package com.controller;

import com.model.User;
import com.serviceAPI.ITokenHandler;
import com.serviceAPI.IUserService;
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

    public LoginController() {
    }
    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Token login(HttpServletResponse response, @RequestBody User user) {
        Integer id = userService.checkUser(user);
        if (id != null) {
            String token = tokenHandler.createToken(id);
            response.addHeader("Authorization",token);
            Token userToken=new Token();
            userToken.setToken(token);
            return userToken;
        } else {
            response.setStatus(401);
            return null;
        }
    }
}
