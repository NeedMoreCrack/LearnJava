package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsT2 {
    public static void main(String[] args) {
        int[] num = {9,1,5,6,7,8,4,2,3,0};
        List<Integer> l = new ArrayList<>();
        for (int i : num) {
           l.add(i);
        }
        l.sort((a, b) -> b - a);
        for (Integer i : l) {
            System.out.print(i+" ");
        }
    }
}
