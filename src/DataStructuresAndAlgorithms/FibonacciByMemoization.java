package DataStructuresAndAlgorithms;

import java.util.Arrays;

public class FibonacciByMemoization {
    /*
    流程圖
    f(5)
    ├─ f(4)
    │  ├─ f(3)
    │  │  ├─ f(2)
    │  │  │  ├─ f(1)  -> 直接取 cache[1] = 1
    │  │  │  └─ f(0)  -> 直接取 cache[0] = 0
    │  │  │
    │  │  │  => f(2) = 1 + 0 = 1，存入 cache[2]
    │  │  │
    │  │  └─ f(1)     -> 直接取 cache[1] = 1
    │  │
    │  │  => f(3) = 1 + 1 = 2，存入 cache[3]
    │  │
    │  └─ f(2)        -> 直接取 cache[2] = 1
    │
    │  => f(4) = 2 + 1 = 3，存入 cache[4]
    │
    └─ f(3)           -> 直接取 cache[3] = 2

    => f(5) = 3 + 2 = 5，存入 cache[5]

    */
    public static void main(String[] args) {
        System.out.println("最終答案: " + fibonacci(5));
    }

    public static int fibonacci(int n){
        // cache[i] 用來記住 fibonacci(i) 的結果
        int[] cache = new int[n + 1];

        // 先全部設成 -1，代表「還沒算過」
        Arrays.fill(cache, -1);

        // base case 先放進去
        cache[0] = 0;
        cache[1] = 1;

        System.out.println("初始 cache: " + Arrays.toString(cache));
        return f(n, cache);
    }

    public static int f(int n, int[] cache){
        // 如果 cache[n] 不是 -1
        // 代表 fibonacci(n) 以前已經算過，直接拿來用
        if(cache[n] != -1){
            System.out.println("f(" + n + ") 已經算過，直接取 cache[" + n + "] = " + cache[n]);
            return cache[n];
        }

        // 如果 cache[n] 是 -1
        // 代表 fibonacci(n) 還沒算過
        // 所以依照公式去算：
        // fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
        System.out.println("f(" + n + ") 還沒算過，開始算 f(" + (n - 1) + ") + f(" + (n - 2) + ")");

        cache[n] = f(n - 1, cache) + f(n - 2, cache);

        // 算完之後把結果存進 cache[n]
        // 下次如果又要用到 fibonacci(n)，就不用再重算
        System.out.println("f(" + n + ") 算完，結果 = " + cache[n]);
        System.out.println("目前 cache: " + Arrays.toString(cache));
        System.out.println("====================");

        return cache[n];
    }
}