package com;

import com.dao.UserDAO;
import com.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.ObjectConverterToJson;
import com.service.TokenHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        UserDAO userDAO = new UserDAO();
        User user = new User("vdxvbcx", "fafas");
        System.out.println(ObjectConverterToJson.convertObject(user));
        System.out.println(userDAO.checkUser(user));
        // System.out.println(userDAO.getEntityById(1).getLogin());

        String token = TokenHandler.getInstance().createToken("Bob", "White");
        Boolean checkFirstTime = TokenHandler.getInstance().checkToken(token);
        Boolean checkSecondTime = TokenHandler.getInstance().checkToken("fdsfdsfsfdssdfs");

        System.out.println(token);
        System.out.println(checkFirstTime);
        System.out.println(checkSecondTime);




    }
}
