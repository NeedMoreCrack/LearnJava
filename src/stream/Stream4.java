package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stream4 {
    public static void main(String[] args) {
        /*
            定義一個集合1～10
            過濾機數 只留下偶數 並將結果保存起來
        */
        List<Integer> num = new ArrayList<>();
        Collections.addAll(num,1,2,3,4,5,6,7,8,9,10);
        List<Integer> newNum = num.stream().filter(n->n%2 == 0).toList();
        System.out.println(newNum);
    }
}
