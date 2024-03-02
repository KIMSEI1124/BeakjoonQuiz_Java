package q1000_1999.q1700_1799

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val answer = StringBuilder()

private var N: Int = 0
private var TOTAL: Int = 0
lateinit var st: StringTokenizer
private val map: HashMap<Int, Pic> = HashMap()

fun main() {
    input()
    solve()
    println(answer)
}

private fun input() {
    N = br.readLine().toInt()
    TOTAL = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
}

private fun solve() {
    for (i in 1..TOTAL) {
        val id = st.nextToken().toInt()
        if (map.contains(id)) {
            map[id]!!.count++
            continue
        }
        if (map.size == N) {
            var removeId = 0
            var minCount: Int = Int.MAX_VALUE
            var minTime: Int = Int.MAX_VALUE
            for (key: Int in map.keys) {
                val pic = map[key]!!
                if (pic.count < minCount) {
                    minCount = pic.count
                    minTime = pic.updateTime
                    removeId = key
                    continue
                }
                if (pic.count == minCount && pic.updateTime < minTime) {
                    minTime = pic.updateTime
                    removeId = key
                }
            }
            map.remove(removeId)
        }
        map[id] = Pic(1, i)
    }
    map.keys.sorted().map {
        answer.append(it).append(" ")
    }
}

class Pic(
    var count: Int,
    var updateTime: Int
) {
    override fun toString(): String {
        return "Pic(count=$count, updateTime=$updateTime)"
    }
}