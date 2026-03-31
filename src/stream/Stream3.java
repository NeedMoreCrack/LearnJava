package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Stream3 {
    public static void main(String[] args) {
        /*
            收集到MAP集合中
            名字為KEY
         */
        var list = new ArrayList<String>();
        Collections.addAll(list,"鍾離-5000","綺良良-14","巴爾澤布-18","一斗-20",
            "萬葉-25","老爺-35","優菈-30","芙寧娜-500","琳妮特-16");
        Map<String,String> map = list
            .stream()
            .collect(Collectors
                .toMap(s->s.split("-")[0], s->s.split("-")[1]));
        map.forEach((k,v)-> System.out.println(k+"="+v));
    }
}
