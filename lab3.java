import java.util.ArrayList;

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

interface Action{
    public void action(String prevAct);
}

abstract class Person implements Action{
    String name, status;
    public String getName() { return name; }
    public String getStatus() { return status; }
    public Person(String name, String status) {
        name = name;
        status = status;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Person guest = (Person) obj;
        return ((name == guest.name || (name != null && name.equals(guest.getName()))) && (status == guest.status || (status != null && status.equals(guest.getStatus()))));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }
    @Override
    public String toString(){
        return name + " " + status;
    }
    public void action(String prevAct){}
}

class Pulka extends Person{
    public Pulka(String name, String status) {
        super(name, status);
    }
    @Override
    public void action(String prevAct){
        String[] actions = {"Требую на обед варили суп из конфет и кашу из мармелада",
                            "Заказываю котлеты из земляники с грибным соусом",
                            "Приказываю принести яблочное пюре"};
        if(prevAct == "Приказываю принести яблочное пюре"){
            System.out.println(name + ": Я просил грушевого квасу");
            HospitalSlave.action("Я просил грушевого квасу", this);
        }
        else if(prevAct == "Я просил грушевого квасу"){
            System.out.println(name + ": Квас воняет луком");
            HospitalSlave.action("Квас воняет луком", this);
        }
        else{
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
        System.out.print("Убежал из больницы\n");
        HospitalSlave.action("Убежал из больницы", this);
    }
}

class Pululka extends Person{
    public Pululka(String name, String status) {
        super(name, status);
    }
    @Override
    public void action(String prevAct){
        System.out.print("Убежал из больницы\n");
        HospitalSlave.action("Убежал из больницы", this);
    }
}

class HospitalSlave{
    public HospitalSlave(){}

    public static void action(String action, Person pers){
        if(action == "Убежал из больницы"){
            System.out.println("Обслуживающий персонал больницы больше не занимается " + pers.name);
        }
        else if(action == "Приказываю принести яблочное пюре"){
            System.out.println("Обслуживающий персонал больницы принёс яблочкное пюре для " + pers.name);
            pers.action("Приказываю принести яблочное пюре");
        }
        else if(action == "Я просил грушевого квасу"){
            System.out.println("Обслуживающий персонал больницы принёс грушевый квас для " + pers.name);
            pers.action("Я просил грушевого квасу");
        }
        else if(action == "Квас воняет луком"){
            System.out.println("Обслуживающий персонал больницы в тильте и хейтит позера " + pers.name);
        }
        else if(action == "Заказываю котлеты из земляники с грибным соусом"){
            System.out.println("Обслуживающий персонал больницы считает, что таких котлет не бывает");
        }
        else{
            System.out.println("Обслуживающий персонал больницы принёс заказ для " + pers.name);
        }
    }
}

class Hospital{
    ArrayList<Person> persons = new ArrayList<Person>();
    public Hospital(){}
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
