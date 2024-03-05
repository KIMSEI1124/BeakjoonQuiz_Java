package q27000_27999.q27700_27799

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque


private val answer = StringBuilder()

private var N: Int = 0
private var M: Int = 0
private var DEFAULT_M: Int = 0
private var K: Int = 0
private var arr: Array<IntArray> = arrayOf()

fun main() {
    input()
    solve()
    println(answer)
}

private fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    DEFAULT_M = M
    K = st.nextToken().toInt()
    arr = Array(N + 1) { IntArray(N + 1) }
    for (y in 1..N) {
        st = StringTokenizer(br.readLine())
        for (x in 1..N) {
            arr[y][x] = st.nextToken().toInt()
        }
    }
}

private fun solve() {
    for (y in 1..N) {
        for (x in 1..N) {
            if (arr[y][x] == 0 && search(y, x)) {
                answer.append("IMPOSSIBLE")
                return
            }
        }
    }
    if (M == DEFAULT_M) {
        answer.append("IMPOSSIBLE")
        return
    }
    answer.append("POSSIBLE")
        .append("\n")
        .append(M)
}

private val dy: Array<Int> = arrayOf(-1, 0, 0, 1)
private val dx: Array<Int> = arrayOf(0, -1, 1, 0)
private fun search(y: Int, x: Int): Boolean {
    var quantity = 1
    val deque = ArrayDeque<Pos>()
    deque.addLast(Pos(y, x))
    arr[y][x] = 2
    while (deque.isNotEmpty()) {
        val pos = deque.removeFirst()
        for (d in 0..3) {
            val newY: Int = pos.y + dy[d]
            val newX: Int = pos.x + dx[d]
            if (newY < 1 || newY > N
                || newX < 1 || newX > N
                || arr[newY][newX] == 1
                || arr[newY][newX] == 2
            ) {
                continue
            }
            quantity++
            arr[newY][newX] = 2
            deque.addLast(Pos(newY, newX))
        }
    }
    M -= quantity / K + if (quantity % K == 0) 0 else 1
    return M < 0
}

private data class Pos(
    val y: Int,
    val x: Int
)