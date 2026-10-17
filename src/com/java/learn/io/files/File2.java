package com.java.learn.io.files;

import java.io.File;
import java.util.Arrays;

public class File2 {
    public static void main(String[] args) {
        File f1 = new File("resources/io/files");
        String[] files = f1.list((dir,name)->true);
        System.out.println(Arrays.toString(files));
    }
}
