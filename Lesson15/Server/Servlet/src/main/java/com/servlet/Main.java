package com.servlet;

import com.configurator.IConfigurator;
import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.testHotel.controller.HotelController;

public class Main {
    public static void main(String[] args) {
        IConfigurator configurator=(IConfigurator) DependencyService.getDI().getInstance(IConfigurator.class);
        System.out.print(configurator);
    }
}
