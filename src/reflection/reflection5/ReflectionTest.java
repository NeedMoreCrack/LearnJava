package reflection.reflection5;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/reflection/reflection5/prop.properties");
        prop.load(fis);
        fis.close();
        System.out.println(prop);
        String className = (String) prop.get("className");
        String methodName = (String) prop.get("method");
        System.out.println(className);
        System.out.println(methodName);
        Class<?> clazz = Class.forName(className);
        Constructor<?> con = clazz.getDeclaredConstructor();
        Object o = con.newInstance();
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(o);
    }
}
