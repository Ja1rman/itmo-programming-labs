import datamanager.DataManager
import entities.Coordinates
import entities.Difficulty
import entities.Discipline
import entities.LabWork
import io.JsonConvertor
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

var scan = BufferedReader(InputStreamReader(System.`in`))

fun main(args: Array<String>) {
    while (true) {
        print(">>> ")
        var commands = scan.readLine() ?: "-1a"
        if (commands == "-1a") {
            scan = BufferedReader(InputStreamReader(System.`in`))
            commands = scan.readLine()
        }
        val command = commands.split(" ")

        when (command[0]) {
            "exit" -> break
            "add" -> {
                try {
                    DataManager.add(
                        enterVals()
                    )
                    println("Added")
                } catch(e: Exception){
                    println("Can not add element")
                    println("Error: ${e.message}")
                }
            }
            "show" -> {
                try {
                    for (lab in DataManager.getAllItems()) {
                        println(lab)
                    }
                } catch(e: Exception){
                    println("Can not show elements")
                    println("Error: ${e.message}")
                }
            }
            "remove_last" -> {
                try {
                    val response = DataManager.removeLast()
                    println("Removed element: $response")
                } catch(e: Exception){
                    println("Can not remove element")
                    println("Error: ${e.message}")
                }
            }
            "info" -> {
                try {
                    val response = DataManager.getItemsNumber()
                    println("Number of elements: $response")
                } catch(e: Exception){
                    println("Can not get number of elements")
                    println("Error: ${e.message}")
                }
            }
            "clear" -> {
                try {
                    DataManager.clearData()
                    println("OK")
                } catch(e: Exception) {
                    println("Can not clear elements")
                    println("Error: ${e.message}")
                }
            }
            "remove_by_id" -> {
                try {
                    val response = DataManager.removeById(command[1].toLong())
                    println(if(response) "OK" else "Failed")
                } catch(e: Exception) {
                    println("Can not remove element")
                    println("Error: ${e.message}")
                }
            }
            "update" -> {
                try {
                    DataManager.updateById(id = command[1].toLong(),
                        enterVals()
                    )
                    println("Updated")
                } catch(e: Exception){
                    println("Can not update element")
                    println("Error: ${e.message}")
                }
            }
            "add_if_max" -> {
                try {
                    val response = DataManager.addIfMax(
                        enterVals()
                    )
                    println(if(response) "Added" else "Not Added")
                } catch(e: Exception){
                    println("Can not add element")
                    println("Error: ${e.message}")
                }
            }
            "remove_lower" -> {
                try {
                    val response = DataManager.removeLower(
                        enterVals()
                    )
                    println(if(response) "OK" else "Failed")
                } catch(e: Exception){
                    println("Can not clear elements")
                    println("Error: ${e.message}")
                }
            }
            "remove_all_by_minimal_point" -> {
                try {
                    val response = DataManager.removeByMP(command[1].toLong())
                    println(if(response) "OK" else "Failed")
                } catch(e: Exception) {
                    println("Can not remove elements")
                    println("Error: ${e.message}")
                }
            }
            "sum_of_minimal_point" -> {
                try {
                    val response = DataManager.sumMP()
                    println("Result: $response")
                } catch(e: Exception) {
                    println("Can not find sum of elements")
                    println("Error: ${e.message}")
                }
            }
            "count_less_than_difficulty" -> {
                try {
                    val response = DataManager.countLessDifficulty(Difficulty.valueOf(command[1]))
                    println("Result: $response")
                } catch(e: Exception) {
                    println("Can not count elements")
                    println("Error: ${e.message}")
                }
            }
            "help" -> {
                println("help : вывести справку по доступным командам\n" +
                        "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                        "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "add {element} : добавить новый элемент в коллекцию\n" +
                        "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "remove_by_id id : удалить элемент из коллекции по его id\n" +
                        "clear : очистить коллекцию\n" +
                        "save : сохранить коллекцию в файл\n" +
                        "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                        "exit : завершить программу (без сохранения в файл)\n" +
                        "remove_last : удалить последний элемент из коллекции\n" +
                        "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                        "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                        "remove_all_by_minimal_point minimalPoint : удалить из коллекции все элементы, значение поля minimalPoint которого эквивалентно заданному\n" +
                        "sum_of_minimal_point : вывести сумму значений поля minimalPoint для всех элементов коллекции\n" +
                        "count_less_than_difficulty difficulty : вывести количество элементов, значение поля difficulty которых меньше заданного")
            }
            "save" -> {
                try {
                    JsonConvertor.save()
                    println("OK")
                } catch(e: Exception){
                    println("Can not save to json")
                    println("Error: ${e.message}")
                }
            }
            "execute_script" -> {
                scan = BufferedReader(InputStreamReader(FileInputStream(command[1])))
            }
            else -> {
                println("Вы ввели говно.")
            }
        }
    }
}

fun enterVals(): LabWork {
    var name: String
    while (true) {
        print("Enter name: ")
        try {
            name = scan.readLine()
            if (name == "" || name == "null") println("Name can not be empty")
            else break
        } catch (e: Exception) {
            println("Error ")
        }
    }
    var entries: List<String>
    var coordinates: Coordinates
    while (true) {
        print("Enter coordinates: ")
        entries = scan.readLine().split(" ")
        try {
            coordinates = Coordinates(entries[0].toLong(), entries[1].toLong())
            break
        } catch (e: Exception) {
            println("Error ")
        }
    }
    var minimalPoint: Long
    while (true) {
        print("Enter minimalPoint: ")
        try {
            minimalPoint = scan.readLine().toLong()
            if (minimalPoint < 0) println("minimalPoint can not less than 0")
            else break
        } catch (e: Exception) {
            println("Error ")
        }
    }
    var difficulty: Difficulty
    while (true) {
        print("Enter difficulty (VERY_EASY, NORMAL, HARD, VERY_HARD, TERRIBLE): ")
        try {
            difficulty = Difficulty.valueOf(scan.readLine())
            break
        } catch (e: Exception) {
            println("Error ")
        }
    }
    var discipline: Discipline
    while (true) {
        print("Enter discipline: ")
        entries = scan.readLine().split(" ")
        try {
            discipline = Discipline(if (entries[0] == "null") " " else entries[0], entries[1].toInt())
            break
        } catch (e: Exception) {
            println("Error ")
        }
    }
    return LabWork(
        name = name,
        coordinates = coordinates,
        minimalPoint = minimalPoint,
        difficulty = difficulty,
        discipline = discipline
    )
}
