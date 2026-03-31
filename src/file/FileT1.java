package file;

import java.io.File;
import java.util.Arrays;

public class FileT1 {
    public static void main(String[] args) {
        File f1 = new File("./aaa/a.txt");
        System.out.println(f1.mkdirs());
    }
}
