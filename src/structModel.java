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