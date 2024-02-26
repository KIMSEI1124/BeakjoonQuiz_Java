package q1000_1999.q1200_1299

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val answer = StringBuilder()

private const val DRAW: String = "SYJKGW\n"

private val map = HashMap<Long, Int>()

private var t: Int = 0

private fun main() {
    val n: Int = br.readLine().toInt()
    for (i in 1..n) {
        input()
        solve()
    }
    println(answer)
}

private fun input() {
    map.clear()
    val st = StringTokenizer(br.readLine())
    t = st.nextToken().toInt()
    for (i in 1..t) {
        val unit = st.nextToken().toLong()
        if (!map.contains(unit)) {
            map[unit] = 0
        }
        map[unit] = map[unit]!!.plus(1)
    }
}

private fun solve() {
    for (i in map.keys) {
        if (map[i]!! > t / 2) {
            answer.append(i).append("\n")
            return
        }
    }
    answer.append(DRAW)
}