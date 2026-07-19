package date;


import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class ZoneIds {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
//        System.out.println(zoneId);
        LocalDateTime localDateTime = LocalDateTime.of(2018, Month.DECEMBER, 24, 12, 30);
//        System.out.println(localDateTime);

        long between = ChronoUnit.YEARS.between(localDateTime, LocalDateTime.now());
        System.out.println(between);
    }
}
