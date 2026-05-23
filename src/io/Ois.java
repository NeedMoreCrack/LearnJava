package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ois {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("src/io/oos.txt")
        );
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();
    }
}
