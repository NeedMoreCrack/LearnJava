package clone;

public class Clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] data = {1,2,3,4,5};
        Student s1 = new Student(1,"Andy","1234","./user",data);
        Object s2 = s1.clone();
        System.out.println(s1);
        System.out.println(s2);
    }
}
