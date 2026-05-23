package io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/io/output.txt");
        String str = "Hello";
        byte[] bytes = str.getBytes();
        fos.write(bytes);
    }
}
