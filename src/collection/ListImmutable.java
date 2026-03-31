package collection;

import java.util.List;

public class ListImmutable {
    public static void main(String[] args) {
        List<String> list = List.of("a","b","c");//of() jdk8 no this method
        list.remove(0);
    }
}
