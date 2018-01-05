package com.dependencyService.main;


import com.configurator.IConfigurator;
import com.dependencyService.DependencyService;

public class Main {

    public static void main(String[] args) {
        IConfigurator configurator=(IConfigurator) DependencyService.getDI().getInstance(IConfigurator.class);
   System.out.println(configurator.getClass().getName());
    }
}