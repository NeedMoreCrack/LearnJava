package Algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arrays = {1,3,5,7,9,11,13,15};
        int i = binarySearch(arrays, 15);
        System.out.println("index: "+i);
    }

    public static int binarySearch(int[] arrays,int target) {
        int low = 0;
        int high = arrays.length-1;
        int mid;
        while(low <= high){
            mid = (low+high) / 2;
            if(target == arrays[mid]){
                return mid;
            } else if (target > arrays[mid]) {
                low = mid+1;
            } else if (target < arrays[mid]) {
                high = mid-1;
            }
        }
        return -1;
    }
}