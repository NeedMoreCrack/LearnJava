package methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReference5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"aaa","bbb","ccc","ddd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
