public class Vorchun extends Person{
    public Vorchun(String name, String status) {
        super(name, status);
    }
    @Override
    public void action(String prevAct){
        System.out.println("Убежал из больницы");
        HospitalSlave.action("Убежал из больницы", this);
    }
}