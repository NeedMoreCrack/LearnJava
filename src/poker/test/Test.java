package poker.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        StringBuilder eng = new StringBuilder();
        StringBuilder num = new StringBuilder();
        Random r = new Random();
        StringBuilder captcha = new StringBuilder();
        for(char i=65;i<91;i++){
            eng.append(i);
        }
        for(char i=97;i<123;i++){
            eng.append(i);
        }
        for (int i = 0; i < 10; i++) {
            num.append(i);
        }
        while(captcha.length() < 5){
            if(captcha.length() < 4){
                captcha.append(eng.charAt(r.nextInt(52)));
            }else{
                captcha.append(num.charAt(r.nextInt(10)));
            }
        }
        System.out.println(captcha);
    }
}
