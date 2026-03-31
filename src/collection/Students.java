package collection;

import java.util.Objects;

public class Students implements Comparable<Students> {
    private String name;
    private int age;
    private int chScore;
    private int mathScore;
    private int engScore;

    public Students(String name, int age, int chScore, int mathScore, int engScore) {
        this.name = name;
        this.age = age;
        this.chScore = chScore;
        this.mathScore = mathScore;
        this.engScore = engScore;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getChScore() {
        return chScore;
    }

    public void setChScore(int chScore) {
        this.chScore = chScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return age == students.age && chScore == students.chScore && mathScore == students.mathScore && engScore == students.engScore && Objects.equals(name, students.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, chScore, mathScore, engScore);
    }

    @Override
    public String toString(){
        int total = this.getEngScore()+this.getMathScore()+this.getChScore();
        return "Students{name = "+name+", chScore = "+chScore+", mathScore = "+mathScore+", engScore = "+engScore+", Total = "+total+"}";
    }

    @Override
    public int compareTo(Students o) {
        int thisTotal = this.getChScore()+this.getEngScore()+this.getMathScore();
        int oTotal = o.getChScore()+o.getMathScore()+o.getEngScore();
        if (thisTotal != oTotal) {
            return oTotal - thisTotal;
        }

        // 2. 比中文成績（大到小）
        if (this.getChScore() != o.getChScore()) {
            return o.getChScore() - this.getChScore();
        }

        // 3. 比數學成績（大到小）
        if (this.getMathScore() != o.getMathScore()) {
            return o.getMathScore() - this.getMathScore();
        }

        // 4. 比英文成績（大到小）
        if (this.getEngScore() != o.getEngScore()) {
            return o.getEngScore() - this.getEngScore();
        }

        // 5. 比年齡（小的排前面）
        if (this.getAge() != o.getAge()) {
            return this.getAge() - o.getAge();
        }

        // 6. 比名字（字母順序）
        return this.getName().compareTo(o.getName());
    }
}
