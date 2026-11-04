package com.java.learn.algorithms.datastructures.tree.DFS;

import java.util.Stack;

public class PreOder {
    public static void main(String[] args) {
        Node root = new Node(1,new Node(2,new Node(4,null,null),null),new Node(3,new Node(5,null,null),new Node(6,null,null)));
//        preOrderRecursion(root);
        preOrderWhile(root);
    }

    public static void preOrderRecursion(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    public static void preOrderWhile(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if(root == null){
                Node pop = stack.pop();
                root = pop.right;
            }else {
                System.out.println(root.value);
                stack.push(root);
                root = root.left;
            }
        }
    }
}