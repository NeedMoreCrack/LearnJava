package file;

import java.io.File;

public class FileT2 {
    public static void main(String[] args) {
        File f1 = new File("src/file/aaa");
        System.out.println(hasAvi(f1));
    }
    public static boolean hasAvi(File filePath){
        File[] files = filePath.listFiles((path, name) -> true);
        if(files != null) {
            for (File file : files) {
                System.out.println(file);
                if (file.getName().endsWith(".avi")) {
                    return true;
                }
            }
        }
        return false;
    }
}
