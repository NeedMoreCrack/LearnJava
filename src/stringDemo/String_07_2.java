package stringDemo;

import java.util.Scanner;

public class String_07_2 {
    public static void main(String[] args) {
        System.out.println("輸入字串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        strReverse(str);
    }
    public static void strReverse(String str){
        Character[] chArr = new Character[str.length()];
        StringBuilder strReverse = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            chArr[str.length()-i-1] = c;
        }
        for (Character character : chArr) {
            strReverse.append(character);
        }
        System.out.println(strReverse);
    }
}
