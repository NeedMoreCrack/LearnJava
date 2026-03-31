package methodreference;

public class Students {
    private String name;
    private int age;

    public Students (String str){
        this.name = str.split("-")[0];
        this.age = Integer.parseInt(str.split("-")[1]);
    }

    public Students(String name, int age) {
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
        return "Students{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
