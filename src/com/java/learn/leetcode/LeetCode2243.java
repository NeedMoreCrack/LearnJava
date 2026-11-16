package com.java.learn.leetcode;

public class LeetCode2243 {
    public static void main(String[] args) {
        String str = "11111222223";
        System.out.println(digitSum(str, 3));
    }

    public static String digitSum(String s, int k) {
        int num = 0;
        String str = "";
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {
            if(!str.isEmpty() && i % k == 0){
                for (int j = 0; j < str.length(); j++) {
                    num += Integer.valueOf(str.charAt(j));
                }
                newStr += String.valueOf(num);
                if(i != s.length()-1){
                    str = "";
                }
                num = 0;
            }else {
                str += (char)s.charAt(i);
            }
        }
        return newStr;
    }
}
