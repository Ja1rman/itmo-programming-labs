public class HospitalSlave implements HospitalAction{
    public static void action(String action, Person pers){
        switch (action) {
            case "Убежал из больницы":
                System.out.println("Обслуживающий персонал больницы больше не занимается " + pers.name);
                break;
            case "Приказываю принести яблочное пюре":
                System.out.println("Обслуживающий персонал больницы принёс яблочкное пюре для " + pers.name);
                pers.action("Приказываю принести яблочное пюре");
                break;
            case "Я просил грушевого квасу":
                System.out.println("Обслуживающий персонал больницы принёс грушевый квас для " + pers.name);
                pers.action("Я просил грушевого квасу");
                break;
            case "Квас воняет луком":
                System.out.println("Обслуживающий персонал больницы в тильте и хейтит позера " + pers.name);
                break;
            case "Заказываю котлеты из земляники с грибным соусом":
                System.out.println("Обслуживающий персонал больницы считает, что таких котлет не бывает");
                break;
            default:
                System.out.println("Обслуживающий персонал больницы принёс заказ для " + pers.name);
                break;
        }
    }
}
