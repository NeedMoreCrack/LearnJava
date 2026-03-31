package clone;

import java.util.Arrays;
import java.util.StringJoiner;

public class Student implements Cloneable{
    private int id;
    private String username;
    private String password;
    private String path;
    private int[] data;

    public Student (){}

    public Student(int id, String username, String password, String path, int[] data) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.path = path;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public String toString(){
        return "角色編號："+id+", 用戶名："+username+", 密碼："+password+", 路徑："+path+", 進度"+ Arrays.toString(data);
    }

    public String arrToString(){
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int datum : data) {
            sj.add(datum + "");
        }
        return sj.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
