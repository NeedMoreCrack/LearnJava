package com.java.learn.basics.regex;

public class Phone{
    public static void main(String[] args) {
        String phoneNum = "09-1234-5678";
        System.out.println(RegularExpression.isValidPhone(phoneNum));
    }
}
