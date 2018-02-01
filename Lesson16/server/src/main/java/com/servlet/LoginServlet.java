package com.servlet;

import com.dao.UserDAO;
import com.dao.api.IUserDAO;
import com.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.ContextUtil;
import com.service.TokenHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/authentication")
public class LoginServlet {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private IUserDAO userDAO = (IUserDAO) ContextUtil.getInstance().getContext().getBean("userDao");

    @RequestMapping(method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String query = request.getReader().readLine();

        User user = objectMapper.readValue(query, User.class);
        Boolean userExist = userDAO.checkUser(user);
        String token = null;
        if (userExist) {
            token = TokenHandler.getInstance().createToken(user.getLogin(), user.getPassword());
            response.addHeader("token", token);
        } else {

            response.sendError(404);
        }
    }
}