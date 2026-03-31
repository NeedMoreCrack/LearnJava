package collection;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapT3 {
    public static void main(String[] args) {
        String str = "aababcabcdabcde";
        Map<String,Integer> m = new TreeMap<>();
        Set<Map.Entry<String, Integer>> entries = m.entrySet();
        Set<String> hs = new HashSet<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            hs.add(Character.toString(c));
        }
        for (String s : hs) {
            m.put(s,0);
        }
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            int value = entry.getValue();
            for(int i=0;i<str.length();i++) {
                char c = str.charAt(i);
                if(key.equals(Character.toString(c))){
                    value++;
                    m.put(key,value);
                }
            }
        }
        System.out.println(m);
    }
}
