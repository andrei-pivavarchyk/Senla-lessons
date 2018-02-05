package com.controller;

import com.service.TokenHandler;
import com.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    IUserService userService;

    public LoginController() {
    }

    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    public void login(@RequestHeader String login, @RequestHeader String password, HttpServletResponse response) {

        Long id = userService.checkUser(login, password);
        if (id != null) {
            String token = TokenHandler.getInstance().createToken(id);
            response.addHeader("token", token);
        } else {
            response.setStatus(401);
        }
    }
}
