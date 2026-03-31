package reflection.reflection3;

public class Student {
    private String name;
    private int age;

    public Student(){}

    public Student(String name, int age) {
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

    public void sleep(){
        System.out.println("睡覺");
    }

    private void eat(String something){
        System.out.println("在吃"+something);
    }

    private void eat(String something,int a){
        System.out.println("在吃"+something);
    }

    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
