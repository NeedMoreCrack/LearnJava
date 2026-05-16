package DataStructuresAndAlgorithms;

import java.util.Iterator;

public class DoubleLinkedListSentinel implements Iterable<Integer> {
    static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public DoubleLinkedListSentinel(){
        head = new Node(null,000,null);
        tail = new Node(null,000,null);
        head.next = tail;
        tail.prev = head;
    }

    public Node findNode(int index){
        int i = -1;
        for(Node p = head;p != tail;p = p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null;
    }

    public void addFirst(int value){
        insert(0,value);
    }

    public void removeFirst(){
        remove(0);
    }

    public void addLast(int value){
        Node prev = tail.prev;
        Node newNode = new Node(prev, value, tail);
        prev.next = newNode;
        tail.prev = newNode;
    }

    public void removeLast(){
        Node removed = tail.prev;
        if(removed == head){
            illegalArgumentException(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    public void insert(int index, int value){
        Node prev = findNode(index-1);
        if(prev == null){
            illegalArgumentException(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void remove(int index){
        Node prev = findNode(index-1);
        if(prev == null){
            illegalArgumentException(index);
        }
        Node removed = prev.next;
        if(removed == tail){
            illegalArgumentException(index);
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;
    }

    private IllegalArgumentException illegalArgumentException(int index){
        throw new IllegalArgumentException(String.format("錯誤參數: ",index));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}