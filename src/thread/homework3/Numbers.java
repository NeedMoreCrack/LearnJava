package thread.homework3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Numbers implements Runnable{
    static int num = 1;
    final Lock lock = new ReentrantLock();

    @Override
    public void run(){
        while (true) {
            try {
                num++;
                if (num % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + num);
                }
                lock.lock();
                if (num == 100) {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
