package io.register;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Register {
    public static void main(String[] args) throws IOException {
        Map<String,String> usersInfo = new HashMap<>(getInfo());
        Scanner sc = new Scanner(System.in);
        System.out.println("==========Login==========");
        System.out.println("Please enter username :");
        String userName = sc.next();
        System.out.println("Please enter userPassword :");
        String password = sc.next();
        boolean loginStatus = checkInfo(usersInfo, userName, password);
        String loginInfo = loginStatus ? "Login success" : "Login failed";
        System.out.println(loginInfo);
    }
    public static Map<String,String> getInfo() throws IOException {
        String path = "src/io/register/userinfo.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        Map<String,String> users = new HashMap<>();
        String len;
        while((len=br.readLine()) != null){
            String[] map = len.split("&");
            String key = map[0].split("=")[1];
            String value = map[1].split("=")[1];
            users.put(key,value);
        }
        return users;
    }
    public static boolean checkInfo(Map<String,String> map,String username,String password){
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.equals(username) && value.equals(password)){
                return true;
            }
        }
        return false;
    }
}
