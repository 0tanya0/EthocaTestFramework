package com.automationpractice.base;


public class StringUtils {
    public static String generateRandomEmail(){
        long currentTime = System.currentTimeMillis();
        return currentTime + "@gmail.com";
    }
}
