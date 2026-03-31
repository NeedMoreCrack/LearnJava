package collection;

import java.util.ArrayList;
import java.util.Collections;

public class AutoCallTheRoll3 {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        int count = 0;
        while(true){
            if(!l.isEmpty()){
                if(count == 2){
                    return;
                } else {
                    while(!l.isEmpty()){
                        System.out.print("點名："+l.getFirst());
                        System.out.print(", 移除:"+l.removeFirst());
                        System.out.println();
                    }
                    count++;
                    System.out.println("第"+count+"次點完名");
                }
            }else {
                Collections.addAll(l,"Andy","Simon","Kelly","Alex","Jeff");
                Collections.shuffle(l);
                System.out.println("=============================");
            }
        }
    }
}
