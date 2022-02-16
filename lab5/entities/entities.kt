package entities

import java.util.*

data class LabWork(var id: Long = -1,
                   val name: String,
                   val coordinates: Coordinates,
                   val minimalPoint: Long? = null,
                   val difficulty: Difficulty? = null,
                   val creationDate: Date = Date(),
                   val discipline: Discipline) : Comparable<LabWork> {

    override fun compareTo(other: LabWork) = ((this.minimalPoint ?: 0) - (other.minimalPoint ?: 0)).toInt()
}

class Coordinates(
    _x: Long,
    val y: Long) {
    val x = if (_x > -515) _x else throw Exception("Parameter 'x' can not be less than -515")

    override fun toString(): String {
        return "coordinates(x=${x}, y=${y})"
    }
}

data class Discipline(val name: String,
                      val selfStudyHours: Int)

enum class Difficulty(val index: Int) {
    VERY_EASY(0), NORMAL(1), HARD(2), VERY_HARD(3), TERRIBLE(4)
}