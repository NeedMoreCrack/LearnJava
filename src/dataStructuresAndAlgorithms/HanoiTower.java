package dataStructuresAndAlgorithms;

import java.util.LinkedList;

public class HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();
    static int count = 0;

    static void init(int n){
        for (int i = n; i > 0; i--) {
            a.addLast(i);
        }
    }

    /**
     *
     * @param n 個數
     * @param a 來源
     * @param b 借助移動
     * @param c 目地
     */
    static void move(
            int n,
            LinkedList<Integer> a,
            LinkedList<Integer> b,
            LinkedList<Integer> c ){
        if(n == 0)
            return;
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        print();
        count++;
        System.out.println("移動次數: "+count);
        move(n-1,b,a,c);
    }

    static void print(){
        System.out.println("====================");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void main(String[] args) {
        init(3);
        print();
        move(3,a,b,c);
    }
}