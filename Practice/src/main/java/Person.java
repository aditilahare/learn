import java.util.Objects;

public class Person {

    private final String name;
    private final int aadhar;

    protected Person(String name, int aadhar) {
        this.name = name;
        this.aadhar = aadhar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return aadhar == person.aadhar &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", aadhar=" + aadhar +
                '}';
    }
}
