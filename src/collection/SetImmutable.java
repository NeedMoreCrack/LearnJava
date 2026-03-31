package collection;

import java.util.HashSet;
import java.util.Set;

public class SetImmutable {
    public static void main(String[] args) {
        var set = new HashSet<String>();//Java 10
        System.out.println("=========================");
        Set<String> set2 = Set.of("a","b","c");
        set2.add("d");
    }
}
