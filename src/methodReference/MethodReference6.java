package methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReference6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);
        Integer[] newarr = list.toArray(Integer[]::new);
    }
}
