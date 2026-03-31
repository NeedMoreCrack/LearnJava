package thread.homework1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Windows implements Runnable{
    static int ticketCount = 0;
    static int totalTicket = 100;
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticketCount >= 100) {
                    break;
                }
                ticketCount++;
                totalTicket--;
                System.out.println(Thread.currentThread().getName() + "正在賣第 " + ticketCount + " 張票,剩餘 :"+totalTicket);
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
