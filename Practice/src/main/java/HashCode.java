import java.util.HashSet;

public class HashCode {
    public static void main(String[] args) {
        HashSet<Person> people = new HashSet<Person>();
        Person aditi = new Person("Aditi", 100);
        people.add(aditi);
        Person aditi1 = new Person("Aditi", 200);
        people.add(aditi1);
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println(aditi.hashCode());
        System.out.println(aditi1.hashCode());
    }

}
