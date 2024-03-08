package q2000_2999.q2400_2499

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


private var N = 0
private val LIST = ArrayList<Int>()
private val ANSWER = StringBuilder()

fun main() {
    input()
    solve()
    println(ANSWER)
}

private fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    br.readLine()
        .split(" ").map {
            LIST.add(it.toInt())
        }
}

private fun solve() {
    LIST.sort()
    var diff = Long.MAX_VALUE
    for (i in 0..<LIST.size) {
        val target = -LIST[i].toLong()

        var start = i;
        var end = LIST.size - 1
        var mid: Int

        while (start <= end) {
            mid = (start + end) / 2
            if (mid == i) {
                start = mid + 1
                continue
            }

            if (LIST[mid] < target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
            if (diff > min(diff, abs(target - LIST[mid]))) {
                diff = min(diff, abs(target - LIST[mid]))
                ANSWER.clear()
                ANSWER.append(min(LIST[mid], LIST[i]))
                    .append(" ")
                    .append(max(LIST[mid], LIST[i]))
            }
        }
    }
}