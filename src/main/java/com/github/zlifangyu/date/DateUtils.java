package com.github.zlifangyu.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhengli
 * @desp 日期工具类
 * @date 2021/9/23
 * @version 1.0
 */
public class DateUtils {
    /**
     * 格式化时间字符串
     * @param str
     * @return  yyyy-MM-dd
     */
    public static String formatDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format.format(time);
    }

    /**
     * 格式化时间字符串
     * @param str
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String formatDatetime(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format.format(time);
    }
    /**
     * 当前日期
     * @return String date
     */
    public static String getTodayDateStr() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 当前时间
     * @return String time
     */
    public static String getTodayTimeStr() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(date);
    }

    /**
     * 当前日期时间
     * @return String date time
     */
    public static String getTodayDateTimeStr() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 当天的开始时间
     * @return date time
     */
    public static String getBeginToday() {
        return getTodayDateStr() + " 00:00:00";
    }

    /**
     * 当天的结束时间
     * @return date time
     */
    public static String getEndToday() {
        return getTodayDateStr() + " 23:59:59";
    }

    /**
     * 当天的开始时间
     * @return date time
     */
    public static Long getBeginTodayUnix() {
        String str = getTodayDateStr() + " 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(str);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 当天的结束时间
     * @return date time
     */
    public static Long getEndTodayUnix() {
        String str = getTodayDateStr() + " 23:59:59";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(str);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 当月第一天日期
     * @return String
     */
    public static String getFirstDayOfMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMinimum(Calendar.DAY_OF_MONTH));
        String first = format.format(ca.getTime());
        return first;
    }

    /**
     * 当月第一天日期时间戳
     * @return Long
     */
    public static Long getFirstDayOfMonthUnix() {
        String firstDay = getFirstDayOfMonth() + " 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(firstDay).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 当月最后一天日期
     * @return String
     */
    public static String getLastDayOfMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        return last;
    }
    /**
     * 当月最后一天日期时间戳
     * @return String
     */
    public static Long getLastDayOfMonthUnix() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String last = getLastDayOfMonth() + " 23:59:59";
        try {
            return format.parse(last).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
