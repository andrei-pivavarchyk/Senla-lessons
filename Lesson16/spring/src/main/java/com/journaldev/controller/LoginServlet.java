package com.journaldev.controller;

import com.journaldev.service.TokenHandler;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.journaldev.dao.UserDAO;
import com.journaldev.model.User;
import com.journaldev.service.UserService;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/authentication")
public class LoginServlet {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private UserDAO userDAO = new UserDAO();
    private UserService userService = new UserService();

    @RequestMapping(method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String query = request.getReader().readLine();
        User user = objectMapper.readValue(query, User.class);
        Boolean userExist = userService.checkUser(user);

        String token = null;
        if (userExist) {
            token = TokenHandler.getInstance().createToken(user.getLogin(), user.getPassword());
            response.addHeader("token", token);
        } else {

            response.getWriter().write(query);
            //response.sendError(404);
        }
    }
}