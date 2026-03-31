package collection;

public class SumAdd {
    public static void main(String[] args) {
//        System.out.println(sum(1, 2, 3, 4, 5));
    }
    public static int sum(int...n){
        int total = 0;
        for (int i : n) {
            total += i;
        }
        return total;
    }
}
