package file;

import java.io.File;

public class File1 {
    public static void main(String[] args) {
        File f1 = new File("src/file/a.txt");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f1.exists());
        System.out.println(f1.lastModified());
    }
}
