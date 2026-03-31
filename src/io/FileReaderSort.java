package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.StringJoiner;

public class FileReaderSort {
    public static void main(String[] args) throws Exception {
        String path = "src/io/num.txt";
        FileReader fr = new FileReader(path);
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner("-");
        String[] str;
        int word;
        while((word = fr.read()) != -1){
            sb.append((char) word);
        }
        System.out.println(sb);
        str = sb.toString().split("-");
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        for (String s : str) {
            sj.add(s);
        }
        System.out.println(sj);
        FileWriter fw = new FileWriter(path);
        fw.write(sj.toString());
        fw.close();
        fr.close();
    }
}
