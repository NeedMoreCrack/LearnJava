package file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileT4 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        File f1 = new File("src/file/src/abc");
        showSearch(f1,map);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String name = entry.getKey();
            int value = entry.getValue();
            System.out.println(name+"="+value);
        }
    }
    public static void showSearch(File files,Map<String, Integer> map){
        File[] getFiles = files.listFiles();
        if(getFiles != null){
            for (File f : getFiles) {
                if(f.isFile()){
                    String name = f.getName().split("\\.")[1];
                    map.put(name,map.getOrDefault(name,0)+1);
                }else{
                    showSearch(f,map);
                }
            }
        }
    }
}
