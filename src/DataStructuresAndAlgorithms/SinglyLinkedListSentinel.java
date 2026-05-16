package DataStructuresAndAlgorithms;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedListSentinel implements Iterable<Integer> {
    private Node head = new Node(1,null);

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
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
        insert(0,value);
    }

    private Node findLast(){
        Node p;
        for(p = head;p.next != null;p = p.next){

        }
        return p;
    }

    public void addLast(int value){
        Node last = findLast();
        last.next = new Node(value,null);
    }

    private Node findNode(int index){
        int i = -1;
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
        Node prev = findNode(index-1);
        if(prev == null){
            throw new IllegalArgumentException(String.format("無效的值: ",index));
        }
        prev.next = new Node(value,prev.next);
    }

    public void removeFirst(){
        remove(0);
    }

    public void remove(int index){
        Node prev = findNode(index-1);
        if(prev == null){
            throw new IllegalArgumentException(String.format("無效的值: ",index));
        }
        Node remove = prev.next;
        prev.next = remove.next;
    }

    public void loop1(Consumer<Integer> consumer){
        Node p = head.next;
        while (p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer){
        for(Node p = head.next; p != null;p = p.next){
            System.out.println(p.value);
        }
    }
}
