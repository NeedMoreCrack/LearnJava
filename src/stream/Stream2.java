package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream2 {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        Collections.addAll(list,"鍾離-男-5000","綺良良-女-14","巴爾澤布-女-18","一斗-男-20","萬葉-男-25","老爺-男-35","優菈-女-30","芙寧娜-女-500","琳妮特-女-16");
        Set<String> collect = list.stream().filter(s->"男".equals(s.split("-")[1])).collect(Collectors.toSet());
        System.out.println(collect);
    }
}
