package com.java.learn.algorithms.datastructures.tree.DFS;

import java.util.Stack;

public class PostOder {
    public static void main(String[] args) {
        Node root = new Node(1,new Node(2,new Node(4,null,null),new Node(7,null,null)),new Node(3,new Node(5,null,null),new Node(6,null,null)));
//        postOrderRecursion(root);
        postOrderWhile(root);
    }

    public static void postOrderRecursion(Node root) {
        if (root == null) {
            return;
        }
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.println(root.value);
    }

    public static void postOrderWhile(Node root) {
        Stack<Node> stack = new Stack<>();
        Node pop = null;
        while (root != null || !stack.isEmpty()) {
            if(root != null){
                stack.push(root);
                root = root.left;
            }else {
                if(stack.peek().right == null || stack.peek().right == pop){
                    pop = stack.pop();
                    System.out.println(pop.value);
                }else{
                    root = stack.peek().right;
                }
            }
        }
    }
}