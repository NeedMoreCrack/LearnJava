package runnable;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable1 r1 = new Runnable1();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.setName("t1 : ");
        t2.setName("t2 : ");
        t1.start();
        t2.start();
    }
}
