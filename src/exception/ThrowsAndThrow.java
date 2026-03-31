package exception;

public class ThrowsAndThrow {
    public static void main(String[] args) {
        int[] arr = {};
        try{
            System.out.println(getMax(arr));
        }catch (NullPointerException e){
            System.out.println("帶入值為Null");
        }catch (IndexOutOfBoundsException e){
            System.out.println("超出索引");
        }
    }
    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i : arr) {
            if(max < i){
                max = i;
            }
        }
        return max;
    }
}
