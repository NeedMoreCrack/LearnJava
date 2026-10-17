package com.java.learn.io.files;

import java.io.File;
import java.util.Arrays;

public class File4 {
    public static void main(String[] args) {
        File f1 = new File("resources/io/files");
        System.out.println(Arrays.toString(f1.listFiles((path, name) -> name.endsWith(".txt"))));
    }
}
