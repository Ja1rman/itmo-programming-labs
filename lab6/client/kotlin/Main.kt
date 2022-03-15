import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import entities.Coordinates
import entities.Difficulty
import entities.Discipline
import entities.LabWork
import java.io.*
import java.net.Socket
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.net.ConnectException
import java.net.SocketException

var scan = BufferedReader(InputStreamReader(System.`in`))
val mapper = jacksonObjectMapper()

fun main() {
    val client: Socket
    val output: PrintWriter
    val input: BufferedReader
    try{
        client = Socket("127.0.0.1", 8080)
        output = PrintWriter(client.getOutputStream(), true)
        input = BufferedReader(InputStreamReader(client.inputStream))
    } catch (e: Exception) {
        if (e is ConnectException) println("Сервек АФК")
        println("Error: ${e.message}")
        return
    }
    while (true) {
        print(">>> ")
        var commands = scan.readLine() ?: "-1a"
        if (commands == "-1a") {
            scan = BufferedReader(InputStreamReader(System.`in`))
            commands = scan.readLine()
        }
        val command = commands.split(" ")
        try {
            when (command[0]) {
                "exit" -> {
                    client.close()
                    return
                }
                "add" -> {
                    val res = enterVals()
                    val json = mapper.writeValueAsString(mapOf("command" to "add", "obj" to res))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "show" -> {
                    val json = mapper.writeValueAsString(mapOf("command" to "show"))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "remove_last" -> {
                    val json = mapper.writeValueAsString(mapOf("command" to "remove_last"))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "info" -> {
                    val json = mapper.writeValueAsString(mapOf("command" to "info"))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "clear" -> {
                    val json = mapper.writeValueAsString(mapOf("command" to "clear"))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "remove_by_id" -> {
                    val json = mapper.writeValueAsString(mapOf("command" to "remove_by_id", "id" to command[1]))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "update" -> {
                    val res = enterVals()
                    val json = mapper.writeValueAsString(mapOf("command" to "update",
                                                               "id" to command[1],
                                                               "obj" to res))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "add_if_max" -> {
                    val res = enterVals()
                    val json = mapper.writeValueAsString(mapOf("command" to "add_if_max",
                        "obj" to res))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "remove_lower" -> {
                    val res = enterVals()
                    val json = mapper.writeValueAsString(mapOf("command" to "remove_lower",
                        "obj" to res))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "remove_all_by_minimal_point" -> {
                    val json = mapper.writeValueAsString(mapOf("command" to "remove_all_by_minimal_point",
                        "mp" to command[1]))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "sum_of_minimal_point" -> {
                    val json = mapper.writeValueAsString(mapOf("command" to "sum_of_minimal_point"))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "count_less_than_difficulty" -> {
                    val json = mapper.writeValueAsString(mapOf("command" to "count_less_than_difficulty",
                        "difficulty" to Difficulty.valueOf(command[1])))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "help" -> {
                    val json = mapper.writeValueAsString(mapOf("command" to "help"))
                    output.println(json)
                    do println(input.readLine())
                    while (input.ready())
                }
                "execute_script" -> {
                    scan = BufferedReader(InputStreamReader(FileInputStream(command[1])))
                }
                else -> {
                    println("Вы ввели говно.")
                }
            }
        } catch (e: Exception) {
            if (e is SocketException){
                println("Сервер АФК")
                return
            }
            println("Error: ${e.message}")
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
            }
            else {
                break
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
        }
    }
    var minimalPoint: Long
    while (true) {
        print("Enter minimalPoint: ")
        try {
            minimalPoint = scan.readLine().toLong()
            if (minimalPoint < 0) {
                println("minimalPoint can not less than 0")
            }
            else {
                break
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
    var difficulty: Difficulty
    while (true) {
        print("Enter difficulty (VERY_EASY, NORMAL, HARD, VERY_HARD, TERRIBLE): ")
        try {
            difficulty = Difficulty.valueOf(scan.readLine())
            break
        } catch (e: Exception) {
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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


