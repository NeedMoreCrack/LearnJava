package thread.homework2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Gifts implements Runnable{
    static int gifts = 100;
    final Lock lock = new ReentrantLock();

    @Override
    public void run(){
        while (true) {
            try{
                lock.lock();
                if(gifts < 10){
                    break;
                }
                gifts--;
                System.out.println(Thread.currentThread().getName()+" 禮物剩餘 "+gifts+" 份");
            }finally {
                lock.unlock();
            }
        }
    }
}
