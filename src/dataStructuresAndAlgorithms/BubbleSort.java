package DataStructuresAndAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,20,-5};
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(bubbleSort(arr)));
        long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("總共花費時間: "+totalTime);
    }

    public static int[] bubbleSort(int[] arr){
        for (int i = 0;i < arr.length-1;i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"次排序過程: "+Arrays.toString(arr));
        }
        return arr;
    }
}
