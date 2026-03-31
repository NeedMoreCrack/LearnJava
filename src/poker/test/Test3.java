package poker.test;

import java.io.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        addNewUser("alex","654");
    }
    public static void addNewUser(String name,String passWord) throws IOException {
        String path = "src/poker/userinfo.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
        String userFormat = "username="+name+"&password="+passWord+"&errorCount=0";
        bw.newLine();
        bw.write(userFormat);
        bw.close();
    }
}
