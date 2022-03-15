import datamanager.DataManager
import entities.Coordinates
import entities.Difficulty
import entities.Discipline
import entities.LabWork
import io.JsonConvertor
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
//import org.apache.logging.log4j.kotlin.logger
import mu.KotlinLogging


var scan = BufferedReader(InputStreamReader(System.`in`))
//var logger = logger("Dumb")
var logger = KotlinLogging.logger {}
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
            "exit" -> {
                logger.warn("User: Stopping program")
                break
            }
            "add" -> {
                try {
                    DataManager.add(
                        enterVals()
                    )
                    println("Added")
                    logger.info("User: added new elem")
                } catch(e: Exception){
                    println("Can not add element")
                    println("Error: ${e.message}")
                    logger.error("Error added elem, ${e.message}")
                }
            }
            "show" -> {
                try {
                    for (lab in DataManager.getAllItems()) {
                        println(lab)
                    }
                    logger.info("User: elements showed")
                } catch(e: Exception){
                    println("Can not show elements")
                    println("Error: ${e.message}")
                    logger.error("Error show elem, ${e.message}")
                }
            }
            "remove_last" -> {
                try {
                    val response = DataManager.removeLast()
                    println("Removed element: $response")
                    logger.info("User: last element removed")
                } catch(e: Exception){
                    println("Can not remove element")
                    println("Error: ${e.message}")
                    logger.error("Error: remove last elem, ${e.message}")
                }
            }
            "info" -> {
                try {
                    val response = DataManager.getItemsNumber()
                    println("Number of elements: $response")
                    logger.info("User: info was given")
                } catch(e: Exception){
                    println("Can not get number of elements")
                    println("Error: ${e.message}")
                    logger.error("Error: cant give info, ${e.message}")
                }
            }
            "clear" -> {
                try {
                    DataManager.clearData()
                    println("OK")
                    logger.info("User: all info deleted")
                } catch(e: Exception) {
                    println("Can not clear elements")
                    println("Error: ${e.message}")
                    logger.error("Error: cant clear info, ${e.message}")
                }
            }
            "remove_by_id" -> {
                try {
                    val response = DataManager.removeById(command[1].toLong())
                    println(if(response) "OK" else "Failed")
                    logger.info("User: elem by id removed")
                } catch(e: Exception) {
                    println("Can not remove element")
                    println("Error: ${e.message}")
                    logger.error("Error: cant remove elem by id, ${e.message}")
                }
            }
            "update" -> {
                try {
                    DataManager.updateById(id = command[1].toLong(),
                        enterVals()
                    )
                    println("Updated")
                    logger.info("User: elem by id updatad")
                } catch(e: Exception){
                    println("Can not update element")
                    println("Error: ${e.message}")
                    logger.error("Error: cant update elem by id, ${e.message}")
                }
            }
            "add_if_max" -> {
                try {
                    val response = DataManager.addIfMax(
                        enterVals()
                    )
                    println(if(response) "Added" else "Not Added")
                    logger.info("User: elem add if max success")
                } catch(e: Exception){
                    println("Can not add element")
                    println("Error: ${e.message}")
                    logger.error("Error: cant add max elem, ${e.message}")
                }
            }
            "remove_lower" -> {
                try {
                    val response = DataManager.removeLower(
                        enterVals()
                    )
                    println(if(response) "OK" else "Failed")
                    logger.info("User: elem remove lower success")
                } catch(e: Exception){
                    println("Can not clear elements")
                    println("Error: ${e.message}")
                    logger.error("Error: cant remove lower elem, ${e.message}")
                }
            }
            "remove_all_by_minimal_point" -> {
                try {
                    val response = DataManager.removeByMP(command[1].toLong())
                    println(if(response) "OK" else "Failed")
                    logger.info("User: remove_all_by_minimal_point success")
                } catch(e: Exception) {
                    println("Can not remove elements")
                    println("Error: ${e.message}")
                    logger.error("Error: cant remove_all_by_minimal_point, ${e.message}")
                }
            }
            "sum_of_minimal_point" -> {
                try {
                    val response = DataManager.sumMP()
                    println("Result: $response")
                    logger.info("User: sum_of_minimal_point success")
                } catch(e: Exception) {
                    println("Can not find sum of elements")
                    println("Error: ${e.message}")
                    logger.error("Error: cant sum_of_minimal_point, ${e.message}")
                }
            }
            "count_less_than_difficulty" -> {
                try {
                    val response = DataManager.countLessDifficulty(Difficulty.valueOf(command[1]))
                    println("Result: $response")
                    logger.info("User: count_less_than_difficulty success")
                } catch(e: Exception) {
                    println("Can not count elements")
                    println("Error: ${e.message}")
                    logger.error("Error: cant count_less_than_difficulty, ${e.message}")
                }
            }
            "help" -> {
                logger.info("User: got help")
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
                    logger.info("User: data saved")
                } catch(e: Exception){
                    println("Can not save to json")
                    println("Error: ${e.message}")
                    logger.error("Error: Can not save to json, ${e.message}")
                }
            }
            "execute_script" -> {
                logger.info("User: execute script")
                scan = BufferedReader(InputStreamReader(FileInputStream(command[1])))
            }
            else -> {
                println("Вы ввели говно.")
                logger.warn("User: Invalid command")
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
            if (name == "" || name == "null") {
                println("Name can not be empty")
                logger.warn("Name can not be empty")
            }
            else {
                logger.info("User entered name")
                break
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
            logger.error("Error: cant enter name, ${e.message}")
        }
    }
    var entries: List<String>
    var coordinates: Coordinates
    while (true) {
        print("Enter coordinates: ")
        entries = scan.readLine().split(" ")
        try {
            coordinates = Coordinates(entries[0].toLong(), entries[1].toLong())
            logger.info("User entered coordinates")
            break
        } catch (e: Exception) {
            println("Error: ${e.message}")
            logger.error("Error: cant enter coordinates, ${e.message}")
        }
    }
    var minimalPoint: Long
    while (true) {
        print("Enter minimalPoint: ")
        try {
            minimalPoint = scan.readLine().toLong()
            if (minimalPoint < 0) {
                println("minimalPoint can not less than 0")
                logger.warn("minimalPoint can not less than 0")
            }
            else {
                logger.info("User entered minimalPoint")
                break
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
            logger.error("Error: cant enter minimalPoint, ${e.message}")
        }
    }
    var difficulty: Difficulty
    while (true) {
        print("Enter difficulty (VERY_EASY, NORMAL, HARD, VERY_HARD, TERRIBLE): ")
        try {
            difficulty = Difficulty.valueOf(scan.readLine())
            logger.info("User entered difficulty")
            break
        } catch (e: Exception) {
            println("Error: ${e.message}")
            logger.error("Error: cant enter difficulty, ${e.message}")
        }
    }
    var discipline: Discipline
    while (true) {
        print("Enter discipline: ")
        entries = scan.readLine().split(" ")
        try {
            discipline = Discipline(if (entries[0] == "null") " " else entries[0], entries[1].toInt())
            logger.info("User entered discipline")
            break
        } catch (e: Exception) {
            println("Error: ${e.message}")
            logger.error("Error: cant enter discipline, ${e.message}")
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
