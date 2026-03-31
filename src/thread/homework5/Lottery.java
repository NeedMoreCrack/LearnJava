package thread.homework5;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lottery implements Runnable{
    static Integer[] money = {10,5,20,50,100,200,500,800,2,80,300,700};
    final Lock lock = new ReentrantLock();
    static int i = -1;

    @Override
    public void run(){
        while(true) {
            try {
                Thread.sleep(new Random().nextInt(1000));
                lock.lock();
                i++;
                if (i >= money.length) {
                    break;
                }else{
                    int getMoney = money[i];
                    System.out.println(Thread.currentThread().getName() + " 產生了一個 " + getMoney + " 元獎項");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
