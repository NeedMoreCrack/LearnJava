package Algorithm;

public class BinarySearchEx {
    public static void main(String[] args) {
        int[] arrays = {1,3,5,7,9,11,13,15};
        int i = binarySearchEx(arrays, 15);
        System.out.println("index: "+i);
    }

    public static int binarySearchEx(int[] arrays, int target) {
        int low = 0;
        int high = arrays.length;
        int mid;
        while(low < high){
            mid = (low+high) >>> 1;
            if(target < arrays[mid]){
                high = mid;
            } else if (target > arrays[mid]) {
                low = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}