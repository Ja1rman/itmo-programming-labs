public class Pulka extends Person{
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