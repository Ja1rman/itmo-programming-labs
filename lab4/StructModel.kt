fun main() {
    println("История 1:")
    val avo = Avoska("Авоська", "Коротышка")
    val tub = Tubik("Тюбик", "Художник", avo)
    val s = StartPainters()
    s.addPerson(tub)
    s.addPerson(avo)
    s.start()
    println("История 2:")
    val vorch = Vorchun("Ворчун", "Больной-Беглец")
    val pulul = Pululka("Пилюлька", "Больной-Беглец")
    val pul = Pulka("Пулька", "Больной")
    val h = Hospital()
    h.addPerson(vorch)
    h.addPerson(pulul)
    h.addPerson(pul)
    h.start()


}
