package io.register;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterHasLock {
    public static void main(String[] args) throws IOException {
        String path = "src/io/register/userinfo.txt";
        Map<String,String> usersInfo = new HashMap<>(getInfo(path));
        Scanner sc = new Scanner(System.in);
        System.out.println("==========Login==========");
        System.out.println("Please enter username :");
        String userName = sc.next();
        System.out.println("Please enter userPassword :");
        String password = sc.next();
        int userErrorCount = getUserErrorCount(userName, path);
        if(userErrorCount >= 3){
            System.out.println("user "+userName+" is locked");
        }else{
            boolean loginStatus = checkInfo(usersInfo, userName, password, path);
            String loginInfo = loginStatus ? "Login success" : "Login failed";
            System.out.println(loginInfo);
        }
        sc.close();
/*      user data
        username=andy&password=123
        username=kelly&password=321
*/
    }

    //get users info list
    public static Map<String,String> getInfo(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        Map<String,String> users = new HashMap<>();
        String len;
        while((len=br.readLine()) != null){
            String[] map = len.split("&");
            String key = map[0].split("=")[1];
            String value = map[1].split("=")[1];
            users.put(key,value);
        }
        br.close();
        return users;
    }

    //user error count +1
    public static void addErrorCount(String name,String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> list = new ArrayList<>();
        String line;
        while((line= br.readLine()) != null){
            list.add(line);
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (String s : list) {
            if(s.contains(name)){
                Pattern p = Pattern.compile("(.*=)(\\d)$");
                Matcher m = p.matcher(s);
                if(m.find()){
                    int errorCountNum = Integer.parseInt(m.group(2));
                    errorCountNum++;
                    bw.write(m.group(1)+errorCountNum);
                    bw.newLine();
                }
            }else{
                bw.write(s);
                bw.newLine();
            }
        }
        bw.close();
    }

    //get user error count
    public static int getUserErrorCount(String name, String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        int getErrorCount = 0;
        String line;
        while((line= br.readLine()) != null){
            if(line.contains(name)){
                Pattern p = Pattern.compile("(.*=)(\\d)$");
                Matcher m = p.matcher(line);
                if(m.find()){
                    getErrorCount = Integer.parseInt(m.group(2));
                }
            }
        }
        br.close();
        return getErrorCount;
    }

    //reset user error count to 0
    public static void resetErrorCount(String name, String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> list = new ArrayList<>();
        String line;
        while((line= br.readLine()) != null){
            list.add(line);
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (String s : list) {
            if(s.contains(name)){
                Pattern p = Pattern.compile("(.*=)(\\d)$");
                Matcher m = p.matcher(s);
                if(m.find()){
                    int errorCountNum = 0;
                    bw.write(m.group(1)+errorCountNum);
                    bw.newLine();
                }
            }else{
                bw.write(s);
                bw.newLine();
            }
        }
        bw.close();
    }

    //check login
    public static boolean checkInfo(Map<String,String> map,String username,String password,String path) throws IOException {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.equals(username) && value.equals(password)){
                resetErrorCount(username,path);
                return true;
            }else if(key.equals(username)){
                if(getUserErrorCount(username,path) <= 3){
                    addErrorCount(key,path);
                }
            }
        }
        return false;
    }
}
