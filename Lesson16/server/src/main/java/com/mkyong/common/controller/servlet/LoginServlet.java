package com.mkyong.common.controller.servlet;

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

    @RequestMapping(method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login =  request.getParameter("login");
        String password =  request.getParameter("password");

        PrintWriter pw = response.getWriter();
        pw.print(login+password);
    }

}