package collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapT1 {
    public static void main(String[] args) {
        Map<Students,String> m = new HashMap<>();
        Students s1 = new Students("Andy",28,60,55,80);
        Students s2 = new Students("Alen",25,80,60,100);
        Students s3 = new Students("Jeff",23,40,100,70);
        m.put(s1,"日本");
        m.put(s2,"台灣");
        m.put(s3,"美國");
        m.forEach((stu, str) -> System.out.println(stu+":"+str));
    }
}
