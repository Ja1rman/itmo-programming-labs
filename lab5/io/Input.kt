package io

import java.io.FileInputStream
import java.io.InputStreamReader

object Input {
    fun read(filename: String): String {
        return InputStreamReader(FileInputStream(filename)).readText()
    }
}