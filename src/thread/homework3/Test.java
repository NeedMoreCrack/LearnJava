package thread.homework3;

public class Test {
    public static void main(String[] args) {
        /*
            同時開啟兩個線程，共同獲取1～100之間的數字
            將所有奇數輸出
         */
        Numbers n1 = new Numbers();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);
        t1.setName("線程1: ");
        t2.setName("線程2: ");
        t1.start();
        t2.start();
    }
}
