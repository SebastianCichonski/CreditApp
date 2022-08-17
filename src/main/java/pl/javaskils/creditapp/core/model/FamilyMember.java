package pl.javaskils.creditapp.core.model;

public class FamilyMember implements Comparable<FamilyMember>{
    private String name;
    private Integer age;

    public FamilyMember(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(FamilyMember o) {
        return o.age.compareTo(age);
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
