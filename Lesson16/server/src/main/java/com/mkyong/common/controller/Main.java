package com.mkyong.common.controller;

import com.mkyong.common.controller.dao.UserDAO;

/**
 * Created by андрей on 29.01.2018.
 */
public class Main
{
    public static void main(String[] args){
        UserDAO userDAO=new UserDAO();

        System.out.println(userDAO.getEntityById(1).getLogin());
        TokenService login=new TokenService();
        try {
            String t=login.getToken("fds","fafas");
            System.out.println(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
