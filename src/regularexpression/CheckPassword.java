package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPassword {
    public static void main(String[] args) {
        String password = "Aa1!aaaa";
        String password2 = "password";
        System.out.println(isStrongPassword(password2));
    }
    public static boolean isStrongPassword(String password){
        String passwordCheck = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$";
        Pattern pattern = Pattern.compile(passwordCheck);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
