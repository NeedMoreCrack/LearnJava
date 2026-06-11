package BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class BigDecimalDemo1 {
    public static void main(String[] args) {
        BigDecimal bd1 = BigDecimal.valueOf(10.0);
        BigDecimal bd2 = BigDecimal.valueOf(2.0);
        BigDecimal bd3 = bd1.add(bd2);
        System.out.println(bd3);

        /**
         * 除法會用到的
         * 常用的 RoundingMode：
         * HALF_UP（最常用，四捨五入）
         * DOWN（無條件捨去）
         * UP（無條件進位）
         * FLOOR（向負無限大）
         * CEILING（向正無限大）
         */
        BigDecimal bd4 = BigDecimal.valueOf(10.0);
        BigDecimal bd5 = BigDecimal.valueOf(2.0);
        BigDecimal bd6 = bd4.divide(bd5,0,RoundingMode.DOWN);
        System.out.println(bd6);
    }
}
