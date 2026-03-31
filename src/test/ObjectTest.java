package test;

import java.util.Objects;

public class ObjectTest {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "321";
        int hashStr1 = Objects.hashCode(str1);
        int hashStr2 = Objects.hashCode(str2);
        System.out.println(hashStr1);
        System.out.println(hashStr2);
    }
}
