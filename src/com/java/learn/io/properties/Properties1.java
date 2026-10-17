package com.java.learn.io.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Properties1 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.put("1","a");
        prop.put("2","b");
        prop.put("3","c");
        prop.put("4","d");
        FileOutputStream fos = new FileOutputStream("resources/io/properties/a.properties");
        prop.store(fos,"Test");
        fos.close();
    }
}
