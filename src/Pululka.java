public class Pululka extends Person{
    public Pululka(String name, String status) {
        super(name, status);
    }
    @Override
    public void action(String prevAct){
        System.out.println("Убежал из больницы");
        HospitalSlave.action("Убежал из больницы", this);
    }
}