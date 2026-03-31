package test;

public class test {
    public static void main(String[] args) {
        int a = 0;
        int b = ++a + a++ + ++a + a++ + a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
