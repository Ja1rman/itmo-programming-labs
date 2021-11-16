import java.util.*

abstract class Person(var name: String, var status: String) : Action {
    override fun toString(): String {
        return "Person{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}'
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val person = o as Person
        return name == person.name && status == person.status
    }

    override fun hashCode(): Int {
        return Objects.hash(name, status)
    }
}