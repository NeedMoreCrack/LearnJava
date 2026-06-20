package regularExpression;

public class  RegularExpression {
    public static boolean isValidEmail(String email) {
        // 檢查空值或空字符串
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        // 改進的正規表達式
        String emailFormat = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailFormat);
    }

    public static boolean isValidPhone(String phone){
        String phoneFormat = "[09]{2}-?\\d{4}-?\\d{4}";
        return phone.matches(phoneFormat);
    }
}
