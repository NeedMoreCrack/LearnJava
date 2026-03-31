package test;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[] numArr = {10,99,25,50,1};
        int[] newNumArrNum = numArrSortDesc(numArr);
        System.out.println(Arrays.toString(newNumArrNum));
    }
    public static int[] numArrSortDesc(int[] numArr){
        for (int i = 0; i < numArr.length; i++) {
            for (int j = 0; j < numArr.length-i-1; j++) {
                if(numArr[j] < numArr[j+1]){
                    int temp = numArr[j+1];
                    numArr[j+1] = numArr[j];
                    numArr[j] = temp;
                }
            }
        }
        return numArr;
    }
}
