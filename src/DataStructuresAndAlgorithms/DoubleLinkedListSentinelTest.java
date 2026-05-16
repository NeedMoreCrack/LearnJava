package DataStructuresAndAlgorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListSentinelTest {
    @Test
    @DisplayName("測試addFirst")
    public void test1() {
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addFirst(1);
        doubleLinkedListSentinel.addFirst(2);
        doubleLinkedListSentinel.addFirst(3);
        for (Integer i : doubleLinkedListSentinel) {
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addFirst(1);
        doubleLinkedListSentinel.addFirst(2);
        doubleLinkedListSentinel.addFirst(3);

        for (Integer i : doubleLinkedListSentinel) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("測試addLast")
    public void test3(){
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addLast(1);
        doubleLinkedListSentinel.addLast(2);
        doubleLinkedListSentinel.addLast(3);
        doubleLinkedListSentinel.addLast(4);

        for (Integer i : doubleLinkedListSentinel) {
            System.out.println(i);
        }
//        System.out.println(doubleLinkedListSentinel.get(3));
    }

    @Test
    @DisplayName("測試insert")
    public void test4(){
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addLast(1);
        doubleLinkedListSentinel.addLast(2);
        doubleLinkedListSentinel.addLast(3);

        doubleLinkedListSentinel.insert(1,99);
        for (Integer i : doubleLinkedListSentinel) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("測試removeFirst")
    public void test5(){
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addLast(1);
        doubleLinkedListSentinel.addLast(2);
        doubleLinkedListSentinel.addLast(3);

        doubleLinkedListSentinel.removeFirst();
        for (Integer i : doubleLinkedListSentinel) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("測試remove")
    public void test6(){
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addLast(1);
        doubleLinkedListSentinel.addLast(2);
        doubleLinkedListSentinel.addLast(3);

        doubleLinkedListSentinel.remove(2);
        for (Integer i : doubleLinkedListSentinel) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("測試removeLast")
    public void test7(){
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addLast(1);
        doubleLinkedListSentinel.addLast(2);
        doubleLinkedListSentinel.addLast(3);

        doubleLinkedListSentinel.removeLast();
        for (Integer i : doubleLinkedListSentinel) {
            System.out.println(i);
        }
    }
}