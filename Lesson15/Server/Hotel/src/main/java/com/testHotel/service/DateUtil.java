package com.testHotel.service;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    public static Date getDate(int year, int month, int day){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
       gregorianCalendar.set(year,month,day);
       return new Date(gregorianCalendar.getTimeInMillis());
    }
}
