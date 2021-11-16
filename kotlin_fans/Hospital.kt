import java.util.*

class Hospital {
    private val persons = mutableListOf<Action>()
    fun addPerson(a: Action) {
        persons.add(a)
    }

    fun start() {
        for (pers in persons) {
            pers.action()
        }
    }

    override fun toString(): String {
        return "Hospital{" +
                "persons=" + persons +
                '}'
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val hospital = o as Hospital
        return persons == hospital.persons
    }

    override fun hashCode(): Int {
        return Objects.hash(persons)
    }
}