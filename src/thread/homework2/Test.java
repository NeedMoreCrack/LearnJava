package thread.homework2;

public class Test {
    public static void main(String[] args) {
        /*
           有一百份禮品，兩個同時發送，當禮品小於十份就不再送出
           利用多線程模擬，並將線程名字及剩餘禮品數量印出來
        */
        Gifts g1 = new Gifts();
        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g1);
        t1.setName("A:");
        t2.setName("B:");
        t1.start();
        t2.start();
    }
}
