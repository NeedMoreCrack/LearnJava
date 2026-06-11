package DataStructuresAndAlgorithms;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4,1,2,3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        int temp = 0;
        int step = arr.length / 2;
        int j;
        while(step >= 1){
            for (int i = step; i < arr.length; i++) {
                j = i;
                temp = arr[j];
                if(arr[j] < arr[j-step]){
                    arr[j] = arr[j-step];
                    j -= step;
                }
                arr[j] = temp;
            }
            step /= 2;
        }
    }
}
