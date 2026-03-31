package methodreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class MethodReference2 {
    public static void main(String[] args) {
        /*
            把以下數字變為int類型
            List<String> al = new ArrayList<>();
            "1","2","3","4","5"
        */
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3","4","5");
        Function<String,Integer> f = Integer::parseInt;
        for (String s : list) {
            System.out.println(f.apply(s));
        }
//        list.stream().map(Integer::parseInt).forEach(System.out::println);
    }
}
