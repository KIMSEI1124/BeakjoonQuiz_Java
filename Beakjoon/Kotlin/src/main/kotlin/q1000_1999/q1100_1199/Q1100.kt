package q1000_1999.q1100_1199

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var total = 0
    var black = 0
    for (y in 0..7) {
        var x = 0
        br.readLine()
            .toCharArray()
            .map {
                x++
                if (it == 'F') {
                    total++
                    if (y % 2 == 0 && x % 2 == 0
                        || y % 2 == 1 && x % 2 == 1
                    ) {
                        black++
                    }
                }
            }
    }
    println(total - black)
}