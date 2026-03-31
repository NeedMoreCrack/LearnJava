package collection;

import java.util.HashMap;
import java.util.Map;

public class MapImmutable {
    public static void main(String[] args) {
        var hm = new HashMap<String,String>();//jdk 10
        hm.put("1","Andy");
        hm.put("2","Kelly");
        hm.put("3","Jeff");
        hm.put("4","Simon");
        hm.put("5","Timmy");
        hm.put("6","Tom");
        hm.put("7","Jerry");
        hm.put("8","Alex");
        hm.put("9","Belly");
        hm.put("10","Tonny");
        hm.put("11","Jimmy");
        /* jdk 10 can use copyOf() */
        Map<Object, Object> map = Map.ofEntries(hm.entrySet().toArray(new Map.Entry[0]));//jdk 9+ can use
        map.put("12","AAA");
    }
}
