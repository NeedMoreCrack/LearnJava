package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Stream6 {
    public static void main(String[] args) {
        /*
            有兩個ArrayList集合
            第一個集合中：儲存6名男演員的名字和年齡。第二個集合中：儲存6名女演員的名字和年齡。 姓名和年齡用逗號隔開
            要求完成如下操作：
                1.男演員只要名字為三個字的前兩人
                2.女演員只要姓楊的，並且不要第一個
                3.把過濾後的男演員姓名和女演員姓名合併在一起
                4.將上一步的演員訊息封裝成Actor對象
                5.將所有的演員對象都保存到List集合中
                P.S：演員類Actor，屬性只有name,age
        */
        ArrayList<String> maleActors = new ArrayList<>();
        Collections.addAll(maleActors, "鄧超,44", "吳京,49","張一山,32", "劉德華,60", "陳曉東,45", "周杰倫,43"  );
        ArrayList<String> femaleActors = new ArrayList<>();
        Collections.addAll(femaleActors, "楊冪,36", "楊紫,30", "迪麗熱巴,31", "楊穎,34", "周迅,49", "趙麗穎,36" );
        Stream<String> maleStream = maleActors.stream().skip(2).limit(2);
        Stream<String> femaleStream = femaleActors.stream().skip(1).filter(s->s.startsWith("楊"));
        List<Actors> list = Stream.concat(maleStream, femaleStream)
            .map(s -> new Actors(s.split(",")[0], Integer.parseInt(s.split(",")[1]))).toList();
        list.forEach(s-> System.out.println(s));
    }
}
