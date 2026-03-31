package thread.homework1;

public class Test {
    public static void main(String[] args) {
        /*
            有一百張電影票，在兩個窗口販售 每次販售時間是3秒
            用多線程模擬售票過程，並印出剩餘的電影票數量
        */
        Windows w1 = new Windows();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t1.start();
        t2.start();
    }
}
