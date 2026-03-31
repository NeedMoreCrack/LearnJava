package poker.test;

import poker.Users;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        String account = "abc";
        String password = "123";
        String account2 = "def";
        String password2 = "456";
        Map<String,String> m = new HashMap<>();
        m.put(account,password);
        m.put(account2,password2);
        new Users(account,password,0);
        new Users(account2,password2,0);
        Set<String> strings = m.keySet();
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
