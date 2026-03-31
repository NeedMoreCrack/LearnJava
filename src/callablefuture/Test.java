package callablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest ct = new CallableTest();
        //FutureTask manage Callable
        FutureTask<Integer> ft = new FutureTask<>(ct);
        Thread t1 = new Thread(ft);
        t1.start();

        Integer result = ft.get();
        System.out.println(result);
    }
}
