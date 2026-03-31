package stream;

import java.util.ArrayList;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        /*
            題目：
                1.把所有以"張"開頭的元素儲存到新集合中
                2.把"張"開頭,長度為3的元素再儲存到新集合中
                3.印出最終結果
        */
        List<String> list = new ArrayList<>();
        list.add("張無忌");
        list.add("周芷若");
        list.add("趙敏");
        list.add("張強");
        list.add("張三豐");

        list.stream().filter(name->name.startsWith("張")).forEach(n-> System.out.println(n));
        System.out.println("===============================");
        list.stream().filter(name->name.startsWith("張") && name.length() == 3).forEach(n-> System.out.println(n));
    }
}
