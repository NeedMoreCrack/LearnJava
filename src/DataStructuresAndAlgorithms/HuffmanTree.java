package DataStructuresAndAlgorithms;

import java.awt.*;
import java.util.*;

public class HuffmanTree {
    public static void main(String[] args) {
        String word = "ABAC";
        huffmanTree(word);
    }

    public static void huffmanTree(String word){
        Map<String,Integer> map = new HashMap<>();
        char[] c = word.toCharArray();
        for (int i = 0; i < c.length; i++) {
            map.put(String.valueOf(c[i]),map.getOrDefault(String.valueOf(c[i]),0)+1);
            System.out.println(Integer.toBinaryString(c[i]));
        }
//        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toUnmodifiableList());
    }

}

class huffmanNode implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;
    public huffmanNode(Byte data,int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}