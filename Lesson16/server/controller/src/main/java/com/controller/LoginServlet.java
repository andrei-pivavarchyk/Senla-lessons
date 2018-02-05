package com.controller;

import com.dao.UserDAO;
import com.model.User;
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
            method = {RequestMethod.GET}
    )
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user=new User("succes","succes");
        userService.addUser(user);
        response.getWriter().write("succes");
    }

    @RequestMapping(
            value = {"/loginn"},
            method = {RequestMethod.POST}
    )
    public void loginn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user=new User("succes","succes");
        userService.addUser(user);
        response.getWriter().write("succes");
    }
}
