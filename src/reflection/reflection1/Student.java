package reflection.reflection1;

public class Student {
    private String name;
    private int age;

    public Student(){}

    public Student(String name){
        this.name = name;
    }

    protected Student(int age){
        this.age = age;
    }

    private Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
