package com.lx.utils;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtils {

    /**
     * 将date转化为字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToStr(Date date, String pattern) {
//        初始化格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);

        return format;
    }

    /**
     * 将字符串转化成date
     *
     * @param string
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String string, String pattern) throws ParseException {
        //        初始化格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date parse = (Date) simpleDateFormat.parse(string);
        return parse;
    }
}
