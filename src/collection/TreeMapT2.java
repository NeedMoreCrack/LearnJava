package collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapT2 {
    public static void main(String[] args) {
        Map<String,String> m = new TreeMap<>(Comparator.reverseOrder());
        m.put("B","2");
        m.put("C","3");
        m.put("A","1");
        System.out.println(m);
    }
}
