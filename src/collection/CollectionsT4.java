package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsT4 {
    public static void main(String[] args) {
        int[] num = {9,1,5,6,7,8,4,2,3,0};
        List<Integer> l = new ArrayList<>();
        for (int i : num) {
           l.add(i);
        }
        System.out.println(Collections.max(l));
        System.out.println(Collections.min(l));
        l.sort(null);
        Collections.swap(l,0,9);
        System.out.println(l);
    }
}
