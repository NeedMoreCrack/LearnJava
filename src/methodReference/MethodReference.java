package methodReference;

import java.util.Arrays;

public class MethodReference {
    public static void main(String[] args) {
        Integer[] arr = {3,5,4,1,6,2};
//        Arrays.sort(arr,(a,b)->b-a);
//        System.out.println(Arrays.toString(arr));
//        System.out.println("==================");
        Arrays.sort(arr,MethodReference::sort);
        System.out.println(Arrays.toString(arr));
    }
    public static int sort(int a,int b){
        return b-a;
    }
}
