package methodReference;

import java.util.*;

public class MethodReference4 {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        Collections.addAll(list,"鍾離-5000","綺良良-14","巴爾澤布-18","一斗-20",
            "萬葉-25","老爺-35","優菈-30","芙寧娜-500","琳妮特-16");
        List<Students> newlist = list.stream().map(Students::new).toList();
        newlist.forEach(s-> System.out.println(s));
    }
}
