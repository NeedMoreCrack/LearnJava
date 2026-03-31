package DataStructuresAndAlgorithms;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,20,-5};
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("排序時間: "+totalTime);
    }

    public static int[] selectSort(int[] arr){
        int count = 0;
        System.out.println("陣列原始值: "+Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1+i; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    System.out.println("第"+(++count)+"次變更的值: "+Arrays.toString(arr));
                }
            }
        }
        return arr;
    }
}
