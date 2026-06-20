package arrayListTest;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Phone> list = new ArrayList<>();
        Phone p1 = new Phone("小米",1000);
        Phone p2 = new Phone("蘋果",800);
        Phone p3 = new Phone("華碩",2999);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        getPhoneInfo(list);
    }
    public static void getPhoneInfo(ArrayList<Phone> list){
        for (Phone p : list) {
            int price = p.getPrice();
            if (price < 1000) {
                System.out.println(p.getName() + "," + p.getPrice());
            }
        }
    }
}
