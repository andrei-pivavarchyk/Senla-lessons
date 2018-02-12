package com.controller;

import com.model.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by андрей on 12.02.2018.
 */
@Controller
public class TestController {


    @RequestMapping(
            value = {"data"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    private String getUserData() {

        String str="some string";
        return str;
    }
}
