package reflection.reflection2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> persionClass = Class.forName("reflection.reflection2.Student");

        //獲取成員變數 getFields() 只能獲取public
        /*Field[] fields = persionClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }*/

        //獲取成員變數 getDeclaredFields() 獲取所有成員變數
        /*Field[] fields2 = persionClass.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }*/

        //getField("要獲取的成員變數") 只能獲取public
        /*Field gender = persionClass.getField("gender");
        System.out.println(gender);*/

        //getDeclaredField("要獲取的成員變數") 可以獲取private
        Field name = persionClass.getDeclaredField("name");
        System.out.println(name);
    }
}
