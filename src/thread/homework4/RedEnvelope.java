package thread.homework4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RedEnvelope implements Runnable{
    static List<Integer> list = new ArrayList<>();
    final Lock lock = new ReentrantLock();
    static {
        int money = 100;//總金額
        double l1 = Math.random();//獲取隨機機率
        double l2 = Math.random();//獲取隨機機率
        double min = Math.min(l1,l2);//取小
        double max = Math.max(l1,l2);//取大

        double probabilityA = min;
        double probabilityB = max-min;

        Integer getMoneyA = (int) Math.round(probabilityA * money);
        Integer getMoneyB = (int) Math.round(probabilityB * money);
        Integer getMoneyC = (int) (money - getMoneyB - getMoneyA);//用總金額減去前兩名的金額  防止出現101或99

        Collections.addAll(list,getMoneyA,getMoneyB,getMoneyC);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.lock();
        try {
            if (list.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " 沒搶到");
            } else {
                int index = new Random().nextInt(list.size());
                int getMoney = list.remove(index);
                System.out.println(Thread.currentThread().getName() + " 搶到了 " + getMoney + " 元");
            }
        } finally {
            lock.unlock();
        }
    }
}
