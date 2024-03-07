package q2000_2999.q2500_2599

import java.io.BufferedReader
import java.io.InputStreamReader

private var N = 0;
private var TOTAL = 0;
private val LIST = ArrayList<Int>()
private var answer = Int.MAX_VALUE
fun main() {
    input()
    solve()
    println(answer)
}

private fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    br.readLine()
        .split(" ").map {
            LIST.add(it.toInt())
        }
    TOTAL = br.readLine().toInt()
}

private fun solve() {
    LIST.sort()
    var start = 1
    var end = LIST[LIST.size - 1]
    var mid: Int
    while (start <= end) {
        mid = (start + end) / 2
        val total = calc(mid)
        when {
            total <= TOTAL -> {
                answer = mid
                start = mid + 1
            }

            total > TOTAL -> {
                end = mid - 1
            }
        }
    }
}

private fun calc(money: Int): Int {
    var total = 0
    for (i: Int in LIST) {
        total += if (i > money) money else i
    }
    return total
}