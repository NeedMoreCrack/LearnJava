package thread.homework4;

public class GetRedEnvelope {
    public static void main(String[] args) {
        /*
            有一百塊分成三個紅包，五個人去搶
            五個人五個線程
            輸出結果如下：
            XXX搶到XXX元
            XXX搶到XXX元
            XXX搶到XXX元
            XXX沒搶到
            XXX沒搶到
        */
        RedEnvelope re = new RedEnvelope();
        Thread t1 = new Thread(re);
        Thread t2 = new Thread(re);
        Thread t3 = new Thread(re);
        Thread t4 = new Thread(re);
        Thread t5 = new Thread(re);
        t1.setName("A: ");
        t2.setName("B: ");
        t3.setName("C: ");
        t4.setName("D: ");
        t5.setName("E: ");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
