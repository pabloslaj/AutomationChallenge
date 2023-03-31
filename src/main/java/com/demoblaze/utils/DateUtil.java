package com.demoblaze.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getActualDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
        Date date = new Date();
        String actualDate = dateFormat.format(date);
        String actualTime = timeFormat.format(date);
        return actualDate + "_" + actualTime;
    }
    public static String getTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return Long.toString(timestamp.getTime());
    }
}
