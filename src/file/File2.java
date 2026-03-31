package file;

import java.io.File;
import java.util.Arrays;

public class File2 {
    public static void main(String[] args) {
        File f1 = new File("src/file");
        String[] files = f1.list((dir,name)->true);
        System.out.println(Arrays.toString(files));
    }
}
