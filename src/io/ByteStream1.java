package io;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/io/input.txt");
        byte[] buffer = new byte[8192];
        int len;
        String str = "";
        while ((len = fis.read(buffer)) != -1) {
           str += new String(buffer, 0, len);
        }
        System.out.println(str);
        fis.close();
    }
}
