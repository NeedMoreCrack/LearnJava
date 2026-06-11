package DataStructuresAndAlgorithms;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer> {
    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null,-1,null);

    public DoublyLinkedListSentinel(){
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(int value){
        Node first = sentinel.next;
        Node add = new Node(sentinel,value,sentinel.next);
        first.prev = add;
        sentinel.next = add;
    }

    public void addLast(int value){
        Node prev = sentinel.prev;
        Node add = new Node(prev,value,sentinel);
        sentinel.prev = add;
        prev.next = add;
    }

    public void removeFirst(){
        Node removed = sentinel.next;
        if(removed == sentinel){
            throw illegalArgumentException();
        }
        sentinel.next = removed.next;
        removed.next.prev = sentinel;
    }

    public void removeLast(){
        Node removed = sentinel.prev;
        if(removed == sentinel){
            return;
        }
        Node prev = removed.prev;
        prev.next = sentinel;
        sentinel.prev = prev;
    }

    public void removeByValue(int value){
        Node removed = findByValue(value);
        if(removed == null){
            throw illegalArgumentException();
        }
        Node prev = removed.prev;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    private Node findByValue(int value){
        Node p = sentinel.next;
        while (p != sentinel){
            if(p.value == value){
                return p;
            }
            p = p.next;
        }
        return null;
    }

    private IllegalArgumentException illegalArgumentException(){
        return new IllegalArgumentException("錯誤");
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
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
