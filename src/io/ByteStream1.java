package io;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/io/a.txt");
        int a;
        while((a = fis.read()) != -1){
            System.out.println((char)a);
        }
        fis.close();
    }
}
