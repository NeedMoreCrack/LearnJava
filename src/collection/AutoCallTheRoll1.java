package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoCallTheRoll1 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        Collections.addAll(l,"Andy","Simon","Kelly","Alex","Jeff");
        Collections.shuffle(l);
        System.out.println(l.getFirst());
    }
}
