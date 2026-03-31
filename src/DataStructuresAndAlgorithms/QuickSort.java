package DataStructuresAndAlgorithms;


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("排序時間: "+ time);
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left < right){
            int pivot = arr[right];
            int i = left - 1;

            for(int j=left;j<right;j++){
                if(arr[j] <= pivot){
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[right];
            arr[right] = temp;
            int pivotIndex = i + 1;
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }
}
