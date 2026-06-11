package DataStructuresAndAlgorithms;

public class DoublyLinkedListSentinelTest {
    // 測試addFirst
    public void test1(){
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addFirst(1);
        doublyLinkedListSentinel.addFirst(2);
        doublyLinkedListSentinel.addFirst(3);

        for (Integer i : doublyLinkedListSentinel) {
            System.out.println(i);
        }
    }

    // 測試addLast
    public void test2(){
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);

        for (Integer i : doublyLinkedListSentinel) {
            System.out.println(i);
        }
    }

    // 測試removeFirst
    public void test3(){
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);

        doublyLinkedListSentinel.removeFirst();

        for (Integer i : doublyLinkedListSentinel) {
            System.out.println(i);
        }
    }

    // 測試removeLast
    public void test4(){
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);

        doublyLinkedListSentinel.removeLast();

        for (Integer i : doublyLinkedListSentinel) {
            System.out.println(i);
        }
    }

    // 測試removeByValue
    public void test5(){
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);

        doublyLinkedListSentinel.removeByValue(2);

        for (Integer i : doublyLinkedListSentinel) {
            System.out.println(i);
        }
    }
}
