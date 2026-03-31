package thread.homework5;

public class LotteryTest {
    public static void main(String[] args) {
        /*
            創建兩個線程，名稱為抽獎箱1，抽獎箱2
            從獎池中獲取獎項並打印
         */
        Lottery l = new Lottery();
        Thread t1 = new Thread(l);
        Thread t2 = new Thread(l);
        t1.setName("抽獎箱1：");
        t2.setName("抽獎箱2：");
        t1.start();
        t2.start();
    }
}
