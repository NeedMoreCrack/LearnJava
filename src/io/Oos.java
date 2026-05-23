package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Oos {
    public static void main(String[] args) throws IOException{
        ObjStudent student = new ObjStudent("Alex",20);
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("src/io/oos.txt")
        );
        oos.writeObject(student);
        oos.close();
    }
}
