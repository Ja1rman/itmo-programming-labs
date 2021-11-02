import java.util.ArrayList;
import java.util.Objects;

public class Hospital{
    ArrayList<Person> persons = new ArrayList<Person>();
    public void addPerson(Person a){
        persons.add(a);
    }
    public void start(){
        for(Person pers : persons){
            System.out.print(pers.name + ": ");
            pers.action("None");
        }
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "persons=" + persons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(persons, hospital.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons);
    }
}