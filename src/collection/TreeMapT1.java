package collection;

import java.util.TreeMap;

public class TreeMapT1 {
    public static void main(String[] args) {
        TreeMap<Integer,String> tm = new TreeMap<>((a,b)->b-a);
        tm.put(3,"C");
        tm.put(1,"A");
        tm.put(2,"B");
        System.out.println(tm);
    }
}
