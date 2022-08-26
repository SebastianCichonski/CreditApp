package pl.javaskils.creditapp.core.model;

import java.util.Objects;

public class Guarantor implements  Comparable<Guarantor>{
    private String pesel;
    private int age;

    public Guarantor(String pesel, int age) {
        this.pesel = pesel;
        this.age = age;
    }

    public String getPesel() {
        return pesel;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Guarantor o) {
        if(this.pesel.compareTo(o.pesel) == 0){
            return this.pesel.compareTo(o.pesel);
        }
        else  return this.age - o.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guarantor guarantor = (Guarantor) o;
        return pesel.equals(guarantor.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }
}
