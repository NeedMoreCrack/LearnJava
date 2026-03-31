package methodreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReference3 {
    public static void main(String[] args) {
        /*
            "張無忌","周芷若","趙敏","張強","張三豐"
            要求：只能以張開頭，且名字要三個字
        */
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"張無忌","周芷若","趙敏","張強","張三豐");
        list.stream().filter(new MethodReference3()::limitString)
            .forEach(System.out::println);
    }
    public boolean limitString(String s){
        return s.startsWith("張") && s.length() == 3;
    }
}
