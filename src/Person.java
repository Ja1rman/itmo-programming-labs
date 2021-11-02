import java.util.Objects;

public abstract class Person implements Action{
    String name, status;
    public Person(String name, String status) {
        this.name = name;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && Objects.equals(status, person.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status);
    }

    public void action(String prevAct){}
}