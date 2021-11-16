fun main() {
    val vorch = Vorchun("Ворчун", "Больной-Беглец")
    val pulul = Pululka("Пилюлька", "Больной-Беглец")
    val pul = Pulka("Пулька", "Больной")
    val h = Hospital()
    h.addPerson(vorch)
    h.addPerson(pulul)
    h.addPerson(pul)
    h.start()
}
