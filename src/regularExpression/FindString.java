package regularExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String word = "[is]{2}";
        String text = "Today is 2025-04-21, tomorrow is 2025-04-22, invalid date 2025-13-01.";
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            String str = matcher.group();
            list.add(str);
        }
        System.out.println(list);
    }
}
