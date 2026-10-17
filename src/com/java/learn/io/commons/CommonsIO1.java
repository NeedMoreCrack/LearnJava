package com.java.learn.io.commons;

//import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIO1 {
    public static void main(String[] args) throws IOException {
        File source = new File("resources/io/commons/a.txt");
        File copyToPath = new File("resources/io/commons/a/aCopy.txt");
//        FileUtils.copyFile(source,copyToPath);
    }
}
