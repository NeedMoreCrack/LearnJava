package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsT1 {
    public static void main(String[] args) {
        int[] num = {9,1,5,6,7,8,4,2,3,0};
        int[] newNum = new int[9];
        List<Integer> l = new ArrayList<>();
        for (int i : num) {
            l.add(i);
        }
        Collections.shuffle(l);
        System.out.println(l);
        int j = 0;
        for (Integer i : l) {
            if(j == 9){
                break;
            }
            newNum[j] = i;
            j++;
        }
        System.out.println(Arrays.toString(newNum));
    }
}
