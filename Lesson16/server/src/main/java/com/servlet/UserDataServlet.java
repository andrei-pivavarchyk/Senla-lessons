package com.servlet;

import com.dao.api.IUserDAO;
import com.dao.api.IUserDataDAO;
import com.entity.User;
import com.entity.UserData;
import com.nimbusds.jwt.SignedJWT;
import com.service.ContextUtil;
import com.service.ObjectConverterToJson;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;


@Controller
@RequestMapping("/userdata")
public class UserDataServlet {
    private static Logger log = Logger.getLogger(UserDataServlet.class);

    private IUserDataDAO userDataDao = (IUserDataDAO) ContextUtil.getInstance().getContext().getBean("userDataDao");
    IUserDAO userDao = (IUserDAO) ContextUtil.getInstance().getContext().getBean("userDao");

    @RequestMapping(method = RequestMethod.GET)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userData = this.getUserData(request);
        response.addHeader("userdata", userData);
    }


    private String getUserData(HttpServletRequest request) {


        String token = request.getHeader("token");
        String login = null;
        String password = null;

        try {
            login = (String) SignedJWT.parse(token).getJWTClaimsSet().getClaim("login");
            password = (String) SignedJWT.parse(token).getJWTClaimsSet().getClaim("password");

        } catch (ParseException e) {
            log.error(e.toString());
        }

        User user = userDao.getUserByLoginPassword(login, password);
        UserData userData = userDataDao.getDataByUser(user);

        String userDataJson = ObjectConverterToJson.convertObject(userData);

        return userDataJson;
    }

}