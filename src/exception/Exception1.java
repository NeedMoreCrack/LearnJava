package exception;

public class Exception1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        try{
            System.out.println(arr[10]);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
