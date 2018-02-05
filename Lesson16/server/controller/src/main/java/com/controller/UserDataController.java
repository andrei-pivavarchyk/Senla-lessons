package com.controller;

import com.model.UserData;
import com.service.TokenHandler;
import com.service.api.IUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller

public class UserDataController {
    @Autowired
    private IUserDataService userDataService;

    @RequestMapping(
            value = {"api/profile"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    private UserData getUserData(@RequestHeader String token, HttpServletResponse response) {
        Long id = TokenHandler.getInstance().getUserIdByToken(token);
        if (id != null) {
            UserData userData = userDataService.getUserDataByUserId(id);
            if (userData != null) {
                return userData;
            }
        }
        response.setStatus(204);
        return new UserData();
    }
}