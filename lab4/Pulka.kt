class Pulka(name: String, status: String) : Person(name, status) {
    private var prevAct: String? = null
    override fun action() {
        when (prevAct) {
            "Приказываю принести яблочное пюре" -> {
                println("$name: Я просил грушевого квасу")
                prevAct = "Я просил грушевого квасу"
                HospitalSlave.action("Я просил грушевого квасу", this)
            }
            "Я просил грушевого квасу" -> {
                println("$name: Квас воняет луком")
                prevAct = "Квас воняет луком"
                HospitalSlave.action("Квас воняет луком", this)
            }
            else -> {
                val actions = arrayOf(Wishes.SOUP.title, Wishes.CAULDRON.title, Wishes.PUREE.title)
                val action = actions[(0..2).random()]
                println("$name: $action")
                prevAct = action
                HospitalSlave.action(action, this)
            }
        }
        val h = HospitalSlave.Hyan(name)
        h.rave()
        println("$name: Посылает одну из нянечек искать по городу свою собаку Бульку.")
        h.mindGames()
    }
}