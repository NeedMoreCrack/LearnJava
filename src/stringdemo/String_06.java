package stringdemo;

import java.util.Scanner;

public class String_06 {
    public static void main(String[] args) {
        System.out.println("輸入任意文字：");
        Scanner sc = new Scanner(System.in);
        String enter = sc.next();
        int upperCount = 0;
        int lowerCount = 0;
        int numberCount = 0;
        for (int i = 0; i < enter.length(); i++) {
            char c = enter.charAt(i);
            if(c >= 'a' && c <= 'z'){
                lowerCount++;
            } else if (c >= 'A' && c <= 'Z') {
                upperCount++;
            }else{
                numberCount++;
            }
        }
        System.out.println("大寫："+upperCount+"\n小寫："+lowerCount+"\n數字："+numberCount);
    }
}
