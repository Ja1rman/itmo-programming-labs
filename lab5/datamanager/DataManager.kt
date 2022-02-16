package datamanager

import entities.Difficulty
import entities.LabWork

object DataManager {
    private var idSetter: Long = 1

    private val data = mutableListOf<LabWork>()

    fun add(new: LabWork) = if (new.id > 0 && data.find { it.id == new.id } != null) data.add(new)
                            else data.add(new.copy(id=idSetter++))

    fun getItemsNumber() = data.size

    fun getAllItems() = data

    fun updateById(id: Long, element: LabWork) {
        data[data.indexOfFirst { it.id == id }] = element.copy(id = id)
    }

    fun removeById(id: Long) = data.removeIf { it.id == id }

    fun clearData() = data.clear()

    fun removeLast() = data.removeLast()

    fun addIfMax(element: LabWork): Boolean {
        val max = data.maxOrNull()
        if (max == null || element > max) {
            add(element)
            return true
        }
        return false
    }

    fun removeLower(element: LabWork) = data.removeIf { it < element }

    fun removeByMP(minimalPoint: Long) = data.removeIf { it.minimalPoint == minimalPoint }

    fun sumMP() = data.sumOf { it.minimalPoint ?: 0 }

    fun countLessDifficulty(difficulty: Difficulty) = data.filter{ (it.difficulty?.index ?: 0) < difficulty.index }.size
}