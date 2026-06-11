package DataStructuresAndAlgorithms;

public class SinglyLinkedListTest {

    // 測試addFirst
    public void test1() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.loop2(System.out::println);
    }

    public void test2(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);

        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }

    // 測試addLast
    public void test3(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
        System.out.println("====================");
        System.out.println(singlyLinkedList.get(3));
    }

    // 測試insert
    public void test4(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);

        singlyLinkedList.insert(1,99);
        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }

    // 測試removeFirst
    public void test5(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);

        singlyLinkedList.removeFirst();
        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }

    // 測試remove
    public void test6(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);

        singlyLinkedList.remove(0);
        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }
}
