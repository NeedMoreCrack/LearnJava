package io;

import java.io.PrintStream;

public class PrintStream1 {
    public static void main(String[] args) {
        PrintStream ps = System.out;
        ps.println("Test");
        ps.close();

        System.out.println("Test2");
    }
}
