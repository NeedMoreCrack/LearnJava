package stringDemo;

import java.util.StringJoiner;

public class String_11 {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",","[","]");
        sj.add("A");
        sj.add("B");
        sj.add("C");
        System.out.println(sj);
    }
}
