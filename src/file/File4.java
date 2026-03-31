package file;

import java.io.File;
import java.util.Arrays;

public class File4 {
    public static void main(String[] args) {
        File f1 = new File("src/file");
        System.out.println(Arrays.toString(f1.listFiles((path, name) -> name.endsWith(".txt"))));
    }
}
