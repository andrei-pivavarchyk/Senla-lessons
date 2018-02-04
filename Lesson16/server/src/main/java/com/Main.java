package com;

import com.dao.BaseDAO;
import com.dao.TestClass;
import com.dao.UserDAO;
import com.dao.UserDataDAO;
import com.dao.api.IUserDAO;
import com.entity.User;
import com.entity.UserData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jwt.SignedJWT;
import com.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDAO personDAO = context.getBean(UserDAO.class);


      //  BaseDAO baseDAO=(BaseDAO)context.getBean("base");



/*

        IUserDAO userDAO = new UserDAO();
        UserDataDAO userDataDAO = new UserDataDAO();

        UserService userService = new UserService();
        UserDataService userDataService = new UserDataService();

        User user = new User(3, "vdxvbcx", "fafas");
        UserData userData = new UserData(user, "Bob", "White", "White", new Date());

        userService.addUser(user);

        userDataService.addUserData(userData);
        UserData userData2 = userDataService.getUserDataByUser(user);
        System.out.println(userData2);
        // userDAO.deleteEntity(2);
        // userDataDAO.addEntity(userData);

        System.out.println(ObjectConverterToJson.convertObject(user));



        String query="{\"type\":\"User\",\"id\":3,\"login\":\"666\",\"password\":\"fafas\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user2 = objectMapper.readValue(query, User.class);
            System.out.println(user2.getLogin());
            System.out.println(user2.getPassword());
            System.out.println(userService.checkUser(user2));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ObjectConverterToJson.convertObject(user));
        System.out.println(userDAO.checkUser(user));
        // System.out.println(userDAO.getEntityById(1).getLogin());

        String token = TokenHandler.getInstance().createToken("vdxvbcx", "fafas");
        Boolean checkFirstTime = TokenHandler.getInstance().checkToken(token);
        //   Boolean checkSecondTime = TokenHandler.getInstance().


        System.out.println(token);
        System.out.println(checkFirstTime);
        // System.out.println(checkSecondTime);

*/
    }
}
