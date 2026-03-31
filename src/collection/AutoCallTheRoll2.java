package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutoCallTheRoll2 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        Collections.addAll(l,"Andy","Simon","Kelly","Alex","Jeff");
        for (int i = 0; i <= 5; i++) {
            double r = Math.random();
            System.out.println(r);
        }
    }
}
