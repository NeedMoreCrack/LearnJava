package test;

import java.io.File;

public class test {
    public static void main(String[] args) {
        File file = new File("D:"+File.separator+"Company");
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".zip")) {
                System.out.println(f.getName());
            }
        }
    }
}
