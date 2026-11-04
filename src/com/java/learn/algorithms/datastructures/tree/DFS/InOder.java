package com.java.learn.algorithms.datastructures.tree.DFS;

import java.util.Stack;

public class InOder {
    public static void main(String[] args) {
        Node root = new Node(1,new Node(2,new Node(4,null,null),null),new Node(3,new Node(5,null,null),new Node(6,null,null)));
//        inOrderRecursion(root);
        inOrderWhile(root);
    }

    public static void inOrderRecursion(Node root) {
        if (root == null) {
            return;
        }
        inOrderRecursion(root.left);
        System.out.println(root.value);
        inOrderRecursion(root.right);
    }

    public static void inOrderWhile(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if(root == null){
                Node pop = stack.pop();
                root = pop.right;
                System.out.println(pop.value);
            }else {
                stack.push(root);
                root = root.left;
            }
        }
    }
}