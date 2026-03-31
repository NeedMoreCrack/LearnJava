package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream5 {
    public static void main(String[] args) {
        /*
            ArrayList<String> al = new ArrayList<>();
            "小明,23","小王,24","小美,25"
            保留年齡大於等於24歲的人，並將結果存入MAP集合中，名字為Key，年齡為value
        */
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al,"小明,23","小王,24","小美,25");
        Map<String,Integer> map = al.stream()
            .filter(s->Integer.parseInt(s.split(",")[1]) >= 24)
            .collect(Collectors.toMap(s->s.split(",")[0],s->Integer.parseInt(s.split(",")[1])));
        System.out.println(map);
    }
}
