package file;

import java.io.File;
import java.util.Arrays;

public class File3 {
    public static void main(String[] args) {
        File f1 = new File("src/file");
        File[] files = f1.listFiles();
        for (File file : files) {
            if(file.isFile() && file.getName().endsWith(".txt")){
                System.out.println(file);
            }
        }
    }
}
