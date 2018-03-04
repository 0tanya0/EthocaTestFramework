package com.ethoca.base;


public class StringUtils {
    public static String generateRandomEmail(){
        long currentTome = System.currentTimeMillis();
        return currentTome + "@gmail.com";
    }
}
