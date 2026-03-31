package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListT1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(Integer.valueOf(1));

//        System.out.println(list);
        list.forEach(i -> System.out.println(i));
    }
}
