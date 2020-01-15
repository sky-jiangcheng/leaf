package com.slimframework.util;

/**
 * 验证相关工具类
 */
public class ValidateUtil {

    public static boolean isEmpty(Object object){
        return object == null;
    }

    public static boolean isEmpty(String object){
        return (object == null||"".equals(object));
    }

    public static boolean isNotEmpty(Object object){
        return !isEmpty(object);
    }

    public static boolean isNotEmpty(String object){
        return !isEmpty(object);
    }
}
