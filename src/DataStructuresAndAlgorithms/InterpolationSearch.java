package DataStructuresAndAlgorithms;

public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(interpolationSearch(arr, 0, arr.length - 1, 1));
    }

    public static int interpolationSearch(int[] arr,int left,int right,int findVal){
        if(left > right || findVal < arr[left] || findVal > arr[right]){
            return -1;
        }
        int  mid = left + (right-left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if(findVal > arr[mid]){
            return interpolationSearch(arr,mid+1,right,findVal);
        } else if (findVal < arr[mid]) {
            return interpolationSearch(arr,left,mid-1,findVal);
        } else {
            return mid;
        }
    }
}
