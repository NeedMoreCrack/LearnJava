package collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetT1 {
    public static void main(String[] args) {
        Set<Students> ts = new TreeSet<>();
        Students s1 = new Students("Andy",28,60,55,80);
        Students s2 = new Students("Alen",25,80,60,100);
        Students s3 = new Students("Jeff",23,40,100,70);
        Students s4 = new Students("Kelly",27,70,60,95);
        Students s5 = new Students("Eric",33,50,66,100);
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.forEach(s -> System.out.println(s));
    }
}
