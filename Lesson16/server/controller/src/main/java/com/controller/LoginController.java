package com.controller;

import com.service.api.ITokenHandler;
import com.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    IUserService userService;
    @Autowired
    private ITokenHandler tokenHandler;

    public LoginController() {
    }

    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    public void login(@RequestParam String login, @RequestParam String password, HttpServletResponse response) {

        Long id = userService.checkUser(login, password);
        if (id != null) {
            String token = tokenHandler.createToken(id);
            response.addHeader("token", token);
        } else {
            response.setStatus(401);
        }
    }
}
