package reflection.reflection4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class ReflectionTest {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Student s = new Student("Alex",25,"male",170,"swim");
        Teacher t = new Teacher("Anna",50000);
        saveObject(s);
        saveObject(t);
    }

    public static void saveObject(Object obj) throws IOException, IllegalAccessException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/reflection/reflection4/saveData.txt",true));
        Class<?> sClass = obj.getClass();
        Field[] fields = sClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(obj);
            System.out.println(field.getName()+"="+value);
            bw.write(name+"="+value);
            bw.newLine();
        }
        bw.close();
    }
}
