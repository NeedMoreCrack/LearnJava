package reflection.reflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> persionClass = Class.forName("reflection.reflection1.Student");
        //getConstructors只能獲取public的構造方法
        /*Constructor[] cons = persionClass.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }*/

        //getDeclaredConstructors可以獲取到全部的構造方法(包含private protected)
        /*Constructor<?>[] dcons = persionClass.getDeclaredConstructors();
        for (Constructor<?> con : dcons) {
            System.out.println(con);
        }*/

        //getConstructor只能獲取public構造方法
        /*Constructor<?> cons = persionClass.getConstructor(String.class);
        System.out.println(cons);*/

        //getDeclaredConstructor可以獲取到全部的構造方法(包含private protected)
        Constructor<?> dcons = persionClass.getDeclaredConstructor(String.class,int.class);
        System.out.println(dcons);

        //newInstance() 填入的參數必須跟當前構造參數一致 用object接收
        //如果修飾符是private 必須加上setAccessible(true)才能獲取
        dcons.setAccessible(true);
        Student andy = (Student) dcons.newInstance("Andy", 18);
        System.out.println(andy);
    }
}
