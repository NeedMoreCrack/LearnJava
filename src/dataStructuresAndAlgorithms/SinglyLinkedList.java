package DataStructuresAndAlgorithms;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {
    private Node head = null;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

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

    private Node findLast(){
        if(head == null){
            return null;
        }
        Node p;
        for(p = head;p.next != null;p = p.next){

        }
        return p;
    }

    public void addLast(int value){
        Node last = findLast();
        if(last == null){
            addFirst(value);
            return;
        }
        last.next = new Node(value,null);
    }

    private Node findNode(int index){
        int i = 0;
        for(Node p = head;p != null;p = p.next){
            if(i == index){
                return p;
            }
            i++;
        }
        return null;
    }

    public int get(int index){
        Node node = findNode(index);
        if(node == null){
            throw new IllegalArgumentException(String.format("無效的值: ",index));
        }
        return node.value;
    }

    public void insert(int index, int value){
        if(index == 0){
            addFirst(value);
            return;
        }
        Node prev = findNode(index-1);
        if(prev == null){
            throw new IllegalArgumentException(String.format("無效的值: ",index));
        }
        prev.next = new Node(value,prev.next);
    }

    public void removeFirst(){
        if(head == null){
            throw new IllegalArgumentException(String.format("無效的值: ",0));
        }
        head = head.next;
    }

    public void remove(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        Node prev = findNode(index-1);
        if(prev == null){
            throw new IllegalArgumentException(String.format("無效的值: ",index));
        }
        Node remove = prev.next;
        prev.next = remove.next;
    }

    public void loop1(Consumer<Integer> consumer){
        Node p = head;
        while (p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer){
        for(Node p = head; p != null;p = p.next){
            System.out.println(p.value);
        }
    }
}
