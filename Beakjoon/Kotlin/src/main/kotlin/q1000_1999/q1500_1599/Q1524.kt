package q1000_1999.q1500_1599

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
private val answer: StringBuilder = StringBuilder()

private var n: Int = 0
private var m: Int = 0

lateinit var arr1: ArrayDeque<Int>
lateinit var arr2: ArrayDeque<Int>

fun main() {
    val t: Int = br.readLine().toInt()
    for (i in 1..t) {
        input()
        solve()
    }
    println(answer)
}

private fun input() {
    br.readLine()   // 공백
    val st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    // https://blog.yevgnenll.me/posts/remove-stream-in-kotlin
    arr1 = br.readLine().split(" ")
        .map { it.toInt() }
        .toCollection(ArrayDeque())
        .apply { sorted() }
    arr2 = br.readLine().split(" ")
        .map { it.toInt() }
        .toCollection(ArrayDeque())
        .apply { sorted() }
}

private fun solve() {
    while (arr1.isNotEmpty() && arr2.isNotEmpty()) {
        val o1: Int = arr1.first
        val o2: Int = arr2.first
        if (o1 < o2) {
            arr1.pollFirst()
        } else {
            arr2.pollFirst()
        }
    }

    if (arr1.isEmpty() && arr2.isEmpty()) {
        answer.append("C")
    } else if (arr1.isEmpty()) {
        answer.append("B")
    } else {
        answer.append("S")
    }
    answer.append("\n")
}