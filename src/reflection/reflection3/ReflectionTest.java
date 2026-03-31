package reflection.reflection3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> persionClass = Class.forName("reflection.reflection3.Student");

        //getMethods() 獲取所有的public方法(包含父類中所有的public方法)
        /*Method[] methods = persionClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/

        //getDeclaredMethods() 獲取所有的方法(不能獲取父類,但可以獲取私有方法)
        /*Method[] declaredMethods = persionClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }*/

        //getMethod() 獲取指定public方法
        /*Method eat = persionClass.getMethod("eat", String.class);
        System.out.println(eat);*/

        //getDeclaredMethod() 獲取指定方法(包含private)
        /*Method eat = persionClass.getDeclaredMethod("eat", String.class, int.class);
        System.out.println(eat);*/

        //參數一 s:方法的調用者
        //參數二 "Steak":調用方法時傳遞的實際參數
        Method eat = persionClass.getDeclaredMethod("eat", String.class);
        Student s = new Student();
        eat.setAccessible(true);//方法是private 加上這行才能獲取
        eat.invoke(s,"Steak");
    }
}
