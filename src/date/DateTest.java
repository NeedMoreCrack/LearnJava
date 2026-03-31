package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        String str = "2000-11-11";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(str);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd日");
        String result = simpleDateFormat2.format(date);
        System.out.println(result);
    }
}
