package DataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1000,1234};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 1000));
    }

    public static List<Integer> binarySearch(int[] arr,int left,int right,int findVal){
        if(left > right){
            return null;
        }
        int mid = (right+left) / 2;
        if(findVal < arr[mid]){
            return binarySearch(arr,left,mid-1,findVal);
        } else if (findVal > arr[mid]) {
            return binarySearch(arr,mid+1,right,findVal);
        }else{
            List<Integer> list = new ArrayList<>();
            int temp = mid-1;
            while(true){
                if(temp < 0 || arr[temp] != findVal){
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            list.add(mid);
            temp = mid+1;
            while(true){
                if(temp > arr.length-1 || arr[temp] != findVal){
                    break;
                }
                list.add(temp);
                temp += 1;
            }

            return list;
        }
    }
}
