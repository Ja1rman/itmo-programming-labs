
abstract class Run : Start{
    protected val persons = mutableListOf<Action>()
    fun addPerson(a: Action) {
        persons.add(a)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Run

        if (persons != other.persons) return false

        return true
    }

    override fun hashCode(): Int {
        return persons.hashCode()
    }

    override fun toString(): String {
        return "Run(persons=$persons)"
    }
}