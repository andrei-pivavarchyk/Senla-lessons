package com;

import com.model.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args){
        Calendar calendar = new GregorianCalendar();
        Role role = Role.ADMIN;
        User user = new User(new Long(1), "Andrei", "Hrumov");
        Book book=new Book();
        Address userAddress = new Address(new Long(1), "Соломовой", "Гродно", "Гродненский", "Беоарусь", 240000);

     //   UserData userData = new UserData(user, "Bob", "White", "Black",calendar.getTime(),role,"gdf",32132131L,userAddress);

    }
}
