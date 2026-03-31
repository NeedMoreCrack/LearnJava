package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
    public static void main(String[] args) {
        String text = "abcd1";
        System.out.println(regen(text));
    }
    public static boolean regen(String text){
        String matches = "^(?=.*[a-z])(?=.*\\d).*$";
        Pattern pattern = Pattern.compile(matches);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
