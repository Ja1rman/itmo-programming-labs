import java.util.ArrayList;
import java.util.Objects;

public class structModel {
    public static void main(String[] args) {
        Vorchun vorch = new Vorchun("Ворчун", "Больной-Беглец");
        Pululka pulul = new Pululka("Пилюлька", "Больной-Беглец");
        Pulka pul = new Pulka("Пулька", "Больной");

        Hospital h = new Hospital();
        h.addPerson(vorch);
        h.addPerson(pulul);
        h.addPerson(pul);
        h.start();
    }
}

enum Wishes {
    SOUP ("Требую на обед варили суп из конфет и кашу из мармелада"),
    CAULDRON ("Заказываю котлеты из земляники с грибным соусом"),
    PUREE ("Приказываю принести яблочное пюре");

    private String title;

    Wishes(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Wishes{" +
                "title='" + title + '\'' +
                '}';
    }
}

interface Action{
    public void action(String prevAct);
}

abstract class Person implements Action{
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

class Pulka extends Person{
    public Pulka(String name, String status) {
        super(name, status);
    }

    @Override
    public void action(String prevAct){

        if(prevAct.equals("Приказываю принести яблочное пюре")){
            System.out.println(name + ": Я просил грушевого квасу");
            HospitalSlave.action("Я просил грушевого квасу", this);
        }
        else if(prevAct.equals("Я просил грушевого квасу")){
            System.out.println(name + ": Квас воняет луком");
            HospitalSlave.action("Квас воняет луком", this);
        }
        else{
            String[] actions = {Wishes.SOUP.getTitle(), Wishes.CAULDRON.getTitle(), Wishes.PUREE.getTitle()};
            String action = actions[(int) (Math.random() * 3)];
            System.out.println(action);
            HospitalSlave.action(action, this);
        }
    }
}

class Vorchun extends Person{
    public Vorchun(String name, String status) {
        super(name, status);
    }
    @Override
    public void action(String prevAct){
        System.out.println("Убежал из больницы");
        HospitalSlave.action("Убежал из больницы", this);
    }
}

class Pululka extends Person{
    public Pululka(String name, String status) {
        super(name, status);
    }
    @Override
    public void action(String prevAct){
        System.out.println("Убежал из больницы");
        HospitalSlave.action("Убежал из больницы", this);
    }
}

interface HospitalAction{
    public static void action(String action, Person pers){}
}
class HospitalSlave implements HospitalAction{
    public static void action(String action, Person pers){
        if(action.equals("Убежал из больницы")){
            System.out.println("Обслуживающий персонал больницы больше не занимается " + pers.name);
        }
        else if(action.equals("Приказываю принести яблочное пюре")){
            System.out.println("Обслуживающий персонал больницы принёс яблочкное пюре для " + pers.name);
            pers.action("Приказываю принести яблочное пюре");
        }
        else if(action.equals("Я просил грушевого квасу")){
            System.out.println("Обслуживающий персонал больницы принёс грушевый квас для " + pers.name);
            pers.action("Я просил грушевого квасу");
        }
        else if(action.equals("Квас воняет луком")){
            System.out.println("Обслуживающий персонал больницы в тильте и хейтит позера " + pers.name);
        }
        else if(action.equals("Заказываю котлеты из земляники с грибным соусом")){
            System.out.println("Обслуживающий персонал больницы считает, что таких котлет не бывает");
        }
        else{
            System.out.println("Обслуживающий персонал больницы принёс заказ для " + pers.name);
        }
    }
}

class Hospital{
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
}
