package com.example.cjrh.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间工具类
 * 提供日期时间相关的常用操作
 */
public class DateUtils {
    
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_FORMAT);
    
    /**
     * 将LocalDateTime格式化为字符串
     */
    public static String format(LocalDateTime dateTime) {
        return format(dateTime, DEFAULT_FORMAT);
    }
    
    /**
     * 将LocalDateTime格式化为指定格式的字符串
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }
    
    /**
     * 将字符串解析为LocalDateTime
     */
    public static LocalDateTime parse(String dateTimeStr) {
        return parse(dateTimeStr, DEFAULT_FORMAT);
    }
    
    /**
     * 将指定格式的字符串解析为LocalDateTime
     */
    public static LocalDateTime parse(String dateTimeStr, String pattern) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTimeStr, formatter);
    }
}