package lambda;

import java.util.Arrays;

public class LambdaT2 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
        Arrays.sort(arr,(a,b) -> b - a);
        System.out.println(Arrays.toString(arr));
    }
}
