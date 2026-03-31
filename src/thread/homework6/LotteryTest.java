package thread.homework6;

public class LotteryTest {
    public static void main(String[] args) throws InterruptedException {
        /*
            承上題延伸
            每次抽的過程中不印出來，抽完時一次印出
            印出範例如下：
            抽獎箱1總共產生了6種獎項5,100,500,800,300,700最高獎項為 800 元,總計為2405元
            抽獎箱2總共產生了6種獎項10,20,50,200,2,80最高獎項為200,總計為362元
         */
        Lottery l = new Lottery();
        Thread t1 = new Thread(l);
        Thread t2 = new Thread(l);
        t1.setName("抽獎箱1：");
        t2.setName("抽獎箱2：");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Lottery.showInfo();
    }
}
