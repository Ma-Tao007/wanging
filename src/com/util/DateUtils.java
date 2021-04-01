package com.util;


import java.text.SimpleDateFormat;

import java.util.Date;

/*
@description
*/
public class DateUtils {
    private DateUtils() {
    };

    /* 获得当前时间 */
    public static String getCurrentTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
