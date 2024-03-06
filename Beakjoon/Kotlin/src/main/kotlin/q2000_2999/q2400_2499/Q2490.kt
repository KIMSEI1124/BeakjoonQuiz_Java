package q2000_2999.q2400_2499

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val answer = StringBuilder()
    for (i in 1..3) {
        val st = StringTokenizer(br.readLine())
        var front = 0;
        while (st.hasMoreTokens()) {
            val num = st.nextToken().toInt()
            if (num == 0) {
                front++
            }
        }
        when (front) {
            0 -> {
                answer.append("E")
            }

            1 -> {
                answer.append("A")
            }

            2 -> {
                answer.append("B")
            }

            3 -> {
                answer.append("C")
            }

            else -> {
                answer.append("D")
            }
        }
        answer.append("\n")
    }
    println(answer)
}