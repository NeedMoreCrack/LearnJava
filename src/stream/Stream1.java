package stream;

import java.util.Arrays;
import java.util.List;

public class Stream1 {
    public static void main(String[] args) {
//        題目： 給定一個字串列表，使用 Stream 將所有字串轉為大寫並收集成一個新的列表。
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        String[] arr = words.stream().map(String::toUpperCase).toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
