package com.controller;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by андрей on 25.02.2018.
 */
@Controller
public class TestController {


    @RequestMapping(
            value = {"/test"},
            method = {RequestMethod.GET}
    )

    public void login(HttpServletResponse response) {

        try {
            response.getWriter().write("dsfds");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
