package com.controller;

import com.exception.NoSuchUserException;
import com.exception.UserRegistrationException;
import com.model.*;
import com.serviceAPI.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private IOrderService orderService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private  IBookService bookService;
    @Autowired
    private IUserHandler userHandler;

    @Autowired
    private IBookDTOService bookDTOService;

    private static Logger log = Logger.getLogger(UserController.class);

    public UserController() {
    }

    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map login(HttpServletResponse response, @RequestBody User user) throws NoSuchUserException {
        Integer id = userService.loginUser(user);
        if (id != null) {
            String token = tokenHandler.createToken(id);
            response.addHeader("Authorization", token);
            Map result = new HashMap();
            result.put("success", true);
            result.put("message", "Success login");
            return result;
        } else {
            throw new NoSuchUserException("Invalid Password or Login");
        }
    }

    @RequestMapping(
            value = {"/registration"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map registration(HttpServletResponse response, @RequestBody User user) throws UserRegistrationException {
        Map result = userService.registrationUser(user);
        return result;
    }


    @RequestMapping(
            value = {"api/profile"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public UserData getUserData(HttpServletResponse response) {

        UserData userData = this.userDataService.getUserDataByUserId(this.userHandler.getUser().getId());
        if (userData != null) {
            UserData dto = userDataDTOService.getUserDataDTO(userData);
            return dto;
        } else {
            response.setStatus(204);
            return new UserData();
        }
    }
    @RequestMapping(
            value = {"api/profile-update"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public UserData updateUserData(HttpServletResponse response, @RequestBody UserData updateUserData) {
        Map result = this.userDataService.updateUserData(updateUserData);
        if (result.get("success").equals(true)) {
            UserData userData = this.userDataService.getUserDataByUserId(this.userHandler.getUser().getId());
            return this.userDataDTOService.getUserDataDTO(userData);
        } else {
            response.setStatus(400);
            return new UserData();
        }
    }

    @RequestMapping(
            value = {"api/books"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public List<Book> getBooksFromShoppingCart(HttpServletResponse response) {

        UserData userData = this.userDataService.getUserDataWithFavorites(this.userHandler.getUser().getId());
        List<Book> bookList = this.bookDTOService.getBookList(userData.getFavorites());
        if (bookList != null) {
            return bookList;
        }
        response.setStatus(204);
        return new ArrayList<>();
    }

    @RequestMapping(
            value = {"api/add-to-cart"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public void addBooksToShoppingCart(HttpServletResponse response, HttpServletRequest request, @RequestBody Book book) {
        this.userDataService.addBookToCart(this.userHandler.getUser().getId(), book);

    }

    @RequestMapping(
            value = {"api/orders"},
            method = {RequestMethod.GET}
    )

    @ResponseBody
    public List<Order> getOrdersByUser(HttpServletResponse response, HttpServletRequest request) {
        User user = this.userHandler.getUser();
        List<Order> orderList = this.orderService.getAllUserOrders(user);
        if (orderList.isEmpty()) {
            response.setStatus(204);
            return new ArrayList<>();
        }
        return orderList;
    }


    @ResponseBody
    @ExceptionHandler(NoSuchUserException.class)
    public Map handleUserLoginException(NoSuchUserException ex) {
        log.error(ex.toString());
        return this.setResult(ex);
    }

    @ResponseBody
    @ExceptionHandler(UserRegistrationException.class)
    public Map handleUserLoginException(UserRegistrationException ex) {
        log.error(ex.toString());
        return this.setResult(ex);
    }

    private Map setResult(Exception ex) {
        Map result = new HashMap();
        result.put("success", false);
        result.put("message", ex.getMessage());
        return result;
    }
}
