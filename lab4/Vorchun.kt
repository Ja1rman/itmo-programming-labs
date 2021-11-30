class Vorchun(name: String, status: String) : Person(name, status) {
    override fun action() {
        println("$name: Убежал из больницы")
        HospitalSlave.action("Убежал из больницы", this)
    }
}