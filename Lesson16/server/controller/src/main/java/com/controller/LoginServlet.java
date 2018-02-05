package com.controller;

import com.dao.UserDAO;
import com.model.User;
import com.service.ObjectConverterToJson;
import com.service.TokenHandler;
import com.service.UserService;
import com.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginServlet {
    private static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    IUserService userService;

    public LoginServlet() {
    }

    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    public void login(@RequestHeader String login, @RequestHeader String password, HttpServletResponse response) {

        Integer id = userService.checkUser(login, password);
        String token = TokenHandler.getInstance().createToken(id);
        response.addHeader("token", token);
    }
}
