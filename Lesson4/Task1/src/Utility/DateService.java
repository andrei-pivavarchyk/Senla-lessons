package Utility;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateService {
    public static int getDaysDifference(Date date1, Date date2) {
        long diff = date2.getTime() - date1.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}