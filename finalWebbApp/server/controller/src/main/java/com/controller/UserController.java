package com.controller;

import com.model.Book;
import com.model.User;
import com.model.UserData;
import com.serviceAPI.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ITokenHandler tokenHandler;
    @Autowired
    private IUserDataService userDataService;
    @Autowired
    private IUserDataDTOService userDataDTOService;
    @Autowired
    IUserHandler userHandler;
    private static Logger log = Logger.getLogger(UserController.class);

    public UserController() {
    }

    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public void login(HttpServletResponse response, @RequestBody User user) {

        Integer id = userService.checkUser(user);
        if (id != null) {
            String token = tokenHandler.createToken(id);
            response.addHeader("Authorization", token);

        } else {
            response.setStatus(401);
        }

    }

    @RequestMapping(
            value = {"/registration"},
            method = {RequestMethod.POST}

    )
    @ResponseBody
    public void registration(HttpServletResponse response, @RequestBody User user) {

        Integer id = userService.checkUser(user);
        if (id == null) {
            userService.addUser(user);
        } else {
            response.setStatus(403);
        }
    }

    @RequestMapping(
            value = {"api/profile"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    public UserData getUserData(HttpServletResponse response, HttpServletRequest request) {

            UserData userData = this.userDataService.getUserDataByUserId(userHandler.getUser().getId());
            response.setContentType("application/json");
            if (userData != null) {
                UserData dto=userDataDTOService.getUserDataDTO(userData);
                return dto;
            }
            else{
                response.setStatus(204);
                return new UserData();
            }
    }



    @RequestMapping(
            value = {"api/books"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    public List<Book> getFavoriteBooks(HttpServletResponse response, HttpServletRequest request) {

        UserData userData=this.userDataService.getUserDataWithFavorites(this.userHandler.getUser().getId());
        List<Book> bookList = this.userDataDTOService.getBookList(userData.getFavorites());
        if(bookList!=null) {

            response.setContentType("application/json");
            return bookList;
        }
        response.setStatus(204);
        return new ArrayList<>();
    }
}
