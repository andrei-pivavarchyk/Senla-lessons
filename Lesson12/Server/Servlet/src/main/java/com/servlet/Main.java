package com.servlet;


import com.dao.IRoomDAO;
import com.dependencyService.DependencyService;
import com.propertyService.PPropertyService;

import java.util.Properties;

public class Main {
    public static void main(String[] args){
        IRoomDAO roomDAO=(IRoomDAO) DependencyService.getDI().getInstance(IRoomDAO.class);
        System.out.println(roomDAO);
    }
}
