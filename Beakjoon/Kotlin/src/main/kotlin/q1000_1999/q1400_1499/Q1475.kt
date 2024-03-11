package q1000_1999.q1400_1499

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

private var array = Array(10) { 0 }

fun main() {
    var answer = 0
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine().toCharArray().map {
        val number = it.toString().toInt()
        array[number]++
    }
    array[6] += array[9]
    array[6] = (array[6] / 2) + array[6] % 2
    for (i in 0..8) {
        answer = max(answer, array[i])
    }
    println(answer)
}