package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaT2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);
        list.forEach(System.out::println);
    }
}
