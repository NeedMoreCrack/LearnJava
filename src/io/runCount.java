package io;

import java.io.*;

public class runCount {
    public static void main(String[] args) throws IOException {
        String path = "./io/count.txt";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        int len;
        while((len=bis.read()) != -1){
            System.out.println((char)len);
            System.out.println(len);
            if(len == '3'){
                System.out.println("count = "+(char)len);
            }else {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
                bos.write(String.valueOf(((char)(len+1))).getBytes());
                bos.flush();
            }
        }
        bis.close();
    }
}
