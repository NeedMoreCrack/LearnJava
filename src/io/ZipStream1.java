package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipStream1 {
    public static void main(String[] args) throws IOException {
        ZipInputStream zip = new ZipInputStream(new FileInputStream("src/io/src.zip"));
        while(zip.getNextEntry() != null){
            System.out.println(zip.getNextEntry());
        }
    }
}
