package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapT1 {
    public static void main(String[] args) {
        Map<String,String> m = new HashMap<>();
        m.put("1","Andy");
        m.put("2","Kelly");
        m.put("3","Eric");
//        Set<Map.Entry<String, String>> entries = m.entrySet();
//        for (Map.Entry<String, String> entry : entries) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key+" : "+value);
//        }

//        Iterator<String> i = m.keySet().iterator();
//        while(i.hasNext()){
//            String key = i.next();
//            String value = m.get(key);
//            System.out.println(key+" : "+value);
//        }
        m.forEach((key,value) -> System.out.println(key+" : "+value));
    }
}
