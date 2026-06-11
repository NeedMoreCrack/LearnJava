package DataStructuresAndAlgorithms;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
        radixSort(arr);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("排序時間: "+ time);
    }

    public static void radixSort(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for(int i = 0 , n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                int digitOfElement = value / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            for(int k = 0; k < bucketElementCounts.length; k++) {
                if(bucketElementCounts[k] != 0) {
                    for(int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }
}
