package DataStructuresAndAlgorithms;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        int[] temp = new int[arr.length];
        long start = System.currentTimeMillis();
        mergeSort(arr,temp,0,arr.length-1);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("排序時間: "+ time);
    }

    public static void mergeSort(int[] arr,int[] temp,int left,int right){
        if(left < right){
            int pivot = (left+right) / 2;
            mergeSort(arr,temp,left,pivot);
            mergeSort(arr,temp,pivot+1,right);
            merge(arr,temp,left,pivot,right);
        }
    }

    public static void merge(int[] arr,int[] temp,int left,int pivot,int right){
        int l  = left;
        int r = pivot+1;
        int t = 0;
        while(l <= pivot && r <= right){
            if(arr[l] <= arr[r]){
                temp[t++] = arr[l++];
            }else{
                temp[t++] = arr[r++];
            }
        }

        while(l <= pivot){
            temp[t++] = arr[l++];
        }

        while(r <= right){
            temp[t++] = arr[r++];
        }

        t = 0;
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
