package methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        Collections.addAll(list,"鍾離-5000","綺良良-14","巴爾澤布-18","一斗-20",
            "萬葉-25","老爺-35","優菈-30","芙寧娜-500","琳妮特-16");
        List<Students> arrStu = list.stream().map(Students::new).toList();
        String[] str = arrStu.stream().map(Students::getName).toArray(String[]::new);
        for (String s : str) {
            System.out.println(s);
        }
    }
}
