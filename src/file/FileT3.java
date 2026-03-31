package file;

import java.io.File;
import java.util.Arrays;

public class FileT3 {
    public static void main(String[] args) {
        File f1 = new File("src/file/");
        System.out.println(hasAvi(f1));
    }
    public static boolean hasAvi(File filePath){
        File[] files = filePath.listFiles((path, name) -> true);
        if(files != null) {
            for (File file : files) {
                if(file.isDirectory()){
                    File[] files1 = file.listFiles();
                    if(files1 != null){
                        for (File file1 : files1) {
                            if (file1.getName().endsWith(".avi")) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
