package dataStructuresAndAlgorithms;

public class SinglyLinkedListSentinelTest {

    // 測試addFirst
    public void test1() {
        SinglyLinkedListSentinel singlyLinkedListSentinel = new SinglyLinkedListSentinel();
        singlyLinkedListSentinel.addFirst(1);
        singlyLinkedListSentinel.addFirst(2);
        singlyLinkedListSentinel.addFirst(3);
        singlyLinkedListSentinel.loop2(System.out::println);
    }

    public void test2(){
        SinglyLinkedListSentinel singlyLinkedListSentinel = new SinglyLinkedListSentinel();
        singlyLinkedListSentinel.addFirst(1);
        singlyLinkedListSentinel.addFirst(2);
        singlyLinkedListSentinel.addFirst(3);

        for (Integer i : singlyLinkedListSentinel) {
            System.out.println(i);
        }
    }

    // 測試addLast
    public void test3(){
        SinglyLinkedListSentinel singlyLinkedListSentinel = new SinglyLinkedListSentinel();
        singlyLinkedListSentinel.addLast(1);
        singlyLinkedListSentinel.addLast(2);
        singlyLinkedListSentinel.addLast(3);
        singlyLinkedListSentinel.addLast(4);

        for (Integer i : singlyLinkedListSentinel) {
            System.out.println(i);
        }
        System.out.println("====================");
        System.out.println(singlyLinkedListSentinel.get(3));
    }

    // 測試insert
    public void test4(){
        SinglyLinkedListSentinel singlyLinkedListSentinel = new SinglyLinkedListSentinel();
        singlyLinkedListSentinel.addLast(1);
        singlyLinkedListSentinel.addLast(2);
        singlyLinkedListSentinel.addLast(3);

        singlyLinkedListSentinel.insert(1,99);
        for (Integer i : singlyLinkedListSentinel) {
            System.out.println(i);
        }
    }

    // 測試removeFirst
    public void test5(){
        SinglyLinkedListSentinel singlyLinkedListSentinel = new SinglyLinkedListSentinel();
        singlyLinkedListSentinel.addLast(1);
        singlyLinkedListSentinel.addLast(2);
        singlyLinkedListSentinel.addLast(3);

        singlyLinkedListSentinel.removeFirst();
        for (Integer i : singlyLinkedListSentinel) {
            System.out.println(i);
        }
    }

    // 測試remove
    public void test6(){
        SinglyLinkedListSentinel singlyLinkedListSentinel = new SinglyLinkedListSentinel();
        singlyLinkedListSentinel.addLast(1);
        singlyLinkedListSentinel.addLast(2);
        singlyLinkedListSentinel.addLast(3);

        singlyLinkedListSentinel.remove(1);
        for (Integer i : singlyLinkedListSentinel) {
            System.out.println(i);
        }
    }
}
