package io;

import java.io.Serializable;

public class ObjStudent implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public ObjStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ObjStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
