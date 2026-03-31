package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q4 {
    public static void main(String[] args) {
        int[] numArr = new int[99];
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
//        System.out.print(list+" ");
        Collections.shuffle(list);
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = list.get(i);
        }
        for (int i : numArr) {
            System.out.print(i+" ");
            count++;
        }
        System.out.println("\ncount = "+count);
    }
}
