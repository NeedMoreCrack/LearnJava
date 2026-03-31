package thread.homework7;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lottery implements Runnable{
    static Integer[] money = {10,5,20,50,100,200,500,800,2,80,300,700};
    final Lock lock = new ReentrantLock();
    static int i = -1;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

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
                    if(Thread.currentThread().getName().equals("抽獎箱1：")){
                        list1.add(getMoney);
                    } else if (Thread.currentThread().getName().equals("抽獎箱2：")) {
                        list2.add(getMoney);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
    public static void showInfo(){
        getInfo(list1,list2);
    }
    public static void getInfo(List<Integer> list1,List<Integer> list2){
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb1 = new StringBuilder();
        int list1Sum=0;
        int getList1Max = 0;
        for (Integer i : list1) {
            list1Sum+=i;
            getList1Max = Math.max(getList1Max,i);
            if(i.equals(list1.getLast())){
                sb1.append(i);
            }else{
                sb1.append(i).append(",");
            }
        }
        System.out.println("抽獎箱1總共產生了"+list1.size()+"種獎項"+sb1+"最高獎項為"+getList1Max+"元,總計為"+list1Sum+"元");
        map.put("抽獎箱1",getList1Max);

        StringBuilder sb2 = new StringBuilder();
        int listSum2=0;
        int getList2Max = 0;
        for (Integer i : list2) {
            listSum2+=i;
            getList2Max = Math.max(getList2Max,i);
            if(i.equals(list2.getLast())){
                sb2.append(i);
            }else{
                sb2.append(i).append(",");
            }
        }
        System.out.println("抽獎箱2總共產生了"+list2.size()+"種獎項"+sb2+"最高獎項為"+getList2Max+",總計為"+listSum2+"元");
        map.put("抽獎箱2",getList2Max);

        String boxName="";
        int num=0;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if(num < entry.getValue()){
                boxName = entry.getKey();
                num=entry.getValue();
            }
        }
        System.out.println("此抽獎過程中,"+boxName+"產生最大獎項,金額為："+num+"元");
    }
}
