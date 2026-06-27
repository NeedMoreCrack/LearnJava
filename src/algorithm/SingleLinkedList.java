package algorithm;

public class SingleLinkedList {
    private Node head = null;

    private static class Node {
        int value;
        Node next;

        private Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        head = new Node(value,head);
    }
}
